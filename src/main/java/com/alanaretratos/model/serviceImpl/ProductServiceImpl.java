package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.ProductDTO;
import com.alanaretratos.model.entity.Product;
import com.alanaretratos.model.repository.ProductRepository;
import com.alanaretratos.model.service.ProductService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository productRepository;

	@Override
	public void createProduct(ProductDTO productDTO) throws Exception {
		Product product = productRepository.findById(productDTO.getId());
		if (product.equals(null)) {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());

			product.persist();
		} else {
			throw new Exception("Couldn't create this Product");
		}

	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAllActivated();
	}

	@Override
	public Product getProductById(Long id) {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		return product;
	}

	@Override
	public void updateProduct(ProductDTO productDTO) throws Exception {
		Product product = productRepository.findByIdOptional(productDTO.getId()).orElseThrow();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.persist();
	}

	@Override
	public void deleteProductFromDB(Long id) throws Exception {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		productRepository.delete(product);
	}

	@Override
	public void deleteProductFromView(Long id) throws Exception {
		Product product = productRepository.findByIdOptional(id).orElseThrow();
		product.setStatus(UtilConstants.STATUS_DEACTIVATED);
		product.persist();

	}

}
