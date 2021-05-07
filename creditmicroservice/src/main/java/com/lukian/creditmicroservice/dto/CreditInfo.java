package com.lukian.creditmicroservice.dto;

import com.lukian.creditmicroservice.entity.Credit;
import com.lukian.creditmicroservice.entity.Customer;
import com.lukian.creditmicroservice.entity.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreditInfo {
    private CustomerDTO customer;
    private ProductDTO product;
    private CreditDTO credit;

    public Product parseProduct(int creditId) {
        return new Product(product, creditId);
    }

    public Customer parseCustomer(int creditId) {
        return new Customer(creditId, customer);
    }

    public Credit parseCredit(int creditId) {
        return new Credit(creditId, credit.getName());
    }
}
