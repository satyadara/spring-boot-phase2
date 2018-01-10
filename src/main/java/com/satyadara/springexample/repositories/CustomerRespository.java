package com.satyadara.springexample.repositories;

import com.satyadara.springexample.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, String>{
}
