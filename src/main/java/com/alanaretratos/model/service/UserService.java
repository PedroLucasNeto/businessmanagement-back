package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.UserDTO;
import com.alanaretratos.model.entity.User;

import jakarta.ws.rs.PathParam;

public interface UserService {

	void createUser(UserDTO userDTO) throws Exception;

	void deleteUserFromView(@PathParam("id") Long id) throws Exception;

	void updateUser(UserDTO userDTO) throws Exception;

	List<User> listAllUsers();

	User getUserById(Long id);

	void deleteUserFromDB(Long id) throws Exception;
}
