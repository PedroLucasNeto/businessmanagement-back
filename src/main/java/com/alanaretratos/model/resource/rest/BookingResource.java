package com.alanaretratos.model.resource.rest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.alanaretratos.model.DTO.Form.BookingDTOForm;
import com.alanaretratos.model.DTO.View.BookingDTOView;
import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.service.BookingService;

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

@Path("/bookings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Booking", description = "Booking Operations")
public class BookingResource {

	@Inject
	BookingService bookingService;

	@POST
	public Response createBooking(BookingDTOForm bookingDTO) {
		try {
			bookingService.createBooking(bookingDTO);
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).build();
		}
		return Response.status(Status.CREATED.getStatusCode()).build();
	}

	@GET
	@Path("{id}")
	public Response getBookingById(@PathParam("id") Long id) {
		Booking booking = new Booking();
		try {
			 booking = bookingService.getBookingById(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(booking).build();
	}
	
	@GET
	public Response listBooking() {
		List<BookingDTOView> booking = new ArrayList<>();
		try {
			 booking = bookingService.listAllBookings();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.ok(booking).build();
	}

	@PUT
	public Response updateBooking(BookingDTOForm bookingDTO) {
		try {
			bookingService.updateBooking(bookingDTO);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteBookingView(@PathParam(value = "id")Long id) {
		try {
			bookingService.deleteBookingFromView(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}

	@DELETE
	@Path("/fromdb/{id}")
	public Response deleteBookingDB(@PathParam(value = "id")Long id) {
		try {
			bookingService.deleteBookingFromDB(id);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST.getStatusCode()).build();
		}
		return Response.status(Status.ACCEPTED.getStatusCode()).build();
	}
}
