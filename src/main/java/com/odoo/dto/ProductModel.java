package com.odoo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    private String productId;
    private String title;
    private String description;
    private String category;
    private float price;
    private String imagePlaceholder;
    private String userId;
    private Boolean is_purchase;
    private String metaData;
    private Boolean active;
}
