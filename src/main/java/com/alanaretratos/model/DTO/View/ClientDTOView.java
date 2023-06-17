package com.alanaretratos.model.DTO.View;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class ClientDTOView {
	
	private String name;
	
	private String phone;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant dateOfBirth;
	
	private String instagram;
	
	private String email;
	
	private String observation;
	
}
