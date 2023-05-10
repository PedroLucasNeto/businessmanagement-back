package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.ClientDTO;
import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.service.ClientService;

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

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

	@Inject
	ClientService clientService;

	@POST
	public Response createClient(ClientDTO clientDTO) {
		try {
			clientService.createClient(clientDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getClientById(@PathParam("id") Long id) {
		Client client = new Client();
		try {
			client = clientService.getClientById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(client).build();
	}

	@GET
	public Response listClient() {
		List<Client> client = new ArrayList<>();
		try {
			client = clientService.listAllClients();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(client).build();
	}

	@PUT
	public Response updateClient(ClientDTO clientDTO) {
		try {
			clientService.updateClient(clientDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteClientView(Long id) {
		try {
			clientService.getClientById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteClientDB(Long id) {
		try {
			clientService.getClientById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
