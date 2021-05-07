package com.lukian.creditmicroservice.service;

import com.lukian.creditmicroservice.entity.Product;
import com.lukian.creditmicroservice.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.lukian.creditmicroservice.constants.UrlConstants.CREATE_PRODUCT_URL;
import static com.lukian.creditmicroservice.constants.UrlConstants.GET_PRODUCT_URL;

@Service
@Slf4j
public class ProductService {
    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createProduct(Product product) {
        try {
            log.info("trying to post object Product to productmicroservice");
            restTemplate.postForObject(new URI(CREATE_PRODUCT_URL), product, Product.class);
            log.info("new product created successfully");
        } catch (Exception e) {
            log.warn("exception while posting new product: " + e.getMessage());
        }
    }

    public Product getProduct(int id) {
        try {
            return restTemplate.getForObject((new URI(GET_PRODUCT_URL + id)), Product.class);
        } catch (Exception e) {
            throw new ProductNotFoundException("exception was thrown while trying get product by id: " + id + " Error message: " + e.getMessage());
        }
    }
}
