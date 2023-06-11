package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.BudgetDTOForm;
import com.alanaretratos.model.entity.Budget;

import jakarta.ws.rs.PathParam;

public interface BudgetService {

	void createBudget(BudgetDTOForm budgetDTO) throws Exception;

	void deleteBudgetFromView(@PathParam("id") Long id) throws Exception;

	void updateBudget(BudgetDTOForm budgetDTO) throws Exception;

	List<Budget> listAllBudgets();

	Budget getBudgetById(Long id);

	void deleteBudgetFromDB(Long id) throws Exception;

	List<Budget>getBudgetByClientName(String name);
}
