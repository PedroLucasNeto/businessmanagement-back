package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.Form.TransactionDTOForm;
import com.alanaretratos.model.entity.Transaction;
import com.alanaretratos.model.service.TransactionService;

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

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
	
	@Inject
	TransactionService transactionService;
	
	@POST
	public Response createTransaction(TransactionDTOForm transactionDTO) {
		try {
			transactionService.createTransaction(transactionDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getTransactionById(@PathParam("id") Long id) {
		Transaction transaction = new Transaction();
		try {
			 transaction = transactionService.getTransactionById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(transaction).build();
	}
	
	@GET
	public Response listTransaction() {
		List<Transaction>transaction = new ArrayList<>();
		try {
			 transaction = transactionService.listAllTransactions();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(transaction).build();
	}

	@PUT
	public Response updateTransaction(TransactionDTOForm transactionDTO) {
		try {
			transactionService.updateTransaction(transactionDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteTransactionView(@PathParam(value = "id")Long id) {
		try {
			transactionService.deleteTransactionFromView(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteTransactionDB(@PathParam(value = "id")Long id) {
		try {
			transactionService.deleteTransactionFromDB(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
