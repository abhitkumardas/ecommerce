package com.adtech.ecommerce.domain.projection;

import com.adtech.ecommerce.domain.Product;
import com.adtech.ecommerce.domain.ProductCategory;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {ProductCategory.class})
public interface ProductCategories {
    String getId();
    String getName();
}
