package com.training.micro.dep.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    @Bean
    @Qualifier("xyz")
    public MyObject myObjectNew() {
        MyObject o = new MyObject();
        o.setName("ayşe");
        return o;
    }

    @Bean
    @Qualifier("abc")
    public MyObject myObjectOther() {
        MyObject o = new MyObject();
        o.setName("mehmet");
        return o;
    }

}
