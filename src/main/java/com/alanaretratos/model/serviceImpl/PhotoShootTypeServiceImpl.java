package com.alanaretratos.model.serviceImpl;

import java.util.List;

import com.alanaretratos.model.DTO.PhotoShootTypeDTO;
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
	public void createPhotoShootType(PhotoShootTypeDTO photoShootTypeDTO) throws Exception {
		PhotoShootType photoShootType = photoShootTypeRepository.findById(photoShootTypeDTO.getId());
		if (photoShootType.equals(null)) {

			photoShootType.setDescription(photoShootTypeDTO.getDescription());

			photoShootType.persist();
		} else {
			throw new Exception("Couldn't create this PhotoShootType");
		}

	}
	
	@Override
	public List<PhotoShootType> listAllPhotoShootTypes() {
		return photoShootTypeRepository.findAllActivated();
	}

	@Override
	public PhotoShootType getPhotoShootTypeById(Long id) {
		PhotoShootType photoShootType =  photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		return photoShootType;
	}



	@Override
	public void updatePhotoShootType(PhotoShootTypeDTO photoShootTypeDTO) throws Exception {
		PhotoShootType photoShootType =  photoShootTypeRepository.findByIdOptional(photoShootTypeDTO.getId()).orElseThrow();
		photoShootType.setDescription(photoShootTypeDTO.getDescription());
		photoShootType.persist();
	}



	@Override
	public void deletePhotoShootTypeFromDB(Long id) throws Exception {
		PhotoShootType photoShootType =  photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		photoShootTypeRepository.delete(photoShootType);
	}
	
	@Override
	public void deletePhotoShootTypeFromView(Long id) throws Exception {
		PhotoShootType photoShootType =  photoShootTypeRepository.findByIdOptional(id).orElseThrow();
		photoShootType.setStatus(UtilConstants.STATUS_DEACTIVATED);
		photoShootType.persist();

	}

}
