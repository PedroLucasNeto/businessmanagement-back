package com.alanaretratos.model.DTO.View;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BudgetDTOView {
	
	private Long id;

	private String name;

	private String phone;

	private String notes;
	
	private LocalDate firstContactDate;

	private LocalDate updateDate;

	private LocalDate dateOfBirth;

	private String instagram;

	private String email;
	
	private String categoryDescription;
	
	private String pricingDescription;

}
