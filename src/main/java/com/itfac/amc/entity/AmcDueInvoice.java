package com.itfac.amc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Amc_due_invoice")
public class AmcDueInvoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "due_date", nullable = false)
	private Date dueDate;
	
	@Column(name = "invoice_amount", nullable = false)
	private BigDecimal invoiceAmt;
	
	@Column(name = "invoice_balance", nullable = false)
	private BigDecimal invoiceBalance;
	
	private boolean settle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amc_no", nullable = false, foreignKey = @ForeignKey(name = "amc_due_fk1"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AmcMaster amcMaster;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amc_serialno", nullable = false, foreignKey = @ForeignKey(name = "amc_due_fk2"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AmcSerial amcSerial;
	
	@ManyToOne()
	@JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "amc_due_fk3"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name = "currency_id", nullable = false, foreignKey = @ForeignKey(name = "amc_due_fk4"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Currency currency;

}
