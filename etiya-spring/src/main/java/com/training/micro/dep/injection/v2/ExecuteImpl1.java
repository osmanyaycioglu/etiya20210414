package com.training.micro.dep.injection.v2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("en")
public class ExecuteImpl1 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Hello " + execStrParam;
    }

}
