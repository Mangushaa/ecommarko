package org.example.graphlq.resolver.root;

import org.example.graphlq.domain.Product;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductQueryResolver {

    @QueryMapping
    public List<Product> products(@Argument("category") String category) {
        return List.of(
                Product.builder()
                    .sku("sku")
                    .name("name")
                    .price(1.0)
                    .category(category)
                    .build(),
                Product.builder()
                    .sku("sku1")
                    .name("name1")
                    .price(2.0)
                    .category(category)
                    .build(),
                Product.builder()
                    .sku("sku3")
                    .name("nam3")
                    .price(3.0)
                    .category(category)
                    .build()
        );
    }


}

