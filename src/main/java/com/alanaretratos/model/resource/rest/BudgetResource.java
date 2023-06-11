package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.Form.BudgetDTOForm;
import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.service.BudgetService;

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

@Path("/budget")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BudgetResource {

	@Inject
	BudgetService budgetService;

	@POST
	public Response createBudget(BudgetDTOForm budgetDTO) {
		try {
			budgetService.createBudget(budgetDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getBudgetById(@PathParam("id") Long id) {
		Budget budget = new Budget();
		try {
			budget = budgetService.getBudgetById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(budget).build();
	}

	@GET
	public Response listBudget() {
		List<Budget> budget = new ArrayList<>();
		try {
			budget = budgetService.listAllBudgets();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(budget).build();
	}

	@PUT
	public Response updateBudget(BudgetDTOForm budgetDTO) {
		try {
			budgetService.updateBudget(budgetDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteBudgetView(Long id) {
		try {
			budgetService.getBudgetById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteBudgetDB(Long id) {
		try {
			budgetService.getBudgetById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

}
