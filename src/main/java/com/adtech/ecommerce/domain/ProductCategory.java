package com.adtech.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * Added this because afterwards wanna move this app to SQL based
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCategory {

    @Transient
    public static final String SEQUENCE_NAME = "product_category_sequence";

    @Id
    private String id;
    private String name;
    private Date createdAt;
    private Date lastModifiedAt;

}
