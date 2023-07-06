package com.alanaretratos.model.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Transaction;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> {
	
	@Inject
	EntityManager entityManager;
	
	public List<Transaction> findAllActivated() {
		ArrayList<Transaction> returnList = new ArrayList<>();

		for (Transaction transaction : listAll()) {
			if (transaction.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(transaction);
			}
		}

		return returnList;

	}
	
	public Double monthlyIncome() {
	    StringBuilder consulta = new StringBuilder();
	    consulta.append("SELECT SUM(t.amount) ")
	            .append("FROM tb_transaction t ")
	            .append("WHERE DATE_PART('month', t.paymentdate) = DATE_PART('month', CURRENT_DATE) ")
	            .append("AND DATE_PART('year', t.paymentdate) = DATE_PART('year', CURRENT_DATE)");

	    Query query = entityManager.createNativeQuery(consulta.toString());

	    Object result = query.getSingleResult();
	    if (result != null) {
	        return ((Number) result).doubleValue();
	    } else {
	        return 0.0; // Caso não haja resultado, retorna 0.0 ou o valor desejado
	    }
	}
}
