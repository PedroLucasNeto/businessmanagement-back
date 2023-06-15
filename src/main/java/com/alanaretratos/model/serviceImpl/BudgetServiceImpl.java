package com.alanaretratos.model.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.BudgetDTOForm;
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

		Client client = new Client();
		BeanUtils.copyProperties(client, budgetDTO.getClient());
		
		clientRepository.persist(client);
		
		Pricing pricing = pricingRepository.findById(budgetDTO.getCategory().getId());
		
		Category category = categoryRepository.findById(budgetDTO.getPricing().getId());

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
				budgetDTO.setDateOfBirth(budget.getClient().getDateOfBirth());
				budgetDTO.setEmail(budget.getClient().getEmail());
				budgetDTO.setInstagram(budget.getClient().getInstagram());
				budgetDTO.setName(budget.getClient().getName());
				budgetDTO.setPhone(budget.getClient().getPhone());
				budgetDTO.setFirstContactDate(budget.getFirstContactDate());
				budgetDTO.setNotes(budget.getNotes());
				if(budget.getCategory()!=null) {					
					budgetDTO.setCategoryDescription(budget.getCategory().getDescription());
				}
				budgetDTO.setCategoryDescription(null);
				if(budget.getPricing()!=null) {					
					budgetDTO.setPricingDescription(budget.getPricing().getDescription());
				}
				budgetDTO.setPricingDescription(null);
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
	public void updateBudget(BudgetDTOForm budgetDTO) throws Exception {
		// TODO arrumar o metodo
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
