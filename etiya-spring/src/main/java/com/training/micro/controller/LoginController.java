package com.training.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.security.spring.filter.JWTResponse;
import com.training.micro.security.spring.filter.JWTService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JWTService            js;

    @GetMapping
    public JWTResponse login(@RequestParam("u") final String username,
                             @RequestParam("p") final String password) {
        Authentication authenticateLoc = this.auth.authenticate(new UsernamePasswordAuthenticationToken(username,
                                                                                                        password));
        User user = (User) authenticateLoc.getPrincipal();
        return this.js.generateJWTToken(user);
    }

}
