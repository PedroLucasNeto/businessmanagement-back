package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {

	public List<Booking> findAllActivated() {
		ArrayList<Booking> returnList = new ArrayList<>();

		for (Booking booking : listAll()) {
			if (booking.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(booking);
			}
		}

		return returnList;

	}

//	public PanacheQuery<Booking> findBookingByClientName(String name) {
//		StringBuilder query = new StringBuilder("SELECT b FROM tb_booking b WHERE" + " b.clientName LIKE :name and ");
//		PanacheQuery<Booking> resulQuery = null;
//
//		return null;
//	}

//	public Booking findByName(String name) {
//		PanacheQuery<Booking> booking = find("name", name);
//		return (Booking) booking;
//	}

}
