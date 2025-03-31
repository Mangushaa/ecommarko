package org.ecommarko.service;

import org.ecommarko.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getCategoryProducts(String category);

    Product getProductById(String id);

    Product createProduct(Product product);
    List<Product> createProductBatch(List<Product> product);
}
