package com.alanaretratos.model.DTO.Form;

import java.util.Date;

import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.entity.PhotoShootType;
import com.alanaretratos.model.entity.Pricing;

import lombok.Data;

@Data
public class BudgetDTOForm {

	private Client client;

	private PhotoShootType photoShootType;

	private Pricing pricing;

	private Date firstContactDate;

}
