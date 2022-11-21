package com.gara.resource;

import com.gara.entity.User;
import com.gara.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @POST
    public void createUser(@QueryParam String name) {
        userService.createUser(name);
    }

    @GET
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Long id) {
        return userService.getUser(id);
    }

    @PUT
    @Path("/{id}")
    public void activateUser(@PathParam("id") Long id) {
        userService.activateUser(id);
    }

}