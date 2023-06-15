package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Category;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

	@Inject
	EntityManager entityManager;
	
	public List<Category> findAllActivated() {
		ArrayList<Category> returnList = new ArrayList<>();

		for (Category category : listAll()) {
			if (category.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(category);
			}
		}

		return returnList;

	}
	
//	public Category findByDescription(String description) {
//        return find("description", description).firstResult();
//    }
	
	public Category findByDescription(String description) {
	    String jpql = "SELECT c FROM Category c WHERE c.description LIKE :description";
	    TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
	    query.setParameter("description", "%" + description + "%");

	    return query.getSingleResult();
	}
}
