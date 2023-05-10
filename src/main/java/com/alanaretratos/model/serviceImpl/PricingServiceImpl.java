package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.PricingDTO;
import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.repository.PricingRepository;
import com.alanaretratos.model.service.PricingService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class PricingServiceImpl implements PricingService {

	@Inject
	PricingRepository pricingRepository;

	@Override
	public void createPricing(PricingDTO pricingDTO) throws Exception {
		Pricing pricing = pricingRepository.findById(pricingDTO.getId());
		if (pricing.equals(null)) {
			pricing.setDescription(pricingDTO.getDescription());
			pricing.setPrice(pricingDTO.getPrice());
			pricing.persist();
		} else {
			throw new Exception("Couldn't create this Pricing");
		}

	}

	@Override
	public List<Pricing> listAllPricings() {
		return pricingRepository.findAllActivated();
	}

	@Override
	public Pricing getPricingById(Long id) {
		Pricing pricing = pricingRepository.findByIdOptional(id).orElseThrow();
		return pricing;
	}

	@Override
	public void updatePricing(PricingDTO pricingDTO) throws Exception {
		Pricing pricing = pricingRepository.findByIdOptional(pricingDTO.getId()).orElseThrow();
		pricing.setDescription(pricingDTO.getDescription());
		pricing.setPrice(pricingDTO.getPrice());
		pricing.persist();
	}

	@Override
	public void deletePricingFromDB(Long id) throws Exception {
		Pricing pricing = pricingRepository.findByIdOptional(id).orElseThrow();
		
		pricingRepository.delete(pricing);

	}

	@Override
	public void deletePricingFromView(Long id) throws Exception {
		Pricing pricing = pricingRepository.findByIdOptional(id).orElseThrow();
		pricing.setStatus(UtilConstants.STATUS_DEACTIVATED);
		pricing.persist();

	}

}
