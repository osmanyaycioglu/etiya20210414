package com.training.micro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.micro.jpa.IPersonDao;
import com.training.micro.models.Person;


@Service
public class PersonManager {

    @Autowired
    private IPersonDao personDao;

    public void add(final Person personParam) {
        this.personDao.save(personParam);
    }

    public List<Person> getAllPerson() {
        Iterable<Person> findAllLoc = this.personDao.findAll();
        List<Person> persons = new ArrayList<>();
        for (Person personLoc : findAllLoc) {
            persons.add(personLoc);
        }
        return persons;
    }

    public Person getOne(final Long pidParam) {
        return this.personDao.findById(pidParam)
                             .orElse(null);
    }

}
