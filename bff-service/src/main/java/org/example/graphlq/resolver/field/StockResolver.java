package org.example.graphlq.resolver.field;

import org.example.graphlq.domain.Product;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StockResolver {

    @SchemaMapping(typeName = "Product", field = "stock")
    public int productStock(Product product) {
        return (int) product.getPrice();
    }
}
