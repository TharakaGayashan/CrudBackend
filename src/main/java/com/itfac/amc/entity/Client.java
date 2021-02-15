package com.itfac.amc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.itfac.amc.util.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Client extends Auditable{

	@Id
	@Column(name = "client_id", length = 15)
	private String clietnID;
	
	@Column(name = "client_name", length = 100, nullable = false)
	private String clientName;
	
	private boolean active;
	
	@Column(name = "conatact_no", length = 60, nullable = false)
	private String contactNo;
	
	@Column(name = "conatact_person", length = 100, nullable = false)
	private String contactPerson;
	
	@Column(nullable = false)
	private String address;
	
	@Column(name = "saved_ip", length = 20)
	private String savedIp;
}
