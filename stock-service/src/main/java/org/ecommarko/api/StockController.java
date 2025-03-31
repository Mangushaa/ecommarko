package org.ecommarko.api;

import org.ecommarko.entity.Stock;
import org.ecommarko.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{sku}")
    public Stock getSkuStock(@PathVariable String sku) {
        return stockService.getSkuStock(sku);
    }

    @PostMapping
    public ResponseEntity<Boolean> getSkuStock(@RequestBody Stock stock) {
        stockService.createSkuStock(stock.getSku(), stock.getQuantity());
        return ResponseEntity.status(201).body(true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{sku}")
    public boolean updateSkuStock(@PathVariable String sku, @RequestParam(name = "quantity") int quantity) {
        stockService.updateSkuStock(sku, quantity);
        return true;
    }
}
