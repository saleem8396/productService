package com.microservice.architecture.productservice.exception;

public class ProductNotFoundException extends RuntimeException{

    private String code;
    private String message;
    public ProductNotFoundException(String message,String code){
        super(message);
        this.message=message;
        this.code=code;
    }
}
