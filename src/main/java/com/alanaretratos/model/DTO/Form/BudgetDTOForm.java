package com.alanaretratos.model.DTO.Form;

import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.entity.Pricing;

import lombok.Data;

@Data
public class BudgetDTOForm {

	private ClientDTOForm client;

	private Category category;

	private Pricing pricing;

	private String firstContactDate;

	private String notes;

}
