package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Transaction;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> {
	
	public List<Transaction> findAllActivated() {
		ArrayList<Transaction> returnList = new ArrayList<>();

		for (Transaction transaction : listAll()) {
			if (transaction.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(transaction);
			}
		}

		return returnList;

	}

}
