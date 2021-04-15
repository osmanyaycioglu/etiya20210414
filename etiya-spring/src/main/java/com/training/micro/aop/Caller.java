package com.training.micro.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {

    @Autowired
    private Callee callee;

    public void callOtherBean() {
        String callMeLoc = this.callee.callMe("osman");
        System.out.println(callMeLoc);
    }

}
