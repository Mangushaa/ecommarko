package org.ecommarko.service.impl;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.NewSpan;
import org.ecommarko.exception.ProductNotFoundException;
import org.ecommarko.model.Product;
import org.ecommarko.repository.ProductRepository;
import org.ecommarko.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getCategoryProducts(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    @NewSpan( name = "get product by id", value = "get product by id")
    public Product getProductById(String id) {
        LOG.info("Service Span Started: " + id);
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    @Observed
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Observed
    public List<Product> createProductBatch(List<Product> products) {
        return productRepository.saveAll(products);
    }


}
