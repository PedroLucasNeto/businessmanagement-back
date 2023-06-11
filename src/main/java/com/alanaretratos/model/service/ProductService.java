package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.ProductDTOForm;
import com.alanaretratos.model.entity.Product;

import jakarta.ws.rs.PathParam;

public interface ProductService {

	void createProduct(ProductDTOForm productDTO) throws Exception;

	void deleteProductFromView(@PathParam("id") Long id) throws Exception;

	void updateProduct(ProductDTOForm productDTO, Long id) throws Exception;

	List<Product> listAllProducts();

	Product getProductById(Long id);

	void deleteProductFromDB(Long id) throws Exception;
}
