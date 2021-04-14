package com.training.micro.dep.injection.v2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exec")
public class ExecutePropertyConf {

    private String type;
    private int    appPort;
    private long   amount;


    public String getType() {
        return this.type;
    }


    public void setType(final String typeParam) {
        this.type = typeParam;
    }


    public int getAppPort() {
        return this.appPort;
    }


    public void setAppPort(final int appPortParam) {
        this.appPort = appPortParam;
    }


    public long getAmount() {
        return this.amount;
    }


    public void setAmount(final long amountParam) {
        this.amount = amountParam;
    }


}
