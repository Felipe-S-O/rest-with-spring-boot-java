package com.felipe.rest_with_spring_boot_java.data;

public record PersonDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        String gender) {
}
