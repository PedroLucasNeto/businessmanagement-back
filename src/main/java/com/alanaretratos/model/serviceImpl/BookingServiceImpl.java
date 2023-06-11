package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.BookingDTOForm;
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
	public void createBooking(BookingDTOForm bookingDTO) throws Exception {
		Booking booking = new Booking();
		BeanUtils.copyProperties(booking, bookingDTO);

		booking.persist();

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
	public void updateBooking(BookingDTOForm bookingDTO) throws Exception {

		//TODO arrumar o metodo
		Booking booking = bookingRepository.findByIdOptional((long) 1).orElseThrow();
		BeanUtils.copyProperties(bookingDTO, booking);

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
