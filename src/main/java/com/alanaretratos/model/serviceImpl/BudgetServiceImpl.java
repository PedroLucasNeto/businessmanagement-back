package com.alanaretratos.model.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.BudgetDTOForm;
import com.alanaretratos.model.DTO.Form.ClientDTOForm;
import com.alanaretratos.model.DTO.View.BudgetDTOView;
import com.alanaretratos.model.entity.Budget;
import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.entity.Client;
import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.repository.BudgetRepository;
import com.alanaretratos.model.repository.CategoryRepository;
import com.alanaretratos.model.repository.ClientRepository;
import com.alanaretratos.model.repository.PricingRepository;
import com.alanaretratos.model.service.BudgetService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BudgetServiceImpl implements BudgetService {

	@Inject
	BudgetRepository budgetRepository;

	@Inject
	ClientRepository clientRepository;

	@Inject
	CategoryRepository categoryRepository;

	@Inject
	PricingRepository pricingRepository;

	@Override
	@Transactional
	public void createBudget(BudgetDTOForm budgetDTO) throws Exception {
		Budget budget = new Budget();

		Client client;
		ClientDTOForm dto = budgetDTO.getClient();

		client = clientRepository.findByPhone(budgetDTO.getClient().getPhone());

		if (client == null) {
			client = new Client();
			BeanUtils.copyProperties(client, dto);
			clientRepository.persist(client);
		}

		Pricing pricing = pricingRepository.findById(budgetDTO.getPricingId());

		Category category = categoryRepository.findById(budgetDTO.getCategoryId());

		budget.setPricing(pricing);
		budget.setClient(client);
		budget.setCategory(category);
		budget.setFirstContactDate(budgetDTO.getFirstContactDate());
		budget.setNotes(budgetDTO.getNotes());

		try {
			budgetRepository.persist(budget);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BudgetDTOView> listAllBudgets() {
		List<Budget> budgets = new ArrayList<>();

		budgets = budgetRepository.findAllActivated();

		List<BudgetDTOView> budgetsDTO = new ArrayList<>();

		for (Budget budget : budgets) {

			BudgetDTOView budgetDTO = new BudgetDTOView();

			budgetDTO.setId(budget.getId());
			budgetDTO.setClientDateOfBirth(budget.getClient().getDateOfBirth());
			budgetDTO.setClientEmail(budget.getClient().getEmail());
			budgetDTO.setClientInstagram(budget.getClient().getInstagram());
			budgetDTO.setClientName(budget.getClient().getName());
			budgetDTO.setClientPhone(budget.getClient().getPhone());
			budgetDTO.setFirstContactDate(budget.getFirstContactDate());
			budgetDTO.setNotes(budget.getNotes());
			budgetDTO.setCategoryDescription(null);
			budgetDTO.setPricingDescription(null);
			if (budget.getCategory() != null) {
				budgetDTO.setCategoryDescription(budget.getCategory().getDescription());
			}
			if (budget.getPricing() != null) {
				budgetDTO.setPricingDescription(budget.getPricing().getDescription());
			}

			budgetDTO.setUpdateDate(budget.getUpdateDate());

			budgetsDTO.add(budgetDTO);
		}

		return budgetsDTO;
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
	@Transactional
	public void updateBudget(BudgetDTOForm budgetDTO) throws Exception {
		// TODO arrumar o metodo
		Budget budget = budgetRepository.findByIdOptional((long) 1).orElseThrow();

		BeanUtils.copyProperties(budgetDTO, budget);

		budget.persist();
	}

	@Override
	@Transactional
	public void deleteBudgetFromDB(Long id) throws Exception {
		Budget budget = budgetRepository.findByIdOptional(id).orElseThrow();

		budgetRepository.delete(budget);
	}

	@Override
	@Transactional
	public void deleteBudgetFromView(Long id) throws Exception {
		Budget budget = budgetRepository.findByIdOptional(id).orElseThrow();
		budget.setStatus(UtilConstants.STATUS_DEACTIVATED);

		budget.persist();
	}

}
