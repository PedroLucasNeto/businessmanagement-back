package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.Form.PhotoShootTypeDTOForm;
import com.alanaretratos.model.entity.PhotoShootType;
import com.alanaretratos.model.service.PhotoShootTypeService;

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

@Path("/photoshoottype")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PhotoShootTypeResource {
	
	@Inject
	PhotoShootTypeService photoShootTypeService;
	
	@POST
	public Response createPhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) {
		try {
			photoShootTypeService.createPhotoShootType(photoShootTypeDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getPhotoShootTypeById(@PathParam("id") Long id) {
		PhotoShootType photoShootType = new PhotoShootType();
		try {
			 photoShootType = photoShootTypeService.getPhotoShootTypeById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(photoShootType).build();
	}
	
	@GET
	public Response listPhotoShootType() {
		List<PhotoShootType>photoShootType = new ArrayList<>();
		try {
			 photoShootType = photoShootTypeService.listAllPhotoShootTypes();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(photoShootType).build();
	}

	@PUT
	public Response updatePhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) {
		try {
			photoShootTypeService.updatePhotoShootType(photoShootTypeDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deletePhotoShootTypeView(Long id) {
		try {
			photoShootTypeService.getPhotoShootTypeById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deletePhotoShootTypeDB(Long id) {
		try {
			photoShootTypeService.getPhotoShootTypeById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
