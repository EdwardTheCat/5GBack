package fr.ynov.users.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UsersService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAllUsers();

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUser(@PathParam("userId") String userId,@QueryParam("password") String password);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response registerUser(String userJson);

}
