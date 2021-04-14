package com.training.micro.dep.injection.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ExecConfig {

    @Autowired
    private Environment         env;

    @Value("${exec.type}")
    private String              exectype;

    @Autowired
    private ExecutePropertyConf epc;

    @Value("#{@executePropertyConf.getType()}")
    private String              exectype2;


    @Bean
    @Qualifier("dynamic")
    public IExecute executeImplCreate() {
        switch (this.epc.getType()) {
            case "tr":
                return new ExecuteImpl2();
            case "en":
                return new ExecuteImpl1();
            case "es":
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

    @Bean
    @Qualifier("dynamicOld2")
    public IExecute executeImplCreateOld2() {
        switch (this.exectype) {
            case "tr":
                return new ExecuteImpl2();
            case "en":
                return new ExecuteImpl1();
            case "es":
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

    @Bean
    @Qualifier("dynamicOld")
    public IExecute executeImplCreateOld() {
        String propertyLoc = this.env.getProperty("exec.type");
        switch (propertyLoc) {
            case "tr":
                return new ExecuteImpl2();
            case "en":
                return new ExecuteImpl1();
            case "es":
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

}
