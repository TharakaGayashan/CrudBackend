package com.itfac.amc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itfac.amc.dto.ClientDto;
import com.itfac.amc.entity.Client;

public interface ClientService {
	
	Client addClient(HttpServletRequest httpServletRequest, Client client) throws Exception;
	List<ClientDto> getClient(String clientName);

}
