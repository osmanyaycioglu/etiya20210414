package com.training.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.dep.injection.MyObject;

@RestController
@RequestMapping("/first")
public class MyFirstController {

    @Autowired
    @Qualifier("xyz")
    private MyObject       myO;

    private final MyObject myO1;

    private MyObject       myO2;

    @Autowired
    public MyFirstController(@Qualifier("asd") final MyObject myO1) {
        this.myO1 = myO1;
    }

    @Autowired
    public void xyz(@Qualifier("asd") final MyObject myO2) {
        this.myO2 = myO2;
        myO2.setName("veli");
    }

    @GetMapping("/hello1")
    public String hello() {
        return "Hello " + this.myO.hello();
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello " + this.myO1.hello();
    }

    @GetMapping("/hello3")
    public String hello3() {
        return "Hello " + this.myO2.hello();
    }


}
