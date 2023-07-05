package com.alanaretratos.model.DTO.View;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BudgetDTOView {
	
	private Long id;

	private String clientName;

	private String clientPhone;

	private LocalDate clientDateOfBirth;
	
	private String clientInstagram;
	
	private String clientEmail;
	
	private LocalDate firstContactDate;

	private LocalDate updateDate;
	
	private String categoryDescription;
	
	private String pricingDescription;
	
	private String notes;

}
