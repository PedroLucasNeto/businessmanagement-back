package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.BudgetDTOForm;
import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.repository.BudgetRepository;
import com.alanaretratos.model.service.BudgetService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class BudgetServiceImpl implements BudgetService {

	@Inject
	BudgetRepository budgetRepository;

	@Override
	public void createBudget(BudgetDTOForm budgetDTO) throws Exception {
		Budget budget = new Budget();

		BeanUtils.copyProperties(budget, budgetDTO);

		budget.persist();
	}

	@Override
	public List<Budget> listAllBudgets() {
		return budgetRepository.findAllActivated();
	}

	@Override
	public Budget getBudgetById(Long id) {
		Budget budget = budgetRepository.findByIdOptional(id).orElseThrow();
		return budget;
	}

	@Override
	public List<Budget> getBudgetByClientName(String name) {
		List<Budget> returnList = budgetRepository.findByClientName();

		return returnList;

	}

	@Override
	public void updateBudget(BudgetDTOForm budgetDTO) throws Exception {
		//TODO arrumar o metodo
		Budget budget = budgetRepository.findByIdOptional((long) 1).orElseThrow();

		BeanUtils.copyProperties(budgetDTO, budget);
		
		budget.persist();
	}

	@Override
	public void deleteBudgetFromView(Long id) throws Exception {
		Budget budget = budgetRepository.findByIdOptional(id).orElseThrow();

		budgetRepository.delete(budget);
	}

	@Override
	public void deleteBudgetFromDB(Long id) throws Exception {
		Budget budget = budgetRepository.findByIdOptional(id).orElseThrow();
		budget.setStatus(UtilConstants.STATUS_DEACTIVATED);

		budget.persist();
	}

}
