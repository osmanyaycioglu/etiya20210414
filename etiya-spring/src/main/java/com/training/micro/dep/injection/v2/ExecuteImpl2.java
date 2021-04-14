package com.training.micro.dep.injection.v2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr")
public class ExecuteImpl2 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Merhaba " + execStrParam;
    }

}
