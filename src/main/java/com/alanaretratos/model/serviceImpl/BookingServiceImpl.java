package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.BookingDTO;
import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.repository.BookingRepository;
import com.alanaretratos.model.service.BookingService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BookingServiceImpl implements BookingService {

	@Inject
	BookingRepository bookingRepository;

	@Override
	public void createBooking(BookingDTO bookingDTO) throws Exception {
		Booking booking = bookingRepository.findById(bookingDTO.getId());
		if (booking.equals(null)) {
			booking.setBookedDate(bookingDTO.getBookingDate());
			booking.setDeliveryDate(bookingDTO.getDeliveryDate());
			booking.setExtraPhoto(bookingDTO.isPaidExtraPhoto());
			booking.setPaidExtraPhoto(bookingDTO.isExtraPhoto());
			booking.setPaidProduct(bookingDTO.isPaidProduct());
			booking.setPaidRemaining(bookingDTO.isPaidRemaining());
			booking.setProducts(bookingDTO.getProducts());
			booking.setTotalPrice(bookingDTO.getTotalPrice());

			booking.persist();
		} else {
			throw new Exception("Couldn't create this Booking");
		}

	}

	@Override
	public List<Booking> listAllBookings() {
		return bookingRepository.findAllActivated();
	}

	@Override
	public Booking getBookingById(Long id) {
		Booking booking = bookingRepository.findByIdOptional(id).orElseThrow();
		return booking;
	}

	public Booking getBookingByName(String name) {
		Booking booking = bookingRepository.find("name", name).singleResult();
		return booking;
	}

	@Override
	public void updateBooking(BookingDTO bookingDTO) throws Exception {

		Booking booking = bookingRepository.findByIdOptional(bookingDTO.getId()).orElseThrow();

		booking.setBookedDate(bookingDTO.getBookingDate());
		booking.setDeliveryDate(bookingDTO.getDeliveryDate());
		booking.setExtraPhoto(bookingDTO.isPaidExtraPhoto());
		booking.setPaidExtraPhoto(bookingDTO.isExtraPhoto());
		booking.setPaidProduct(bookingDTO.isPaidProduct());
		booking.setPaidRemaining(bookingDTO.isPaidRemaining());
		booking.setProducts(bookingDTO.getProducts());
		booking.setTotalPrice(bookingDTO.getTotalPrice());

		booking.persist();

	}

	@Override
	public void deleteBookingFromDB(Long id) throws Exception {
		Booking booking = bookingRepository.findByIdOptional(id).orElseThrow();

		bookingRepository.delete(booking);
	}

	public void deleteBookingFromView(Long id) throws Exception {
		Booking booking = bookingRepository.findByIdOptional(id).orElseThrow();
		booking.setStatus(UtilConstants.STATUS_DEACTIVATED);

		booking.persist();

	}

}
