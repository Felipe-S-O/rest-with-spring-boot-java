package com.felipe.rest_with_spring_boot_java.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.rest_with_spring_boot_java.data.dto.v1.PersonDTO;
import com.felipe.rest_with_spring_boot_java.exceptions.ResouceNotFoundException;
import com.felipe.rest_with_spring_boot_java.mapper.ObjectMapper;
import com.felipe.rest_with_spring_boot_java.model.Person;
import com.felipe.rest_with_spring_boot_java.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding all Persons!");

        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findByid(Long id) {

        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Create one Person!");
        var entity = ObjectMapper.parseObject(person, Person.class);

        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!" + id);

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

}
