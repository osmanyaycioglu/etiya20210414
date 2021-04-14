package com.training.micro.dep.injection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("base")
//@Service
//@Repository
//@Controller
//@Configuration
//@Scope("prototype")
//@RequestScope
public class MyObject {

    private String name;

    @PostConstruct
    public void xyz() {
        System.out.println("post construct");
    }

    @PreDestroy
    public void name() {
        System.out.println("pre destroy");
    }

    public String hello() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
