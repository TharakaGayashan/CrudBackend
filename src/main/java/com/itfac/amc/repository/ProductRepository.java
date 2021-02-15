package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
