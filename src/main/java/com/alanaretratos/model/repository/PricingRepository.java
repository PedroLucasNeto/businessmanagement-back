package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class PricingRepository implements PanacheRepository<Pricing> {
	
	@Inject
	EntityManager entityManager;
	
	public List<Pricing> findAllActivated() {
		ArrayList<Pricing> returnList = new ArrayList<>();

		for (Pricing pricing : listAll()) {
			if (pricing.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(pricing);
			}
		}

		return returnList;

	}

//	public Pricing findByDescription(String description) {
//		return find("description", description).firstResult();
//	}
//	
	public Pricing findByDescription(String description) {
	    String jpql = "SELECT p FROM Pricing p WHERE p.description LIKE :description";
	    TypedQuery<Pricing> query = entityManager.createQuery(jpql, Pricing.class);
	    query.setParameter("description", "%" + description + "%");

	    return query.getSingleResult();
	}
}
