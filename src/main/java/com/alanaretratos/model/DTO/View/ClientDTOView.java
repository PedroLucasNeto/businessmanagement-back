package com.alanaretratos.model.DTO.View;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ClientDTOView {
	
	private String name;
	
	private String phone;
	
	private LocalDate dateOfBirth;
	
	private String instagram;
	
	private String email;
	
	private String observation;
	
}
