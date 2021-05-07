package com.lukian.productmicroservice.service;

import com.lukian.productmicroservice.entity.Product;
import com.lukian.productmicroservice.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void createProduct() {
        int sizeBeforeAdding = service.getAll().size();
        service.createProduct(new Product(1,"name", 3000));
        assertEquals(sizeBeforeAdding + 1, service.getAll().size());
    }

    @Test
    public void getByCreditId() {
        service.createProduct(new Product(9, "name9", 3000));
        assertNotNull(service.getByCreditId(9));
    }

    @Test
    public void getByWrongCreditId() {
        try {
            service.getByCreditId(33);
        } catch (ProductNotFoundException e) {
            assertTrue(true);
        }
    }
}