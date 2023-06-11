package com.alanaretratos.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alanaretratos.model.utils.UtilConstants;

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
import jakarta.persistence.PrePersist;
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

	@OneToMany(mappedBy = "booking")
	private Set<BookingProducts> bookingProducts = new HashSet<>();

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
	private Double subTotal;
	
	@Column
	private Double totalPrice;

	private boolean status;
	
	  @PrePersist
	    public void prePersist() {
	        this.status = UtilConstants.STATUS_ACTIVATED; 
	    }
}
