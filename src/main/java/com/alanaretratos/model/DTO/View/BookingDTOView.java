package com.alanaretratos.model.DTO.View;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.alanaretratos.model.entity.BookingProducts;
import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.entity.Pricing;

import lombok.Data;

@Data
public class BookingDTOView {
	
	private Long id;

	private Set<BookingProducts> bookingProducts = new HashSet<>();

	private Budget budget;
	
	private Pricing pricing;

	private Category category;

	private LocalDate bookedDate;

	private LocalDate deliveryDate;

	private LocalDate photoShootDate;

	private boolean extraPhoto;

	private boolean paidExtraPhoto;

	private boolean paidRemaining;

	private boolean paidProduct;

	private String notes;

	private Double totalPrice;

	private boolean status;
}
