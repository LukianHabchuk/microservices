package com.lukian.creditmicroservice.controller;

import com.lukian.creditmicroservice.dto.CreditInfo;
import com.lukian.creditmicroservice.entity.Credit;
import com.lukian.creditmicroservice.service.CreditService;
import com.lukian.creditmicroservice.service.CustomerService;
import com.lukian.creditmicroservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/credit")
@Slf4j
public class CreditController {

    private final CreditService creditService;
    private final CustomerService customerService;
    private final ProductService productService;

    public CreditController(CreditService creditService,
                            CustomerService customerService,
                            ProductService productService) {
        this.creditService = creditService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @PostMapping
    public int createCredit(@RequestBody CreditInfo creditInfo) {
        log.info("caught object credit info: " + creditInfo.toString());
        return createInfoObjects(creditInfo);
    }

    @GetMapping
    public List<CreditInfo> getCredits() {
        List<CreditInfo> infoList = new ArrayList<>();
        creditService.getAll().forEach(c ->
            infoList.add(createCreditInfo(c))
        );
        return infoList;
    }

    private int createInfoObjects(CreditInfo creditInfo) {
        int creditId = creditService.getAll().size() + 1;
        log.info("creditId: " + creditId);
        productService.createProduct(creditInfo.parseProduct(creditId));
        customerService.createCustomer(creditInfo.parseCustomer(creditId));
        return creditService.create(creditInfo.parseCredit(creditId)).getId();
    }

    private CreditInfo createCreditInfo(Credit credit) {
        return new CreditInfo(
                customerService.getCustomer(credit.getId()).parseCustomerDTO(),
                productService.getProduct(credit.getId()).parseProductDTO(),
                credit.parseCreditDTO()
        );
    }
}
