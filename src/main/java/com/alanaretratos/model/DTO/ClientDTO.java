package com.alanaretratos.model.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class ClientDTO {

	private Long id;

	private String name;

	private String phone;

	private Date dateOfBirth;

	private String instagram;

	private String email;

	private String observation;

	private boolean status;

}
