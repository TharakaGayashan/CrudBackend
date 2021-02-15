package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
