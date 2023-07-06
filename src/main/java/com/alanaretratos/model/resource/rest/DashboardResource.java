package com.alanaretratos.model.resource.rest;

import java.time.LocalDate;

import com.alanaretratos.model.service.DashboardService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashboardResource {
	
	@Inject
	DashboardService dashboardService;
	
	@GET
	@Path("/monthlyIncome")
	public Response monthlyIncome() {
		
	    double income = 0;
	    
		try {
			income = dashboardService.monthlyIncome();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	    return Response.ok(income).build();
	}
	
	@GET
	@Path("/monthlyOutcome")
	public Response monthlyOutcome() {
		
	    double income = 0;
	    
		try {
			income = dashboardService.monthyOutcome();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	    return Response.ok(income).build();
	}
	

	@GET
	@Path("/periodIncome")
	public Response periodIncome(LocalDate startingDate, LocalDate endingDate) {
		
	    double income = 0;
	    
		try {
			income = dashboardService.periodIncome(startingDate, endingDate);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	    return Response.ok(income).build();
	}
	
	@GET
	@Path("/periodOutcome")
	public Response periodOutcome(LocalDate startingDate, LocalDate endingDate) {
		
	    double income = 0;
	    
		try {
			income = dashboardService.periodOutcome(startingDate, endingDate);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	    return Response.ok(income).build();
	}
	



	
}
