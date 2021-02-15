package com.itfac.amc.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.itfac.amc.entity.ProformaInvoice;
import com.itfac.amc.service.ProformaInvoiceService;

@RestController
public class ProformaInvoiceController {
	
	public ProformaInvoiceService proformaInvoiceService;

	//display List of employee
	@GetMapping("findInvoice/{id}")
	ResponseEntity<Optional<ProformaInvoice>> getProformaInvoiceById(@PathVariable("id") int piNo){
		Optional<ProformaInvoice> Invoice = proformaInvoiceService.getProformaInvoiceById(piNo);
		if(Invoice!=null) {
			return ResponseEntity.ok(Invoice);	
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Des", "No currency with entered id " + piNo).body(Invoice);
	}
	
	
}
