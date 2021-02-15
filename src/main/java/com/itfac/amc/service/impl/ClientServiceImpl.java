package com.itfac.amc.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.amc.dto.ClientDto;
import com.itfac.amc.entity.Client;
import com.itfac.amc.repository.ClientRepository;
import com.itfac.amc.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Client addClient(HttpServletRequest httpServletRequest, Client client) throws Exception{
		String ipAddress = httpServletRequest.getRemoteAddr();
		client.setSavedIp(ipAddress);
		return clientRepository.save(client);
	}

	@Override
	public List<ClientDto> getClient(String clientName) {
		return clientRepository.findByClientName(clientName);
	}

}
