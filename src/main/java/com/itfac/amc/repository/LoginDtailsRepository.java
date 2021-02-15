package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.LoginDetails;

@Repository
public interface LoginDtailsRepository extends JpaRepository<LoginDetails, Integer> {

}
