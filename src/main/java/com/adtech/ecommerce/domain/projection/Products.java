package com.adtech.ecommerce.domain.projection;

import com.adtech.ecommerce.domain.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.Set;

@Projection(types = {Product.class})
public interface Products {

    String getId();
    String getName();
    String getDescription();
    Set<String> getTags();
    ProductCategories getProductCategory();
}
