package com.felipe.rest_with_spring_boot_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.rest_with_spring_boot_java.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}