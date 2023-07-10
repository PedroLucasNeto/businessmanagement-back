package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {
	

	@Inject
	EntityManager entityManager;

	public List<Booking> findAllActivated() {
		ArrayList<Booking> returnList = new ArrayList<>();

		for (Booking booking : listAll()) {
			if (booking.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(booking);
			}
		}

		return returnList;

	}
	
	public Integer findMonthlyBookings() {
	    StringBuilder consulta = new StringBuilder();
	    consulta.append("SELECT COUNT(*) ")
	            .append("FROM tb_booking b ")
	            .append("WHERE DATE_PART('month', b.bookeddate) = DATE_PART('month', CURRENT_DATE) ")
	            .append("AND DATE_PART('year', b.bookeddate) = DATE_PART('year', CURRENT_DATE)");

	    Query query = entityManager.createNativeQuery(consulta.toString());

	    Object result = query.getSingleResult();
	    if (result != null) {
	        return ((Number) result).intValue();
	    } else {
	        return 0; // Caso não haja resultado, retorna 0.0 ou o valor desejado
	    }
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
