package com.alanaretratos.model.entity;

import java.time.LocalDate;

import com.alanaretratos.model.enums.TransactionType;
import com.alanaretratos.model.utils.UtilConstants;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
@Data
@Table(name = "tb_transaction")
@EqualsAndHashCode(callSuper = false)
public class Transaction extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String description;

	@Column
	private Long bookingId;

	@Column
	private Double amount;

	@Column
	private LocalDate transactionDate;

	@Column
	private LocalDate paymentDate;

	@Column
	private String origin;

	@Column
	private TransactionType transactionType;

	@Column
	private String notes;

	private boolean status;

	@PrePersist
	public void prePersist() {
		this.status = UtilConstants.STATUS_ACTIVATED;
	}

}
