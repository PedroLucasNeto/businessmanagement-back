package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

	public List<Client> findAllActivated() {
		ArrayList<Client> returnList = new ArrayList<>();

		for (Client client : listAll()) {
			if (client.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(client);
			}
		}

		return returnList;

	}

}
