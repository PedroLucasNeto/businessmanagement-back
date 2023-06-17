package com.alanaretratos.model.DTO.Form;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BudgetDTOForm {

	private ClientDTOForm client;

	private Long categoryId;

	private Long pricingId;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant firstContactDate;

	private String notes;

}
