package com.adtech.ecommerce.service;

import com.adtech.ecommerce.domain.Product;
import com.adtech.ecommerce.domain.ProductCategory;
import com.adtech.ecommerce.domain.projection.ProductCategories;
import com.adtech.ecommerce.domain.projection.Products;
import com.adtech.ecommerce.domain.request.ProductCategoryDto;
import com.adtech.ecommerce.domain.request.ProductDto;
import com.adtech.ecommerce.repository.ProductCategoryRepository;
import com.adtech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProjectionFactory projectionFactory;

    public List<Products> getAll(Pageable pageable) {
        return productRepository.findAll(pageable).stream().map(p -> projectionFactory.createProjection(Products.class, p)).collect(Collectors.toList());
    }

    public List<Products> getAllWithTags(List<String> tags, Pageable pageable) {
        Page<Product> products = null;
        if (tags != null ) {
            products = productRepository.findByActiveAndTagsIn(true, tags, pageable);
        }else {
            products = productRepository.findAll(pageable);
        }

        return products.stream().map(p -> projectionFactory.createProjection(Products.class, p)).collect(Collectors.toList());
    }

    public Products addUpdate(ProductDto productDto) {

        Product product = null;

        if (productDto.getId() != null) {
            product = productRepository.findById(productDto.getId()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Product Id")
            );
            if (productDto.getActive()!=null) product.setActive(productDto.getActive());
        } else {
            product = new Product();
            product.setActive(productDto.getActive()!=null ? productDto.getActive() : true);
            product.setCreatedAt(new Date());
        }

        if (productDto.getDescription()!= null) product.setDescription(productDto.getDescription());
        if (productDto.getName() != null) product.setName(productDto.getName());
        if (productDto.getProcurementPrice() != null) product.setProcurementPrice(productDto.getProcurementPrice());
        if (productDto.getPrice() != null) product.setPrice(productDto.getPrice());

        if (productDto.getTags() != null && !productDto.getTags().isEmpty()) {
            Set<String> tags = product.getTags()!=null ? product.getTags() : new HashSet<>();
            tags.addAll(productDto.getTags());
            product.setTags(tags);
        }

        if (productDto.getProductCategory() != null) {

            ProductCategory productCategory = null;

            ProductCategoryDto reqProductCategory = productDto.getProductCategory();
            if (reqProductCategory.getId() !=null ) {
                productCategory = productCategoryRepository.findById(reqProductCategory.getId()).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Product Category Id")
                );
            } else {
                //todo create
                productCategory = new ProductCategory();
                productCategory.setCreatedAt(new Date());
            }

            if (reqProductCategory.getName() != null) {
                productCategory.setName(reqProductCategory.getName());
                productCategory.setLastModifiedAt(new Date());
            }

            productCategory = productCategoryRepository.save(productCategory);
            product.setProductCategory(productCategory);
        }

        product.setLastModifiedAt(new Date());
        product = productRepository.save(product);

        return projectionFactory.createProjection(Products.class, product);
    }

//    private Object createProductCtegoriesIfNotExists(Set<String> existingProductCategoryNames, List<ProductCategory> productCategories) {
//
//        Set<ProductCategory> productCategorySet = new HashSet<>();
//
//        productCategories.stream().forEach( pc -> {
//            if (existingProductCategoryNames.contains(pc.getName())) {
//                productCategoryRepository.
//            } else {
//                //todo: create
//
//            }
//        });
//    }
}
