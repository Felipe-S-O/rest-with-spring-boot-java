package com.felipe.rest_with_spring_boot_java.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.rest_with_spring_boot_java.data.dto.v1.BookDTO;
import com.felipe.rest_with_spring_boot_java.exceptions.ResouceNotFoundException;
import com.felipe.rest_with_spring_boot_java.mapper.ObjectMapper;
import com.felipe.rest_with_spring_boot_java.model.Book;
import com.felipe.rest_with_spring_boot_java.repository.BookRepository;

@Service
public class BookServices {

    @Autowired
    private BookRepository repository;

    private Logger logger = Logger.getLogger(BookServices.class.getName());

    public List<BookDTO> findAll() {
        logger.info("Finding all Book!");

        return ObjectMapper.parseListObjects(repository.findAll(), BookDTO.class);
    }

    public BookDTO findByid(Long id) {

        logger.info("Finding one Book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        return ObjectMapper.parseObject(entity, BookDTO.class);
    }

    public BookDTO create(BookDTO book) {
        logger.info("Create one book!");
        var entity = ObjectMapper.parseObject(book, Book.class);

        return ObjectMapper.parseObject(repository.save(entity), BookDTO.class);
    }

    public BookDTO update(BookDTO book) {
        logger.info("Updating one Book!");

        Book entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return ObjectMapper.parseObject(repository.save(entity), BookDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one book!" + id);

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}