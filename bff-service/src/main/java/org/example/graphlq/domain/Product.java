package org.example.graphlq.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String sku;
    private String name;
    private double price;
    private String category;
    private int stock;
}
