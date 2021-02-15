package com.itfac.amc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.itfac.amc.entity.ProformaInvoice;
import com.itfac.amc.repository.ProformaInvoiceRepository;
import com.itfac.amc.service.ProformaInvoiceService;

public class ProformaInvoiceServiceImpl implements ProformaInvoiceService{

	@Autowired
	private ProformaInvoiceRepository proformaInvoiceRepository;
	
	@Override
	public List<ProformaInvoice> getAllProformaInvoice() {
		return proformaInvoiceRepository.findAll();
	}

	@Override
	public Optional<ProformaInvoice> getProformaInvoiceById(int piNo) {
		Optional<ProformaInvoice> invoice = proformaInvoiceRepository.findById(piNo);
		return invoice;
	}

	@Override
	public void deleteInvoice(int id) {
	    proformaInvoiceRepository.deleteById(id);
	}
}
