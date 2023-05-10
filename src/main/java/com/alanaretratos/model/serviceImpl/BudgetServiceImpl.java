package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.BudgetDTO;
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
	public void createBudget(BudgetDTO budgetDTO) throws Exception {
		Budget budget = budgetRepository.findById(budgetDTO.getId());
		if (budget.equals(null)) {
			budget.setClient(budgetDTO.getClient());
			budget.setFirstContactDate(budgetDTO.getFirstContactDate());
			budget.setId(budgetDTO.getId());
			budget.setPhotoShootType(budgetDTO.getPhotoShootType());
			budget.setPricing(budgetDTO.getPricing());
			budget.setUpdateDate(budgetDTO.getUpdateDate());

			budget.persist();
		} else {
			throw new Exception("Couldn't create this Budget");
		}

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
	public void updateBudget(BudgetDTO budgetDTO) throws Exception {
		Budget budget = budgetRepository.findByIdOptional(budgetDTO.getId()).orElseThrow();

		budget.setPhotoShootType(budgetDTO.getPhotoShootType());
		budget.setPricing(budgetDTO.getPricing());
		budget.setUpdateDate(budgetDTO.getUpdateDate());

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
