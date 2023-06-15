package com.alanaretratos.model.DTO.Form;

import java.util.Date;
import java.util.Set;

import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.entity.Product;

import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.Data;

@Data
public class BookingDTOForm {
	
	private Set<Product> products;

	private Budget budget;
	
	private String bookedDate;
	
	private String deliveryDate;
	
	private String photoShootDate;

	private boolean extraPhoto;

	private boolean paidExtraPhoto;

	private boolean paidRemaining;

	private boolean paidProduct;

	private Double totalPrice;
	
	private String notes;
}
