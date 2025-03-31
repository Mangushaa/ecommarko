package org.ecommarko.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Product {

    @Id
    private String id;

    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private int stock;
    private String category;
    private List<Attribute> attributes;
}
