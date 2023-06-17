package com.alanaretratos.model.DTO.Form;

import java.time.Instant;
import java.util.Set;

import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookingDTOForm {
	
	private Set<Product> products;

	private Budget budget;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant bookedDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant deliveryDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant photoShootDate;

	private boolean extraPhoto;

	private boolean paidExtraPhoto;

	private boolean paidRemaining;

	private boolean paidProduct;

	private Double totalPrice;
	
	private String notes;
}
