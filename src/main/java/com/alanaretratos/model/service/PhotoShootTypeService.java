package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.Form.PhotoShootTypeDTOForm;
import com.alanaretratos.model.entity.PhotoShootType;

import jakarta.ws.rs.PathParam;

public interface PhotoShootTypeService {

void createPhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) throws Exception; 
	
	void deletePhotoShootTypeFromView(@PathParam("id") Long id) throws Exception;
	
	void updatePhotoShootType(PhotoShootTypeDTOForm photoShootTypeDTO) throws Exception;
	
	List<PhotoShootType> listAllPhotoShootTypes();
	
	PhotoShootType getPhotoShootTypeById(Long id);

	void deletePhotoShootTypeFromDB(Long id) throws Exception;
}
