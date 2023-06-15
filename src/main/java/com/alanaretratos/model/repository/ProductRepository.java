package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Product;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

	public List<Product> findAllActive() {
		ArrayList<Product> returnList = new ArrayList<>();

		for (Product product : listAll()) {
			if (product.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(product);
			}
		}

		return returnList;

	}

}
