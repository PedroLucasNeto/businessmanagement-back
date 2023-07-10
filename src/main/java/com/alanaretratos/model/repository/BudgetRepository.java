package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@ApplicationScoped
public class BudgetRepository implements PanacheRepository<Budget>{


	@Inject
	EntityManager entityManager;
	
	public List<Budget> findAllActivated() {
		
		ArrayList<Budget> returnList = new ArrayList<>();

		for (Budget budget : listAll()) {
			if (budget.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(budget);
			}
		}
		return returnList;
	}

	public List<Budget> findByClientName() {

		ArrayList<Budget> returnList = new ArrayList<>();

		return returnList;
	}


	public Integer findMonthlyBookings() {
	    StringBuilder consulta = new StringBuilder();
	    consulta.append("SELECT COUNT(*) ")
	            .append("FROM tb_budget b ")
	            .append("WHERE DATE_PART('month', b.firstcontactdate) = DATE_PART('month', CURRENT_DATE) ")
	            .append("AND DATE_PART('year', b.firstcontactdate) = DATE_PART('year', CURRENT_DATE)");

	    Query query = entityManager.createNativeQuery(consulta.toString());

	    Object result = query.getSingleResult();
	    if (result != null) {
	        return ((Number) result).intValue();
	    } else {
	        return 0; // Caso não haja resultado, retorna 0.0 ou o valor desejado
	    }
	}
}
