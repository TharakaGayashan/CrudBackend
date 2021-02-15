package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
