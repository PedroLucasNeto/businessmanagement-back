package com.alanaretratos.model.entity;

import java.util.Date;

import com.alanaretratos.model.enums.TransactionType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Cacheable
@Data
@Table(name = "tb_transaction")
@EqualsAndHashCode(callSuper=false)
public class Transaction extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@OneToOne(cascade= CascadeType.ALL)
	private Client client;
	
	@Column
	private String amount;
	
	@Column
	private Date transactionDate;
	
	@Column
	private Date paymentDate;
	
	@Column
	private String origin;
	
	@Column
	private TransactionType transactionType;
	
	@Column
	private boolean status;
	
}

