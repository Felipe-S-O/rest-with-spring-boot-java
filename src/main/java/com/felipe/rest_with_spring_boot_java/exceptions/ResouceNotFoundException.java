package com.felipe.rest_with_spring_boot_java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//class gera o status code 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(String ex) {
        super(ex);
    }
}
