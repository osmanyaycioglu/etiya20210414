package com.training.micro.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.training.micro.models.Person;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("yaycioglu");
        return Health.status(Status.DOWN)
                     .withDetail("info",
                                 personLoc)
                     .build();
    }

}
