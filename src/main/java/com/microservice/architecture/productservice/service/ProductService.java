package com.microservice.architecture.productservice.service;

import com.microservice.architecture.productservice.model.ProductModel;

public interface ProductService {
    Long addProducts(ProductModel productModel);

    ProductModel getProductById(Long id);
}
