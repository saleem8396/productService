package com.microservice.architecture.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {

    private Long ProductId;
    private String productName;
    private Long price;
    private Long quantity;
}
