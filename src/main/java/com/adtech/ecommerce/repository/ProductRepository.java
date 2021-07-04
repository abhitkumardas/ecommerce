package com.adtech.ecommerce.repository;

import com.adtech.ecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long> {

    Optional<Product> findById(String id);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameContainingAndActiveTrue(String name);
    List<Product> findByActiveAndTagsIn(Boolean active, List<String> tags);
    Page<Product> findByActiveAndTagsIn(Boolean active, List<String> tags, Pageable pageable);
}
