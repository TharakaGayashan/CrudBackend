package com.itfac.amc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.itfac.amc.entity.Currency;
import com.itfac.amc.service.Currencyservice;


@RestController
@RequestMapping("Currency/")
public class CurrencyController {
	
	@Autowired
	Currencyservice currencyservice;
	
	@GetMapping("findAllCurrency")
	public List<Currency> getAllCurrency(){
		return currencyservice.getAllCurrency();
	}
	
	@GetMapping("findCurrency/{id}")
	ResponseEntity<Optional<Currency>> getCategoryById(@PathVariable("id") int currencyId){
		Optional<Currency> currency = currencyservice.getCurrencyById(currencyId);
		if(currency!=null) {
			return ResponseEntity.ok(currency);	
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Des", "No currency with entered id " + currencyId).body(currency);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="deleteCurrency/{id}")
	public void deleteCurrency(@PathVariable("id") int currencyId) {
		currencyservice.deleteCurrency(currencyId);
	}
	

}

