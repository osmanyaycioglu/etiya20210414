package com.training.micro.dep.injection.v2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")
public class ExecuteImpl3 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Ola " + execStrParam;
    }

}
