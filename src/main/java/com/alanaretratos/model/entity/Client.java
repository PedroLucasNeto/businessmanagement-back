package com.alanaretratos.model.entity;

import java.time.Instant;

import com.alanaretratos.model.utils.UtilConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "tb_client")
@EqualsAndHashCode(callSuper = false)
public class Client extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String phone;

	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Instant dateOfBirth;

	@Column
	private String instagram;

	@Column
	private String email;

	@Column
	private String notes;

	private boolean status;

	@PrePersist
	public void prePersist() {
		this.status = UtilConstants.STATUS_ACTIVATED;
	}

}
