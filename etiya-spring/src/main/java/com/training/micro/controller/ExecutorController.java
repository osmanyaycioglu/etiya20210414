package com.training.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.dep.injection.v2.IExecute;

@RestController
@RequestMapping("/exec")
public class ExecutorController {

    @Autowired
    @Qualifier("dynamic")
    private IExecute exec;

    @GetMapping("/greet")
    public String greet() {
        return this.exec.execute("osman");
    }

}
