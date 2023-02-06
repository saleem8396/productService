package com.microservice.architecture.productservice.controller;

import com.microservice.architecture.productservice.model.ProductModel;
import com.microservice.architecture.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProducts(@RequestBody ProductModel productModel){

        Long productId=productService.addProducts(productModel);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Long id){

        ProductModel product =productService.getProductById(id);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
