package fr.ynov.users.services;

import fr.ynov.users.providers.UsersProvider;
import fr.ynov.users.resources.User;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/users")
public class UsersServiceImpl implements UsersService {

    @Override
    public Response getAllUsers() {
        return Response.ok(UsersProvider.getAllUsers()).build();
    }

    @Override
    public Response getShape(String userId, String password) {
        if (userId== null || password == null){
          return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(UsersProvider.findUser(userId) == null) {
            return Response.status(404).build();
        }
        User user = UsersProvider.findUser(userId);
        if (user.getPassword() != password){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok(user).build();

    }

    @Override
    public Response registerUser(String userJson) {
        try{
            JSONObject userJsonObj = new JSONObject(userJson);
            User user = new User(userJsonObj.getString("id"), userJsonObj.getString("password"),userJsonObj.getString("name"));
            UsersProvider.createUser(user);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e){
            return Response.status(400).build();
        }
    }
}
