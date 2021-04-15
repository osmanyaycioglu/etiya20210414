package com.training.micro.validation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RestSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService usd;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        // authParam.inMemoryAuthentication().withUser("osman").password("1234").roles("ADMIN");
        authParam.userDetailsService(this.usd)
                 .passwordEncoder(this.passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/actuator/**",
                         "/xyz/**",
                         "/login")
            .permitAll()
            .antMatchers("/api/v1/person/query")
            .hasAnyRole("VIEWER")
            .antMatchers("/api/v1/person/management")
            .hasAnyRole("SUPER_ADMIN",
                        "ADMIN")
            .antMatchers("/ora/**")
            .hasAnyRole("USER")
            .antMatchers("/ters/**")
            .hasAnyRole("MODERATOR")
            .antMatchers("/api/v1/hello/h7/{userName}/**")
            .access("@mySecurityChecker.check(authentication,request,#userName)")
            .antMatchers("/api/v1/hello/**")
            .access("@mySecurityChecker.check(authentication,request,'ROLE_ADMIN')")
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .formLogin()
            .disable()
            .httpBasic()
            .and()
            .cors()
            .disable()
            .csrf()
            .disable();

        //        http.authorizeRequests()
        //        .antMatchers("/actuator/**")
        //        .hasAnyAuthority("ROLE_SUPER_ADMIN",
        //                         "ROLE_ADMIN")
        //        .anyRequest()
        //        .authenticated()
        //        .and()
        //        .sessionManagement()
        //        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //        .and()
        //        .formLogin()
        //        .disable()
        //        .httpBasic()
        //        .and()
        //        .cors()
        //        .disable()
        //        .csrf()
        //        .disable();

        //        http.authorizeRequests((requests) -> requests.anyRequest()
        //                                                     .authenticated());
        //        http.formLogin()
        //            .disable();
        //        http.httpBasic();
        //        http.cors()
        //            .disable();
        //        http.csrf()
        //            .disable();

        //        http.authorizeRequests()
        //            .antMatchers("/actuator/health")
        //            .permitAll()
        //            .anyRequest()
        //            .authenticated()
        //            .and()
        //            .formLogin()
        //            .disable()
        //            .httpBasic()
        //            .and()
        //            .cors()
        //            .disable()
        //            .csrf()
        //            .disable();
    }
}
