package com.lukian.productmicroservice.controller;

import com.lukian.productmicroservice.entity.Product;
import com.lukian.productmicroservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping()
    public void create(@RequestBody Product product) {
        service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") int id) {
        return service.getByCreditId(id);
    }

}
