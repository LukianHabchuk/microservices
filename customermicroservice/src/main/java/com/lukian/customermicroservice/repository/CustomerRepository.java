package com.lukian.customermicroservice.repository;

import com.lukian.customermicroservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByCreditId(int id);
}
