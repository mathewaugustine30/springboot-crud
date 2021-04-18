package com.mathew.java.springbootcrud.web.exception;

public class ProductNotFoundException extends Exception{

    private Integer productId;

    public static ProductNotFoundException createWith(Integer productId) {
        return new ProductNotFoundException(productId);
    }

    private ProductNotFoundException(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return "Product with '" + productId + "' not found";
    }
}
