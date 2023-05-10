package com.alanaretratos.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Cacheable
@Data
@Table(name = "tb_pricing")
@EqualsAndHashCode(callSuper=false)
public class Pricing extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private String price;
	
	@Column
	private boolean status;
}

