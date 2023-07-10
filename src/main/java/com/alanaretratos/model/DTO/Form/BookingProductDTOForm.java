package com.alanaretratos.model.DTO.Form;

import lombok.Data;

@Data
public class BookingProductDTOForm {

	private long productId;
	private String productName;
	private double productPrice;
	private int productQuantity;
}
