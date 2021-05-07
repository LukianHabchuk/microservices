package com.lukian.customermicroservice.controller;

import com.lukian.customermicroservice.entity.Customer;
import com.lukian.customermicroservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PostMapping()
    public void create(@RequestBody Customer customer) {
        service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") int id) {
        return service.getByCreditId(id);
    }
}
