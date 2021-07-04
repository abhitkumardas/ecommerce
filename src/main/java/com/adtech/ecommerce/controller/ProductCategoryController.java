package com.adtech.ecommerce.controller;

import com.adtech.ecommerce.domain.ProductCategory;
import com.adtech.ecommerce.domain.request.ProductCategoryDto;
import com.adtech.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/all")
    public ResponseEntity getAllCategories(Pageable pageable) {
        return ResponseEntity.ok(productCategoryService.getAll(pageable));
    }

    @PostMapping(value = "/add-update")
    public ResponseEntity addUpdate(@RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity.ok(productCategoryService.addUpdate(productCategoryDto));
    }
}
