package com.training.micro.validation.security.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.validation.security.user.service.UserManager;

@RestController
@RequestMapping("/man/v1/user")
@PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
public class UserController {

    @Autowired
    private UserManager um;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public String add(@RequestBody final UserObject userObjectParam) {
        this.um.add(userObjectParam);
        return "OK";
    }

    @PostMapping("/add2")
    public String add2(@RequestBody final UserObject userObjectParam,
                       final Principal principal) {
        this.um.add(userObjectParam);
        return "OK";
    }

    @PostMapping("/add3")
    public String add3(@RequestBody final UserObject userObjectParam) {
        Authentication authenticationLoc = SecurityContextHolder.getContext()
                                                                .getAuthentication();
        System.out.println(authenticationLoc);
        this.um.add(userObjectParam);
        return "OK";
    }


}
