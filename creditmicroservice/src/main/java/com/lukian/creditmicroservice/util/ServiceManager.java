package com.lukian.creditmicroservice.util;

import com.lukian.creditmicroservice.dto.CreditInfo;
import com.lukian.creditmicroservice.entity.Credit;
import com.lukian.creditmicroservice.service.CreditService;
import com.lukian.creditmicroservice.service.CustomerService;
import com.lukian.creditmicroservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceManager {

    private final CreditService creditService;
    private final CustomerService customerService;
    private final ProductService productService;

    public ServiceManager(CreditService creditService, CustomerService customerService, ProductService productService) {
        this.creditService = creditService;
        this.customerService = customerService;
        this.productService = productService;
    }

    public int manageObjectsCreation(CreditInfo creditInfo) {
        int creditId = creditService.getAll().size() + 1;
        productService.createProduct(creditInfo.parseProduct(creditId));
        customerService.createCustomer(creditInfo.parseCustomer(creditId));
        return creditService.create(creditInfo.parseCredit(creditId)).getId();
    }

    public List<CreditInfo> createCreditList() {
        List<CreditInfo> infoList = new ArrayList<>();
        creditService.getAll().forEach(c ->
                infoList.add(createCreditInfo(c))
        );
        return infoList;
    }

    private CreditInfo createCreditInfo(Credit credit) {
        return new CreditInfo(
                customerService.getCustomer(credit.getId()).parseCustomerDTO(),
                productService.getProduct(credit.getId()).parseProductDTO(),
                credit.parseCreditDTO()
        );
    }
}
