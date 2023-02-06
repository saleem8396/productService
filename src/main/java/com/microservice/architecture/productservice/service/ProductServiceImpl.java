package com.microservice.architecture.productservice.service;

import com.microservice.architecture.productservice.entity.Product;
import com.microservice.architecture.productservice.model.ProductModel;
import com.microservice.architecture.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Long addProducts(ProductModel productModel) {

        log.info("creating product");
        Product product= Product.builder()
                .productName(productModel.getProductName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .build();
        productRepository.save(product);
        log.info("product saved in database");
        return product.getProductId();

    }

    @Override
    public ProductModel getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no product found"));
        ProductModel model = new ProductModel();
        BeanUtils.copyProperties(product, model);
        return model;
    }
}
