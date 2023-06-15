package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.CategoryDTOForm;
import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.repository.CategoryRepository;
import com.alanaretratos.model.service.CategoryService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	CategoryRepository categoryRepository;

	@Override
	@Transactional
	public void createCategory(CategoryDTOForm categoryDTO) throws Exception {
		Category category = new Category();
		BeanUtils.copyProperties(category, categoryDTO);
		categoryRepository.persist(category);
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAllActivated();
	}

	@Override
	public Category getCategoryById(Long id) {
		Category category = categoryRepository.findByIdOptional(id).orElseThrow();
		return category;
	}

	@Override
	public void updateCategory(CategoryDTOForm categoryDTO) throws Exception {
		Category category = categoryRepository.findByIdOptional((long) 1).orElseThrow();

		BeanUtils.copyProperties(categoryDTO, category);
		category.persist();
	}

	@Override
	@Transactional
	public void deleteCategoryFromDB(Long id) throws Exception {
		Category category = categoryRepository.findByIdOptional(id).orElseThrow();
		categoryRepository.delete(category);
	}

	@Override
	public void deleteCategoryFromView(Long id) throws Exception {
		Category category = categoryRepository.findByIdOptional(id).orElseThrow();
		category.setStatus(UtilConstants.STATUS_DEACTIVATED);
		category.persist();

	}

}
