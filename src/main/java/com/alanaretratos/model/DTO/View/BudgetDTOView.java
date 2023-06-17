package com.alanaretratos.model.DTO.View;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BudgetDTOView {
	
	private Long id;

	private String name;

	private String phone;

	private String notes;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant  firstContactDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant updateDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant dateOfBirth;

	private String instagram;

	private String email;
	
	private String categoryDescription;
	
	private String pricingDescription;

}
