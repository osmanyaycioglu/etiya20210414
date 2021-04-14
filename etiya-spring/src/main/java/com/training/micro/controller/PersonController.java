package com.training.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Person;
import com.training.micro.models.Phone;
import com.training.micro.services.PersonManager;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonController {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person personParam) {
        if (personParam.getName() == null) {
            throw new IllegalArgumentException("name null olamaz");
        }
        List<Phone> phonesLoc = personParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setPerson(personParam);
        }
        personParam.getPersonEx()
                   .setPerson(personParam);
        this.pm.add(personParam);
        return "OK";
    }


}
