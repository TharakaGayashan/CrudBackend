package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.ClientDepartment;

@Repository
public interface ClientDepartmentRepository extends JpaRepository<ClientDepartment, Integer> {

	
	
}
