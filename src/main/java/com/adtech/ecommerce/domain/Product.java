package com.adtech.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    private Boolean active;
    private String name;
    private String description;
    private Float price;
    private Float procurementPrice;
    private Set<String> tags;
    @DBRef
    private ProductCategory productCategory;
    private Date createdAt;
    private Date lastModifiedAt;
}
