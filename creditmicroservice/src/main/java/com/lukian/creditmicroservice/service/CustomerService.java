package com.lukian.creditmicroservice.service;

import com.lukian.creditmicroservice.entity.Customer;
import com.lukian.creditmicroservice.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static com.lukian.creditmicroservice.constants.UrlConstants.CREATE_CUSTOMER_URL;
import static com.lukian.creditmicroservice.constants.UrlConstants.GET_CUSTOMER_URL;

@Service
@Slf4j
public class CustomerService {
    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createCustomer(Customer customer) {
        try {
            log.info("trying to post object Customer to customermicroservice");
            restTemplate.postForObject(new URI(CREATE_CUSTOMER_URL), customer, Customer.class);
            log.info("new customer created successfully");
        } catch (URISyntaxException e) {
            log.warn("exception while posting new customer: " + e.getMessage());
        }
    }

    public Customer getCustomer(int id) {
        try {
            return restTemplate.getForObject((new URI(GET_CUSTOMER_URL + id)), Customer.class);
        } catch (Exception e) {
            throw new CustomerNotFoundException(
                    "exception was thrown while trying get customer by id: "
                            + id + " Error message: " + e.getMessage());
        }
    }
}
