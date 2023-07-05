package com.alanaretratos.model.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.BookingDTOForm;
import com.alanaretratos.model.DTO.View.BookingDTOView;
import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.repository.BookingRepository;
import com.alanaretratos.model.repository.BudgetRepository;
import com.alanaretratos.model.repository.PricingRepository;
import com.alanaretratos.model.service.BookingService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookingServiceImpl implements BookingService {

	@Inject
	BookingRepository bookingRepository;
	
	@Inject 
	BudgetRepository budgetRepository;
	
	@Inject 
	PricingRepository pricingRepository;

	@Override
	@Transactional
	public void createBooking(BookingDTOForm bookingDTO) throws Exception {
		Booking booking = new Booking();
		BeanUtils.copyProperties(booking, bookingDTO);
		Budget budget ;
		budget = budgetRepository.findById(bookingDTO.getBudgetId());
		
		if(budget!=null) {
			booking.setBudget(budget);
		}
		
		Pricing pricing;
		pricing = pricingRepository.findById(bookingDTO.getPricingId());
		if(pricing!=null) {
			booking.setPricing(pricing);
		}
		
		bookingRepository.persist(booking);
	}

	@Override
	public List<BookingDTOView> listAllBookings() {
		
		List<Booking> bookings = bookingRepository.findAllActivated();
		
		List<BookingDTOView> dtos = new ArrayList<>();
		
		for (Booking booking : bookings) {
			BookingDTOView dto = new BookingDTOView();
			
			try {
				BeanUtils.copyProperties(dto, booking);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dtos.add(dto);
			
		}
		
		return dtos;
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
	@Transactional
	public void updateBooking(BookingDTOForm bookingDTO) throws Exception {

		//TODO arrumar o metodo
		Booking booking = bookingRepository.findByIdOptional(bookingDTO.getBudgetId()).orElseThrow();
		BeanUtils.copyProperties(bookingDTO, booking);

		bookingRepository.persist(booking);

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
