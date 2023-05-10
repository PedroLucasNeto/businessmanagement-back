package com.alanaretratos.model.DTO;

import java.util.Date;
import java.util.List;

import com.alanaretratos.model.entity.Booking;
import com.alanaretratos.model.entity.Product;

import lombok.Data;

@Data
public class BookingDTO {
	
	private Long id;

	private Booking booking;

	private List<Product> products;

	private Date bookingDate;

	private Date deliveryDate;

	private Date photoShootDate;

	private boolean extraPhoto;

	private boolean paidExtraPhoto;

	private boolean paidRemaining;

	private boolean paidProduct;

	private Double totalPrice;
	
	private boolean status;
}
