package com.lukian.productmicroservice.repository;

import com.lukian.productmicroservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductByCreditId(int id);
}
