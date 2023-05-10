package com.alanaretratos.model.DTO;

import java.util.Date;

import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.enums.TransactionType;

import lombok.Data;

@Data
public class TransactionDTO {

	private Long id;

	private String description;

	private String amount;

	private Date transactionDate;

	private Date paymentDate;

	private String origin;

	private TransactionType transactionType;
	
	private Client client;
}
