package com.alanaretratos.model.entity;

import java.util.Date;

import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Cacheable
@Data
@Table(name = "tb_budget")
@EqualsAndHashCode(callSuper = false)
public class Budget extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	private PhotoShootType photoShootType;

	@OneToOne(cascade = CascadeType.ALL)
	private Pricing pricing;

	@Column
	private Date firstContactDate;

	@Column
	private Date updateDate;
	
	@Column
	private String description;

	private boolean status;
	
	  @PrePersist
	    public void prePersist() {
	        this.status = UtilConstants.STATUS_ACTIVATED; 
	    }

}
