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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "proforma_invoice")
public class ProformaInvoice {
	
	@Id
	@Column(name = "pi_no", length = 10)
	private String piNo;
	
	@Column(name = "pi_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date piDate;
	
	private boolean cancel;
	
	@Column(name = "cancel_reason", length = 100)
	private String cancelReason;
	
	@Column(name = "tax_applicable")
	private boolean taxApplicable;
	
	@Column(name = "exchage_rate", precision = 5, scale = 2, nullable = false)
	private BigDecimal exchageRate;
	
	@Column(name = "total_tax", columnDefinition = "decimal(10,2) default 0.0")
	private BigDecimal totalTax = new BigDecimal(0.0);
	
	@Column(name = "total_amount")
	private BigDecimal totalAmt;
	
	@Column(name = "total_amount_lkr")
	private BigDecimal totalAmtLkr;
	
	@Column(length = 100, nullable = false)
	private String remark;
	
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
	
	@ManyToOne()
	@JoinColumn(name = "frequency_id", nullable = false, foreignKey = @ForeignKey(name = "proforma_fk1"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Frequency frequency;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_dept_id", nullable = false, foreignKey = @ForeignKey(name = "proforma_fk2"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ClientDepartment clientDepartment;
	
	@ManyToOne()
	@JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "proforma_fk3"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amc_no", nullable = false, foreignKey = @ForeignKey(name = "proforma_fk4"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AmcMaster amcMaster;
	
	@ManyToOne()
	@JoinColumn(name = "currency_id", nullable = false, foreignKey = @ForeignKey(name = "proforma_fk5"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Currency currency;

	
}
