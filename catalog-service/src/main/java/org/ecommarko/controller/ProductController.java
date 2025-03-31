package org.ecommarko.controller;

import org.ecommarko.dto.ErrorDto;
import org.ecommarko.exception.ProductNotFoundException;
import org.ecommarko.model.Product;
import org.ecommarko.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") String id) {
        LOG.info("Controller span " + id);
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/batch")
    public List<Product> createProductBatch(@RequestBody List<Product> products) {
        return productService.createProductBatch(products);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException ex) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode("1");
        errorDto.setMessage("Product with id %s not found!".formatted(ex.getProductId()));
        return ResponseEntity.badRequest().body(errorDto);
    }
}
