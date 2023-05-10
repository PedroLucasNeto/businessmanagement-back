package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.UserDTO;
import com.alanaretratos.model.entity.User;
import com.alanaretratos.model.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@Inject
	UserService userService;
	
	@POST
	public Response createUser(UserDTO userDTO) {
		try {
			userService.createUser(userDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") Long id) {
		User user = new User();
		try {
			 user = userService.getUserById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(user).build();
	}
	
	@GET
	public Response listUser() {
		List<User>user = new ArrayList<>();
		try {
			 user = userService.listAllUsers();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(user).build();
	}

	@PUT
	public Response updateUser(UserDTO userDTO) {
		try {
			userService.updateUser(userDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteUserView(Long id) {
		try {
			userService.getUserById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteUserDB(Long id) {
		try {
			userService.getUserById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
