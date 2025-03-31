package org.ecommarko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private Long id;

    private String sku;

    private int quantity;

    @Version
    private int version;
}
