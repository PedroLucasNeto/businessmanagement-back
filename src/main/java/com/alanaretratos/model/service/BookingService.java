package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.BookingDTO;
import com.alanaretratos.model.entity.Booking;

import jakarta.ws.rs.PathParam;

public interface BookingService {

	void createBooking(BookingDTO bookingDTO) throws Exception;

	List<Booking> listAllBookings();

	Booking getBookingById(Long id);

	void updateBooking(BookingDTO bookingDTO) throws Exception;

	void deleteBookingFromView(@PathParam("id") Long id) throws Exception;

	void deleteBookingFromDB(Long id) throws Exception;
}
