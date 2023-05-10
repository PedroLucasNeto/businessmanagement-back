package com.alanaretratos.model.DTO;

import lombok.Data;

@Data
public class PricingDTO {

	private Long id;

	private String description;

	private String price;

	private boolean status;
}
