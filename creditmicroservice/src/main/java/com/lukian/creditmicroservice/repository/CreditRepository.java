package com.lukian.creditmicroservice.repository;

import com.lukian.creditmicroservice.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
