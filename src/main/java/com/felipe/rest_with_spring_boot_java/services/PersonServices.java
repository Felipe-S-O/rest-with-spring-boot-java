package com.felipe.rest_with_spring_boot_java.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.rest_with_spring_boot_java.exceptions.ResouceNotFoundException;
import com.felipe.rest_with_spring_boot_java.model.Person;
import com.felipe.rest_with_spring_boot_java.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all Persons!");

        return repository.findAll();
    }

    public Person findByid(Long id) {

        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Create one Person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!" + id);

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

}
