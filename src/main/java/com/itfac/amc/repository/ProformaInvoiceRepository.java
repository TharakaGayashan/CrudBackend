package com.itfac.amc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.ProformaInvoice;

@Repository
public interface ProformaInvoiceRepository extends JpaRepository<ProformaInvoice, String> {

	Optional<ProformaInvoice> findById(int piNo);

	void deleteById(int id);

}
