package com.lukian.creditmicroservice.controller;

import com.lukian.creditmicroservice.dto.CreditInfo;
import com.lukian.creditmicroservice.util.ServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lukian.creditmicroservice.util.Validator.isValid;

@RestController
@RequestMapping("/credit")
@Slf4j
public class CreditController {

    private final ServiceManager serviceManager;

    public CreditController(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @PostMapping
    public int createCredit(@RequestBody CreditInfo creditInfo) {
        log.info("caught object credit info: " + creditInfo.toString());
        return isValid(creditInfo) ? serviceManager.manageObjectsCreation(creditInfo) : -1;
    }

    @GetMapping
    public List<CreditInfo> getCredits() {
        return serviceManager.createCreditList();
    }
}
