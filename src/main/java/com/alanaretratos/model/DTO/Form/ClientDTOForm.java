package com.alanaretratos.model.DTO.Form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientDTOForm {

	private String name;

	private String phone;

	private LocalDate dateOfBirth;

	private String instagram;

	private String email;

	private String notes;

}
