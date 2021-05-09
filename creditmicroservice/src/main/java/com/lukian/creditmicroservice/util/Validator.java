package com.lukian.creditmicroservice.util;

import com.lukian.creditmicroservice.dto.CreditDTO;
import com.lukian.creditmicroservice.dto.CreditInfo;
import com.lukian.creditmicroservice.dto.CustomerDTO;
import com.lukian.creditmicroservice.dto.ProductDTO;

public class Validator {

    private Validator() {
    }

    public static boolean isValid(CreditInfo creditInfo) {
        return isProductValid(creditInfo.getProduct())
                && isCustomerValid(creditInfo.getCustomer())
                && isCreditValid(creditInfo.getCredit());
    }

    private static boolean isProductValid(ProductDTO product) {
        return !product.getName().isEmpty() && product.getValue()>0;
    }

    private static boolean isCustomerValid(CustomerDTO customer) {
        return !customer.getSurname().isEmpty() && !customer.getFirstName().isEmpty() && customer.getPesel().length() == 11;
    }

    private static boolean isCreditValid(CreditDTO credit) {
        return !credit.getName().isEmpty();
    }
}
