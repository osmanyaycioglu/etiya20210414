package com.training.micro.validation.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MySecurityChecker {

    public boolean check(final Authentication authenticationParam,
                         final HttpServletRequest hsr,
                         final String param) {
        Collection<? extends GrantedAuthority> authoritiesLoc = authenticationParam.getAuthorities();
        for (GrantedAuthority grantedAuthorityLoc : authoritiesLoc) {
            if (param.equalsIgnoreCase(grantedAuthorityLoc.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMe(final Authentication authenticationParam,
                           final Long userId) {
        System.out.println("user : " + userId);
        Collection<? extends GrantedAuthority> authoritiesLoc = authenticationParam.getAuthorities();
        for (GrantedAuthority grantedAuthorityLoc : authoritiesLoc) {
            if ("ROLE_ADMIN".equalsIgnoreCase(grantedAuthorityLoc.getAuthority())) {
                return true;
            }
        }
        return false;
    }

}
