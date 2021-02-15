package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.AmcDueInvoice;

@Repository
public interface AmcDueInvoiceRepositiory extends JpaRepository<AmcDueInvoice, Integer> {

}
