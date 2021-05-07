package com.lukian.customermicroservice.service;

import com.lukian.customermicroservice.entity.Customer;
import com.lukian.customermicroservice.exception.CustomerNotFoundException;
import com.lukian.customermicroservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public void createCustomer(Customer customer) {
        repository.save(customer);
    }

    public Customer getByCreditId(int id) {
        return repository.findCustomerByCreditId(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with credit id: " + (id) + " was not found."));
    }
}
