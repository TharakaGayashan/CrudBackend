package com.itfac.amc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.dto.ClientDto;
import com.itfac.amc.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

		List<ClientDto> findByClientName(String clientName);
	
}
