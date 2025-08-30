package com.felipe.rest_with_spring_boot_java.services;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.felipe.rest_with_spring_boot_java.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public ArrayList<Person> findAll() {
        logger.info("Finding all Persons!");
        var listPersons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            var person = mockPerson(i);
            listPersons.add(person);
        }
        return listPersons;
    }

    public Person findByid(String id) {

        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Felipe");
        person.setLastName("Silva");
        person.setAddress("João Pessoa - PB");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Create one Person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person!" + id);
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName: " + i);
        person.setLastName("LastName: " + i);
        person.setAddress("Address: " + i);
        person.setGender("Male");
        return person;
    }

}
