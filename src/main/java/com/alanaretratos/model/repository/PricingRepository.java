package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PricingRepository implements PanacheRepository<Pricing> {

	public List<Pricing> findAllActivated() {
		ArrayList<Pricing> returnList = new ArrayList<>();

		for (Pricing pricing : listAll()) {
			if (pricing.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(pricing);
			}
		}

		return returnList;

	}

}
