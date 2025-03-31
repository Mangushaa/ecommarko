package org.ecommarko.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final String EXCEPTION_MSG = "Product with id %s not found!";
    private String productId;

    public ProductNotFoundException(String productId) {
        super(EXCEPTION_MSG.formatted(productId));
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
