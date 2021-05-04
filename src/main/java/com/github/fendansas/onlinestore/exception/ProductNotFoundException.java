package com.github.fendansas.onlinestore.exception;

public class ProductNotFoundException extends RuntimeException {

    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
