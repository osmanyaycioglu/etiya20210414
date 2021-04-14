package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.micro.dep.injection.MyObject;

@SpringBootApplication
@EnableScheduling
public class EtiyaSpringApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("asd")
    private MyObject myObject;


    public static void main(final String[] args) {
        SpringApplication.run(EtiyaSpringApplication.class,
                              args);
    }


    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.myObject.setName("osman");
    }

}
