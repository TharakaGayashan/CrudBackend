package com.itfac.amc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Receipt {

	@Id
	@Column(name = "rec_no", length = 10)
	private String recNo;

	@Column(name = "rec_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date recDate;

	private boolean cancel;

	@Column(name = "cancel_reason", length = 100)
	private String cancelReason;

	@Column(name = "exchage_rate", precision = 5, scale = 2, nullable = false)
	private BigDecimal exchageRate;

	@Column(length = 150)
	private String description;

	@Column(length = 10)
	private String payMode;

	@Column(nullable = false)
	private BigDecimal total;

	@Column(columnDefinition = "decimal(10,2) default 0.0")
	private BigDecimal balance = new BigDecimal(0.0);
	
	@Column(name = "total_lkr", nullable = false)
	private BigDecimal totalLkr;

	@Column(name = "balance_lkr", columnDefinition = "decimal(10,2) default 0.0")
	private BigDecimal balanceLkr = new BigDecimal(0.0);
	
	@Column(name = "saved_by", length = 15)
	private String savedBy;
	
	@Column(name = "saved_on")
	private Date savedOn;
	
	@Column(name = "saved_ip", length = 20)
	private String savedIp;
	
	@Column(name = "canceled_by", length = 15)
	private String canceledBy;
	
	@Column(name = "canceled_on")
	private Date canceledOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amc_no", nullable = false, foreignKey = @ForeignKey(name = "receipt_fk1"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AmcMaster amcMaster;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_dept_id", nullable = false, foreignKey = @ForeignKey(name = "receipt_fk2"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ClientDepartment clientDepartment;
	
	@ManyToOne()
	@JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "receipt_fk3"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	@ManyToOne()
	@JoinColumn(name = "currency_id", nullable = false, foreignKey = @ForeignKey(name = "receipt_fk4"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Currency currency;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pi_no", nullable = false, foreignKey = @ForeignKey(name = "receipt_fk5"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProformaInvoice invoice;
}
