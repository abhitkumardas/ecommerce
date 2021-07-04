package com.adtech.ecommerce.controller;

import com.adtech.ecommerce.domain.request.ProductCategoryDto;
import com.adtech.ecommerce.domain.request.ProductDto;
import com.adtech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public ResponseEntity getAllCategories(Pageable pageable, @RequestParam(required = false) List<String> tags) {
        return ResponseEntity.ok(productService.getAllWithTags(tags, pageable));
    }

    @PostMapping(value = "/add-update")
    public ResponseEntity addUpdate(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addUpdate(productDto));
    }
}
