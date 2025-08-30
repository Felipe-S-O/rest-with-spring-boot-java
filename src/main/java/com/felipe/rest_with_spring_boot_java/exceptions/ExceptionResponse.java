package com.felipe.rest_with_spring_boot_java.exceptions;

import java.util.Date;

// gera a mensagem json
public record ExceptionResponse(Date timestamp, String message, String details) {

}
