package com.alanaretratos.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.alanaretratos.model.entity.PhotoShootType;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PhotoShootTypeRepository implements PanacheRepository<PhotoShootType> {

	public List<PhotoShootType> findAllActivated() {
		ArrayList<PhotoShootType> returnList = new ArrayList<>();

		for (PhotoShootType photoShootType : listAll()) {
			if (photoShootType.isStatus() == UtilConstants.STATUS_ACTIVATED) {
				returnList.add(photoShootType);
			}
		}

		return returnList;

	}

}
