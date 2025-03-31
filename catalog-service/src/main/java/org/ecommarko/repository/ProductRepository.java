package org.ecommarko.repository;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.NewSpan;
import jakarta.annotation.Nonnull;
import org.ecommarko.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Observed
public interface ProductRepository extends MongoRepository<Product, String> {

    @Observed
    @NewSpan("findByCategory")
    @Query("{'category': ?0}")
    List<Product> findByCategory(String category);


    @Observed
    @NewSpan("findById")
    Optional<Product> findById(@Nonnull String id);

}
