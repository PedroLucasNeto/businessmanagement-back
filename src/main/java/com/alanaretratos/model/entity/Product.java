package com.alanaretratos.model.entity;

import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Cacheable
@Data
@Table(name = "tb_product")
@EqualsAndHashCode(callSuper=false)
public class Product extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Double price;
	
	@Column
	private String description;
	
	@Column
	private String brand;

	private boolean status;
	
	  @PrePersist
	    public void prePersist() {
	        this.status = UtilConstants.STATUS_ACTIVATED; 
	    }

}
