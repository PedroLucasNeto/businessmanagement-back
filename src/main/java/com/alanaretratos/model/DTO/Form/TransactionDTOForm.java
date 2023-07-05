package com.alanaretratos.model.DTO.Form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TransactionDTOForm {

	  private String description;
	  private Long clientId;
	  private double amount;
	  private LocalDate transactionDate;
	  private LocalDate paymentDate;
	  private String origin;
	  private String transactionType;
	  
}
