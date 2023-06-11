package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.BookingDTOForm;
import com.alanaretratos.model.entity.Booking;

import jakarta.ws.rs.PathParam;

public interface BookingService {

	void createBooking(BookingDTOForm bookingDTO) throws Exception;

	List<Booking> listAllBookings();

	Booking getBookingById(Long id);

	void updateBooking(BookingDTOForm bookingDTO) throws Exception;

	void deleteBookingFromView(@PathParam("id") Long id) throws Exception;

	void deleteBookingFromDB(Long id) throws Exception;
}
