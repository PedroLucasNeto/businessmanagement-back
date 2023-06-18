package com.alanaretratos.model.DTO.Form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BudgetDTOForm {

	private ClientDTOForm client;

	private Long categoryId;

	private Long pricingId;

	private LocalDate firstContactDate;

	private String notes;

}
