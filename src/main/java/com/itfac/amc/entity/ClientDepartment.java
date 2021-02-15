package com.itfac.amc.entity;

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
@Table(name = "client_department")
public class ClientDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private int deptId;

	@Column(name = "department_name", length = 100, nullable = false)
	private String departmentName;

	private boolean active;
	
	@Column(length = 60, nullable = false)
	private String email;

	@Column(name = "conatact_no", length = 60, nullable = false)
	private String contactNo;

	@Column(name = "conatact_person", length = 100, nullable = false)
	private String contactPerson;

	@Column(nullable = false)
	private String address;

	@Column(name = "saved_by", length = 15)
	private String savedBy;

	@Column(name = "saved_on")
	private Date savedOn;

	@Column(name = "saved_ip", length = 20)
	private String savedIp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "client_dept_fk"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client client;
}
