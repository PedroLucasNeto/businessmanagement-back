package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.UserDTOForm;
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
	public void createUser(UserDTOForm userDTO) throws Exception {
		User user = new User();
		
		BeanUtils.copyProperties(user, userDTO);
			user.persist();

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
	public void updateUser(UserDTOForm userDTO) throws Exception {
		User user = userRepository.findByIdOptional((long) 1).orElseThrow();

		BeanUtils.copyProperties(userDTO, user);
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
