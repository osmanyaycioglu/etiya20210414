package com.training.micro.security.spring.filter;

import java.time.ZonedDateTime;

public class JWTResponse {

    private String        username;
    private ZonedDateTime validUntil;
    private long          validityPeriod;
    private String        token;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public ZonedDateTime getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(final ZonedDateTime validUntilParam) {
        this.validUntil = validUntilParam;
    }

    public long getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(final long validityPeriodParam) {
        this.validityPeriod = validityPeriodParam;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String tokenParam) {
        this.token = tokenParam;
    }


}
