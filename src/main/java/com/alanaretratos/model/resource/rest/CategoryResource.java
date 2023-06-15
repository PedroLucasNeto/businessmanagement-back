package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.Form.CategoryDTOForm;
import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.service.CategoryService;

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
import lombok.Data;

@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Data
public class CategoryResource {
	
	@Inject
	CategoryService categoryService;
	
	@POST
	public Response createCategory(CategoryDTOForm categoryDTO) {
		try {
			categoryService.createCategory(categoryDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getCategoryById(@PathParam("id") Long id) {
		Category category = new Category();
		try {
			 category = categoryService.getCategoryById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(category).build();
	}
	
	@GET
	public Response listCategory() {
		List<Category>category = new ArrayList<>();
		try {
			 category = categoryService.listAllCategories();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(category).build();
	}

	@PUT
	public Response updateCategory(CategoryDTOForm categoryDTO) {
		try {
			categoryService.updateCategory(categoryDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCategoryView(@PathParam(value = "id")Long id) {
		try {
			categoryService.deleteCategoryFromView(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteCategoryDB(@PathParam(value = "id")Long id) {
		try {
			categoryService.deleteCategoryFromDB(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
