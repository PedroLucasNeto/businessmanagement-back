package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.User;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
	
	public List<User> findAllActivated() {
		ArrayList<User> returnList = new ArrayList<>();

		for (User user : listAll()) {
			if (user.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(user);
			}
		}

		return returnList;

	}

}
