package com.alanaretratos.model.DTO.Form;

import java.util.Date;

import lombok.Data;

@Data
public class ClientDTOForm {

	private String name;
	
	private String phone;
	
	private Date dateOfBirth;
	
	private String instagram;
	
	private String email;
	
	private String observation;
	
}
