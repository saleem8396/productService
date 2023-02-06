package com.microservice.architecture.productservice.exception;

import com.microservice.architecture.productservice.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ProductNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleExceptionProduct(ProductNotFoundException productNotFoundException){

        return new ResponseEntity<>(new ErrorMessage().builder()
                .code(productNotFoundException.getMessage())
                .message(productNotFoundException.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

}
