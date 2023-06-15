package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.CategoryDTOForm;
import com.alanaretratos.model.entity.Category;

import jakarta.ws.rs.PathParam;

public interface CategoryService {

	void createCategory(CategoryDTOForm photoShootTypeDTO) throws Exception;

	void deleteCategoryFromView(@PathParam("id") Long id) throws Exception;

	void updateCategory(CategoryDTOForm photoShootTypeDTO) throws Exception;

	List<Category> listAllCategories();

	Category getCategoryById(Long id);

	void deleteCategoryFromDB(Long id) throws Exception;
}
