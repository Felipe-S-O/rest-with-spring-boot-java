package com.felipe.rest_with_spring_boot_java.exception;

import java.util.Date;

// gera a mensagem json
public record ExceptionResponse(Date timestamp, String message, String details) {

}
