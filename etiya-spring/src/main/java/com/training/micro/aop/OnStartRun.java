package com.training.micro.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OnStartRun implements CommandLineRunner {

    @Autowired
    private Caller c;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.c.callOtherBean();
    }

}
