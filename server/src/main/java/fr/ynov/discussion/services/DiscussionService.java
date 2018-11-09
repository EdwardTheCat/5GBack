package fr.ynov.discussion.services;

import com.fasterxml.jackson.core.io.JsonEOFException;
import fr.ynov.discussion.providers.DiscussionProvider;
import fr.ynov.discussion.ressources.Discussion;
import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController

/**
 * Class with discussion REST Services
 * @author Ludovic
 * since v0
 */
public class DiscussionService {
    /**
     * Provider of Discussion property
     */
    DiscussionProvider discussionProvider;

    /**
     * Method which returns discussion in Json shape from dynamic route (/restapi/discussions/get-or-create)
     * @param header header content
     * @param body body content
     * @return Response objects auto-transformed in json shape by dependency @see EnumResponse
     */
    @GetMapping("/restapi/discussions/get-or-create")
    public Response getOrCreatDiscussion(@RequestHeader Map<String, String> header, @RequestBody Map<String, String> body) throws SQLException,ClassNotFoundException {
        //TODO: Verif token with header

        discussionProvider = new DiscussionProvider();
        if (body.containsKey("label")){
            Discussion discussion = discussionProvider.findDiscussionByName(body.get("label"));
            if(discussion != null){
                return new Response(ResponseEnum.discussionRetrieved.getType(),ResponseEnum.discussionRetrieved.getCode(), ResponseEnum.discussionRetrieved.getDescription(),discussion);
            } else {
                if (body.containsKey("users")){
                        if (body.get("users").length() <= 20){
                            discussion = new Discussion(body.get("label"),body.get("users"));
                            return new Response(ResponseEnum.discussionCreated.getType(),ResponseEnum.discussionCreated.getCode(), ResponseEnum.discussionCreated.getDescription(), discussion);
                        } else {
                            return new Response(ResponseEnum.tooMuchPeople.getType(),ResponseEnum.tooMuchPeople.getCode(), ResponseEnum.tooMuchPeople.getDescription());
                        }
                } else {
                    return new Response(ResponseEnum.noMemberList.getType(),ResponseEnum.noMemberList.getCode(), ResponseEnum.noMemberList.getDescription());
                }
            }
        } else{
            new Response(ResponseEnum.discussionRetrieved.getType(),ResponseEnum.discussionRetrieved.getCode(), ResponseEnum.discussionRetrieved.getDescription());
        }
        return null;
    }


}
