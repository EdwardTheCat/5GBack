
package fr.ynov.discussion.services;

import com.fasterxml.jackson.core.io.JsonEOFException;
import fr.ynov.discussion.providers.DiscussionProvider;
import fr.ynov.discussion.ressources.Discussion;
import fr.ynov.discussion.ressources.DiscussionRequest;
import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;
import fr.ynov.user.ressources.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.Object;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class with discussion REST Services
 * @author Ludovic
 * since v0
 */

@RestController
@RequestMapping("/restapi/discussions")
public class DiscussionService {
    /**
     * Provider of Discussion property
     */
    DiscussionProvider discussionProvider;

    /**
     * Method which returns discussion in Json shape from dynamic route (/restapi/discussions/get-or-create)
     *
     * @param token token header content
     * @param request body content
     * @return Response objects auto-transformed in json shape by dependency @see EnumResponse
     */
    @PostMapping(value = "/get-or-create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getOrCreatDiscussion(@RequestHeader(value="token") String token, @RequestBody DiscussionRequest request) throws Exception {
        //TODO: Verif token with header
        discussionProvider = new DiscussionProvider();
        if (request.getMembers().size() == 0) {
            Discussion discussion = discussionProvider.findDiscussionByName(request.getDiscussionName());
            if (discussion != null) {
                return new Response(ResponseEnum.discussionRetrieved.getType(), ResponseEnum.discussionRetrieved.getCode(), ResponseEnum.discussionRetrieved.getDescription(), discussion);
            } else {
                return new Response(ResponseEnum.noMemberList.getType(), ResponseEnum.noMemberList.getCode(), ResponseEnum.noMemberList.getDescription());
            }
        } else {
            Discussion discussion = discussionProvider.findDiscussionByUsers(request.getMembers());
            if (discussion != null) {
                return new Response(ResponseEnum.discussionRetrieved.getType(), ResponseEnum.discussionRetrieved.getCode(), ResponseEnum.discussionRetrieved.getDescription(), discussion);
            } else {
                if (request.getMembers().size() > 0) {
                    if (request.getMembers().size() <= 9) {
                        discussion = new Discussion(request.getDiscussionName(),request.getMembers());
                        discussionProvider.addDiscussion(discussion);
                        return new Response(ResponseEnum.discussionCreated.getType(), ResponseEnum.discussionCreated.getCode(), ResponseEnum.discussionCreated.getDescription(), discussion);
                    } else {
                        return new Response(ResponseEnum.tooMuchPeople.getType(), ResponseEnum.tooMuchPeople.getCode(), ResponseEnum.tooMuchPeople.getDescription());
                    }
                } else {
                    return new Response(ResponseEnum.noMemberList.getType(), ResponseEnum.noMemberList.getCode(), ResponseEnum.noMemberList.getDescription());
                }
            }
        }
    }

    @PostMapping(value = "/add-member", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addMember(@RequestHeader(value="token") String token, @RequestBody DiscussionRequest request) throws Exception {
        discussionProvider = new DiscussionProvider();
        Discussion discussion = discussionProvider.findDiscussionById(request.getDiscussionId());
        if (discussion.getCreator() == null){
            for (int user : request.getNewMembers()) {
                if (discussion.addUser(user) > 9) {
                    return new Response(ResponseEnum.tooMuchPeople.getType(), ResponseEnum.tooMuchPeople.getCode(), ResponseEnum.tooMuchPeople.getDescription());
                }
            }
            discussionProvider.updateDiscussion(discussion);
            return new Response(ResponseEnum.memberAdded.getType(), ResponseEnum.memberAdded.getCode(), ResponseEnum.memberAdded.getDescription());
        }else{
            return new Response(ResponseEnum.notDiscussionCreator.getType(), ResponseEnum.notDiscussionCreator.getCode(), ResponseEnum.notDiscussionCreator.getDescription());
        }
    }

    @PostMapping(value = "/leave", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response leaveMember(@RequestHeader(value="token") String token, @RequestBody DiscussionRequest request) throws Exception {
        discussionProvider = new DiscussionProvider();
        Discussion discussion = discussionProvider.findDiscussionById(request.getDiscussionId());
        if (discussion != null){
            if (request.isForce() == true) {
                if (true) {
                    discussionProvider.deleteDiscussion(discussion.getId());
                    return new Response(ResponseEnum.discussionDeleted.getType(), ResponseEnum.discussionDeleted.getCode(), ResponseEnum.discussionDeleted.getDescription());
                }else {
                    return new Response(ResponseEnum.mustForceDiscussionLeaving.getType(), ResponseEnum.mustForceDiscussionLeaving.getCode(), ResponseEnum.mustForceDiscussionLeaving.getDescription());
                }
            } else {
                discussion.leaveUser(request.getDiscussionId());
                discussionProvider.updateDiscussion(discussion);
                return new Response(ResponseEnum.discussionLeft.getType(), ResponseEnum.discussionLeft.getCode(), ResponseEnum.discussionLeft.getDescription());
            }
        } else {
           return new Response(ResponseEnum.cantLeaveTheDiscussion.getType(), ResponseEnum.cantLeaveTheDiscussion.getCode(), ResponseEnum.cantLeaveTheDiscussion.getDescription());
        }
    }
}