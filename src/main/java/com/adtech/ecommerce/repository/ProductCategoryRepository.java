package com.adtech.ecommerce.repository;

import com.adtech.ecommerce.domain.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, Long> {

    Optional<ProductCategory> findById(String id);
    List<ProductCategory> findByNameContaining(String name);
}
