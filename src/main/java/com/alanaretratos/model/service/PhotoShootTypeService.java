package com.alanaretratos.model.service;

import java.util.List;

import com.alanaretratos.model.DTO.PhotoShootTypeDTO;
import com.alanaretratos.model.entity.PhotoShootType;

import jakarta.ws.rs.PathParam;

public interface PhotoShootTypeService {

void createPhotoShootType(PhotoShootTypeDTO photoShootTypeDTO) throws Exception; 
	
	void deletePhotoShootTypeFromView(@PathParam("id") Long id) throws Exception;
	
	void updatePhotoShootType(PhotoShootTypeDTO photoShootTypeDTO) throws Exception;
	
	List<PhotoShootType> listAllPhotoShootTypes();
	
	PhotoShootType getPhotoShootTypeById(Long id);

	void deletePhotoShootTypeFromDB(Long id) throws Exception;
}
