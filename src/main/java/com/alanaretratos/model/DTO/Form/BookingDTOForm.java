package com.alanaretratos.model.DTO.Form;

import java.time.LocalDate;
import java.util.Set;

import com.alanaretratos.model.enums.PaymentMethod;
import com.alanaretratos.model.enums.TransactionType;

import lombok.Data;

@Data
public class BookingDTOForm {
	
	private Set<BookingProductDTOForm> products;

	private Long budgetId;
	
	private Long pricingId;
	
	private Long categoryId;
	
	private LocalDate bookedDate;
	
	private LocalDate deliveryDate;
	
	private LocalDate photoShootDate;
	
	private TransactionType transactionType;
	
	private boolean halfPayment;
	
	private boolean fullPayment;
	
	private double otherValue;
	
	private PaymentMethod paymentMethod;

	private String notes;
}
