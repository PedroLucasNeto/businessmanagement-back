package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.UserDTO;
import com.alanaretratos.model.entity.User;
import com.alanaretratos.model.repository.UserRepository;
import com.alanaretratos.model.service.UserService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class UserServiceImpl implements UserService {

	@Inject
	UserRepository userRepository;

	@Override
	public void createUser(UserDTO userDTO) throws Exception {
		User user = userRepository.findById(userDTO.getId());
		if (user.equals(null)) {
			user.setEmail(userDTO.getEmail());
			user.setName(userDTO.getName());
			user.setPassword(userDTO.getPassword());

			user.persist();
		} else {
			throw new Exception("Couldn't create this User");
		}

	}

	@Override
	public List<User> listAllUsers() {

		return userRepository.findAllActivated();
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.findByIdOptional(id).orElseThrow();
		return user;
	}

	@Override
	public void updateUser(UserDTO userDTO) throws Exception {
		User user = userRepository.findByIdOptional(userDTO.getId()).orElseThrow();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());

		user.persist();

	}

	@Override
	public void deleteUserFromDB(Long id) throws Exception {
		User user = userRepository.findByIdOptional(id).orElseThrow();

		userRepository.delete(user);

	}

	@Override
	public void deleteUserFromView(Long id) throws Exception {
		User user = userRepository.findByIdOptional(id).orElseThrow();
		user.setStatus(UtilConstants.STATUS_DEACTIVATED);

		user.persist();
	}

}
