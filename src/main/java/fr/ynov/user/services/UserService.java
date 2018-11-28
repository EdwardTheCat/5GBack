package fr.ynov.user.services;

import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.Users;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restapi/members")
public class UserService {

    UserProvider userProvider;

    @GetMapping(value = "/get-all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll(@RequestBody String json) throws Exception {
        JSONObject jsonObject = new JSONObject(json);
        //TODO: token verif
        if (jsonObject.get("token") == "" ){
            userProvider = new UserProvider();
            Users users = userProvider.selectAllUsers();
            return new Response(ResponseEnum.memberList.getType(),ResponseEnum.memberList.getCode(),ResponseEnum.memberList.getDescription(),users);
        } else {
            return new Response(ResponseEnum.heartbeatError.getType(),ResponseEnum.heartbeatError.getCode(),ResponseEnum.heartbeatError.getDescription());
        }
    }

    @GetMapping(value = "/get-onlines", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getOnlines(@RequestBody String json) throws Exception {
        JSONObject jsonObject = new JSONObject(json);
        //TODO: token verif
        if (jsonObject.get("token") == "" ){
            userProvider = new UserProvider();
            Users users = userProvider.selectAllConnectedUsers();
            return new Response(ResponseEnum.connectedMemberList.getType(),ResponseEnum.connectedMemberList.getCode(),ResponseEnum.connectedMemberList.getDescription(),users);
        } else {
            return new Response(ResponseEnum.heartbeatError.getType(),ResponseEnum.heartbeatError.getCode(),ResponseEnum.heartbeatError.getDescription());
        }
    }
}
