package com.alanaretratos.model.DTO;

import java.util.Date;

import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.entity.PhotoShootType;
import com.alanaretratos.model.entity.Pricing;

import lombok.Data;

@Data
public class BudgetDTO {

	private Long id;

	private Client client;

	private PhotoShootType photoShootType;

	private Date firstContactDate;

	private Date updateDate;

	private Pricing pricing;

	private boolean status;

}
