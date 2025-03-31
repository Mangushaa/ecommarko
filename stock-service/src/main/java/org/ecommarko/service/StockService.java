package org.ecommarko.service;

import org.ecommarko.entity.Stock;

public interface StockService {

    Stock getSkuStock(String sku);

    void updateSkuStock(String sku, int quantity);

    void createSkuStock(String sku, int quantity);
}
