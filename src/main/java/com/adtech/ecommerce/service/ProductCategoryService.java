package com.adtech.ecommerce.service;

import com.adtech.ecommerce.domain.ProductCategory;
import com.adtech.ecommerce.domain.projection.ProductCategories;
import com.adtech.ecommerce.domain.request.ProductCategoryDto;
import com.adtech.ecommerce.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProjectionFactory projectionFactory;

    public List<ProductCategories> getAll(Pageable pageable) {
        return productCategoryRepository.findAll(pageable).stream().map(p -> projectionFactory.createProjection(ProductCategories.class, p)).collect(Collectors.toList());
    }

    public ProductCategories addUpdate(ProductCategoryDto productCategoryDto) {

        ProductCategory productCategory = null;

        if (productCategoryDto.getId() != null) {
            productCategory = productCategoryRepository.findById(productCategoryDto.getId()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Id")
            );
        } else {
            productCategory = new ProductCategory();
            productCategory.setCreatedAt(new Date());
        }

        if (productCategoryDto.getName()!=null) productCategory.setName(productCategoryDto.getName());
        productCategory.setLastModifiedAt(new Date());
        productCategory = productCategoryRepository.save(productCategory);

        return projectionFactory.createProjection(ProductCategories.class, productCategory);
    }
}
