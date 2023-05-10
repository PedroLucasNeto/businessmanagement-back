package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class BudgetRepository implements PanacheRepository<Budget>{

	
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

}
