package com.lukian.productmicroservice.service;

import com.lukian.productmicroservice.entity.Product;
import com.lukian.productmicroservice.exception.ProductNotFoundException;
import com.lukian.productmicroservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public void createProduct(Product product) {
        repository.save(product);
    }

    public Product getByCreditId(int id) {
        return repository.findProductByCreditId(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product with credit id: " + (id) + " was not found."));
    }
}
