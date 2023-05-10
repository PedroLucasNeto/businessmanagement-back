package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.PricingDTO;
import com.alanaretratos.model.entity.Pricing;

import jakarta.ws.rs.PathParam;

public interface PricingService {

	void createPricing(PricingDTO pricingDTO) throws Exception;

	void deletePricingFromView(@PathParam("id") Long id) throws Exception;

	void updatePricing(PricingDTO pricingDTO) throws Exception;

	List<Pricing> listAllPricings();

	Pricing getPricingById(Long id);

	void deletePricingFromDB(Long id) throws Exception;
}
