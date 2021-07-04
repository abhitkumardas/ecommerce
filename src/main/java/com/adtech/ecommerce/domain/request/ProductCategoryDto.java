package com.adtech.ecommerce.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDto {
    private String id;
    private String name;
    private Date createdAt;
    private Date lastModifiedAt;
}
