package com.adtech.ecommerce.domain.request;

import com.adtech.ecommerce.domain.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;
    private Boolean active;
    private String name;
    private String description;
    private Float price;
    private Float procurementPrice;
    private List<String> tags;
    private ProductCategoryDto productCategory;
    private Date createdAt;
    private Date lastModifiedAt;
}
