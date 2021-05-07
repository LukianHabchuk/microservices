package com.lukian.creditmicroservice.constants;

public final class UrlConstants {

    private UrlConstants() { }

    public static final String CREATE_CUSTOMER_URL =
            "http://localhost:8081/customer";
    public static final String CREATE_PRODUCT_URL =
            "http://localhost:8083/product";
    public static final String GET_CUSTOMER_URL =
            "http://localhost:8081/customer/";
    public static final String GET_PRODUCT_URL =
            "http://localhost:8083/product/";
}
