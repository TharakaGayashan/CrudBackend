package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.Frequency;

@Repository
public interface FrequencyRepository extends JpaRepository<Frequency, Integer> {

}
