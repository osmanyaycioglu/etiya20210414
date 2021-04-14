package com.training.micro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Person;

@RestController
@RequestMapping({
                  "/api/v1/hello",
                  "/api/v2/hello"
})
public class HelloController {

    @GetMapping("/h1")
    public String hello1() {
        return "Hello GET";
    }

    @PostMapping("/h1")
    public String hello1p() {
        return "Hello POST";
    }


    @GetMapping("/h2/{xyz}/{abc}/{dfg}")
    public String hello2(@PathVariable(name = "xyz") final String name,
                         @PathVariable("abc") final String surname,
                         @PathVariable(name = "dfg") final int age) {
        return "Hello 2 " + name + " " + surname + " " + age;
    }

    @GetMapping("/h3")
    public String hello3(@RequestParam("isim") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/h8")
    public String hello8(@RequestHeader("isim") final String name,
                         @RequestHeader("soy") final String surname) {
        return "Hello 8 " + name + " " + surname;
    }

    @GetMapping("/h4/{op}")
    public String hello4(@RequestParam(name = "op", required = false) final String op,
                         final HttpServletRequest htsr) {

        switch (op) {
            case "id":
                htsr.getAttribute("");
                break;
            case "sdhjg1":

                break;

            default:
                break;
        }
        return "test";
    }

    @PostMapping("/h5")
    public Person h5(@RequestBody final Person person) {
        person.setName("osman");
        return person;
    }

    @PostMapping("/h7")
    public ResponseEntity<Person> h7(@RequestBody final Person person) {
        person.setName("osman");
        return ResponseEntity.status(201)
                             .header("deneme",
                                     "denemeValue")
                             .body(person);
    }

    @PostMapping(value = "/h6",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person h6(@RequestBody final Person person) {
        person.setName("osman");
        return person;
    }


}
