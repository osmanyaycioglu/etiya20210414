package com.training.micro.dep.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {


    @Bean
    @Qualifier("qwe")
    public MyObject myObjectNew2() {
        MyObject o = new MyObject();
        o.setName("gg");
        return o;
    }

    @Bean
    @Qualifier("asd")
    public MyObject myObjectOther2() {
        MyObject o = new MyObject();
        o.setName("ee");
        return o;
    }

}
