package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.ProductDTOForm;
import com.alanaretratos.model.entity.Product;
import com.alanaretratos.model.repository.ProductRepository;
import com.alanaretratos.model.service.ProductService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository productRepository;

	@Override
	@Transactional
	public void createProduct(ProductDTOForm productDTO) throws Exception {
		Product product = new Product();
		
		BeanUtils.copyProperties(product, productDTO);

			productRepository.persist(product);
	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAllActive();
	}

	@Override
	public Product getProductById(Long id) {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		return product;
	}

	@Override
	@Transactional
	public void updateProduct(ProductDTOForm productDTO, Long id) throws Exception {
		Product product = productRepository.findById(id);
		BeanUtils.copyProperties(productDTO, product);
		product.persist();
	}

	@Override
	@Transactional
	public void deleteProductFromDB(Long id) throws Exception {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		productRepository.deleteById(id);
	}

	@Override
	public void deleteProductFromView(Long id) throws Exception {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		product.setStatus(UtilConstants.STATUS_DEACTIVATED);
		product.persist();
	}

}
