package com.lukian.customermicroservice.service;

import com.lukian.customermicroservice.entity.Customer;
import com.lukian.customermicroservice.exception.CustomerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    public void createCustomer() {
        int sizeBeforeAdding = service.getAll().size();
        service.createCustomer(new Customer(1,"name", "pesel", "surname"));
        assertEquals(sizeBeforeAdding + 1, service.getAll().size());
    }

    @Test
    public void getByCreditId() {
        service.createCustomer(new Customer(9,"name", "pesel", "surname"));
        assertNotNull(service.getByCreditId(9));
    }

    @Test
    public void getByWrongCreditId() {
        try {
            service.getByCreditId(33);
        } catch (CustomerNotFoundException e) {
            assertTrue(true);
        }
    }
}