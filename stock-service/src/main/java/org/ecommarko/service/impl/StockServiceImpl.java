package org.ecommarko.service.impl;

import org.ecommarko.entity.Stock;
import org.ecommarko.repository.StockRepository;
import org.ecommarko.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock getSkuStock(String sku) {
        return stockRepository.findBySku(sku);
    }

    @Override
    public void updateSkuStock(String sku, int quantity) {
        Stock skuStock = stockRepository.findBySku(sku);
        skuStock.setQuantity(skuStock.getQuantity() + quantity);
        stockRepository.save(skuStock);
    }

    @Override
    public void createSkuStock(String sku, int quantity) {
        Stock stock = new Stock();
        stock.setSku(sku);
        stock.setQuantity(quantity);
        stockRepository.save(stock);
    }
}
