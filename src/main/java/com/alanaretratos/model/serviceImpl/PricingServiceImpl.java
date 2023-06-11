package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.PricingDTOForm;
import com.alanaretratos.model.entity.Pricing;
import com.alanaretratos.model.repository.PricingRepository;
import com.alanaretratos.model.service.PricingService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class PricingServiceImpl implements PricingService {

	@Inject
	PricingRepository pricingRepository;

	@Override
	@Transactional
	public void createPricing(PricingDTOForm pricingDTO) throws Exception {
		Pricing pricing = new Pricing();
		
		BeanUtils.copyProperties(pricing, pricingDTO);

			pricingRepository.persist(pricing);
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
	@Transactional
	public void updatePricing(PricingDTOForm pricingDTO) throws Exception {
		Pricing pricing = pricingRepository.findByIdOptional((long) 1).orElseThrow();
		BeanUtils.copyProperties(pricingDTO, pricing);
		pricing.persist();
	}

	@Override
	@Transactional
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
