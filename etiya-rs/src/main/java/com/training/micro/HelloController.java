package com.training.micro;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_listeleme') and hasAuthority('ROLE_admin') ")
    public String hello(final Principal principal,
                        @AuthenticationPrincipal final Jwt jwt) {
        System.out.println(principal);
        System.out.println(jwt);
        return "hello";
    }

}
