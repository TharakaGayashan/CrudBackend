package com.itfac.amc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itfac.amc.entity.Currency;
import com.itfac.amc.repository.CurrencyRepository;
import com.itfac.amc.service.Currencyservice;

@Service
public class CurrencyserviseIml implements Currencyservice{
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Override
	public List<Currency> getAllCurrency() {
		List<Currency> Currency = currencyRepository.findAll();
		return Currency;
	}
	
	@Override
	public Optional<Currency> getCurrencyById(int id) {
		Optional<Currency> Currency = currencyRepository.findById(id);
		return Currency;
	}
	
	@Override
	public void deleteCurrency(int id) {
		currencyRepository.deleteById(id);
	}
}
