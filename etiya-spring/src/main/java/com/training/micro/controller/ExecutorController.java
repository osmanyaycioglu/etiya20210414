package com.training.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.aop.SecureMe;
import com.training.micro.dep.injection.v2.IExecute;

@RestController
@RequestMapping("/exec")
public class ExecutorController {

    @Autowired
    @Qualifier("dynamic")
    private IExecute exec;

    @GetMapping("/greet")
    @PreAuthorize("@mySecurityChecker.checkMe(authentication,#userId)")
    public String greet(@RequestParam("id") final Long userId) {
        return this.exec.execute("osman");
    }

    @GetMapping("/test")
    @SecureMe("ROLE_ADMIN")
    public String test() {
        return "OK";
    }

}
