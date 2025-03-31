package org.example.controller.dto;

import org.example.model.RecommendedProduct;

public record RecommendedProductResponse(String text, RecommendedProduct product) {
}
