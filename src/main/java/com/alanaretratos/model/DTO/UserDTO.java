package com.alanaretratos.model.DTO;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String name;

	private String email;

	private String password;

	private boolean status;

}
