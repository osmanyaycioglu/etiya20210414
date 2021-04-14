package com.training.micro.controller;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Person;
import com.training.micro.services.PersonManager;

@RestController
@RequestMapping("/api/v1/person/query")
@Validated
public class PersonQueryController {

    private PersonManager pm;

    @GetMapping("/get/one")
    public Person get(@NotNull @RequestParam("pid") final Long pid) {
        return this.pm.getOne(pid);
    }

}
