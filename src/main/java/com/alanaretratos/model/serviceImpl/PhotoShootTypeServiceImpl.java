package com.alanaretratos.model.serviceImpl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alanaretratos.model.DTO.Form.PhotoShootTypeDTOForm;
import com.alanaretratos.model.entity.PhotoShootType;
import com.alanaretratos.model.repository.PhotoShootTypeRepository;
import com.alanaretratos.model.service.PhotoShootTypeService;
import com.alanaretratos.model.utils.UtilConstants;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PhotoShootTypeServiceImpl implements PhotoShootTypeService {

	@Inject
	PhotoShootTypeRepository photoShootTypeRepository;

	@Override
	public void createPhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) throws Exception {
		PhotoShootType photoShootType = new PhotoShootType();
		BeanUtils.copyProperties(photoShootType, photoShootTypeDTO);
		photoShootType.persist();
	}

	@Override
	public List<PhotoShootType> listAllPhotoShootTypes() {
		return photoShootTypeRepository.findAllActivated();
	}

	@Override
	public PhotoShootType getPhotoShootTypeById(Long id) {
		PhotoShootType photoShootType = photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		return photoShootType;
	}

	@Override
	public void updatePhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) throws Exception {
		PhotoShootType photoShootType = photoShootTypeRepository.findByIdOptional((long) 1).orElseThrow();

		BeanUtils.copyProperties(photoShootTypeDTO, photoShootType);
		photoShootType.persist();
	}

	@Override
	public void deletePhotoShootTypeFromDB(Long id) throws Exception {
		PhotoShootType photoShootType = photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		photoShootTypeRepository.delete(photoShootType);
	}

	@Override
	public void deletePhotoShootTypeFromView(Long id) throws Exception {
		PhotoShootType photoShootType = photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		photoShootType.setStatus(UtilConstants.STATUS_DEACTIVATED);
		photoShootType.persist();

	}

}
