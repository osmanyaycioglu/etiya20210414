package com.training.micro.aop;

import org.springframework.stereotype.Component;

@Component
public class Callee {

    public String callMe(final String str) {
        return "Called " + str;
    }

}
