package com.training.micro;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class WebSecCon extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        JwtAuthenticationConverter converterLoc = new JwtAuthenticationConverter();
        converterLoc.setJwtGrantedAuthoritiesConverter(new MyConverter());

        httpParam.authorizeRequests()
                 .antMatchers("/hello")
                 .hasAuthority("SCOPE_listeleme")
                 .anyRequest()
                 .authenticated()
                 .and()
                 .formLogin()
                 .disable()
                 .httpBasic()
                 .disable()
                 .oauth2ResourceServer()
                 .jwt()
                 .jwtAuthenticationConverter(converterLoc);
    }

}
