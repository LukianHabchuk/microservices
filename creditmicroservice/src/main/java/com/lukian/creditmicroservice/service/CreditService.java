package com.lukian.creditmicroservice.service;

import com.lukian.creditmicroservice.entity.Credit;
import com.lukian.creditmicroservice.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {
    private final CreditRepository repository;

    public CreditService(CreditRepository repository) {
        this.repository = repository;
    }

    public Credit create(Credit credit) {
        return repository.save(credit);
    }

    public List<Credit> getAll() {
        return repository.findAll();
    }
}
