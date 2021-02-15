package com.itfac.amc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.amc.dto.ClientDto;
import com.itfac.amc.entity.Client;
import com.itfac.amc.service.ClientService;

@RestController
@RequestMapping("client/")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("add")
	ResponseEntity<Client> addClient(HttpServletRequest httpServletRequest, @RequestBody Client client) throws Exception{
		Client newClient = clientService.addClient(httpServletRequest, client);
		return ResponseEntity.ok(newClient);
	}
	
	@GetMapping("findClient/{name}")
	ResponseEntity<List<ClientDto>> getClient(@PathVariable("name") String clientName){
		List<ClientDto> clients = clientService.getClient(clientName);
		if(clients != null) {
			return ResponseEntity.ok(clients);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Des", "No client with name " + clientName).body(clients);
		
	}

}
