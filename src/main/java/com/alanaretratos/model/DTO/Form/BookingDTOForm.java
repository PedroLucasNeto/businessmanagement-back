package com.alanaretratos.model.DTO.Form;

import java.time.LocalDate;
import java.util.Set;

import com.alanaretratos.model.entity.Product;

import lombok.Data;

@Data
public class BookingDTOForm {
	
	private Set<Product> products;

	private Long budgetId;
	
	private Long pricingId;
	
	private Long categoryId;
	
	private LocalDate bookedDate;
	
	private LocalDate deliveryDate;
	
	private LocalDate photoShootDate;

	private boolean extraPhoto;

	private boolean paidExtraPhoto;

	private boolean paidRemaining;

	private boolean paidProduct;

	private Double totalPrice;
	
	private String notes;
}
