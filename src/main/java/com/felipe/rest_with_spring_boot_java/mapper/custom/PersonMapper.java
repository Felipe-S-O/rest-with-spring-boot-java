package com.felipe.rest_with_spring_boot_java.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.felipe.rest_with_spring_boot_java.data.dto.v2.PersonDTOV2;
import com.felipe.rest_with_spring_boot_java.model.Person;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        var personDTOV2 = new PersonDTOV2();
        personDTOV2.setId(person.getId());
        personDTOV2.setFirstName(person.getFirstName());
        personDTOV2.setLastName(person.getLastName());
        personDTOV2.setAddress(person.getAddress());
        personDTOV2.setGender(person.getGender());
        personDTOV2.setBirthDate(new Date());
        return personDTOV2;
    }

    public Person convertDTOtoEntity(PersonDTOV2 person) {
        var entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
