package com.odoo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    private String id;
    private String user_id;
    private String product_id;
    private Boolean active;
}
