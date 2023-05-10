package com.alanaretratos.model.entity;

import java.util.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Cacheable
@Data
@Table(name = "tb_booking")
@EqualsAndHashCode(callSuper = false)
public class Booking extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
	private List<Product> products;

	@OneToOne(cascade = CascadeType.ALL)
	private Budget budget;

	@Column
	private Date bookedDate;

	@Column
	private Date deliveryDate;

	@Column
	private Date photoShootDate;

	@Column
	private boolean extraPhoto;

	@Column
	private boolean paidExtraPhoto;

	@Column
	private boolean paidRemaining;

	@Column
	private boolean paidProduct;

	@Column
	private Double totalPrice;

	@Column
	private boolean status;
}
