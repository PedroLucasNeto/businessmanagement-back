package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.DTO.PricingDTO;
import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.service.PricingService;

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

@Path("/pricing")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PricingResource {

	@Inject
	PricingService pricingService;

	@POST
	public Response createPricing(PricingDTO pricingDTO) {
		try {
			pricingService.createPricing(pricingDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getPricingById(@PathParam("id") Long id) {
		Pricing pricing = new Pricing();
		try {
			pricing = pricingService.getPricingById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(pricing).build();
	}

	@GET
	public Response listPricing() {
		List<Pricing> pricing = new ArrayList<>();
		try {
			pricing = pricingService.listAllPricings();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(pricing).build();
	}

	@PUT
	public Response updatePricing(PricingDTO pricingDTO) {
		try {
			pricingService.updatePricing(pricingDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deletePricingView(Long id) {
		try {
			pricingService.getPricingById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deletePricingDB(Long id) {
		try {
			pricingService.getPricingById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
