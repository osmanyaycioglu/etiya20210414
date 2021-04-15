package com.training.micro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class MyConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(final Jwt sourceParam) {
        Map<String, Object> realmAccessLoc = sourceParam.getClaim("realm_access");
        List<GrantedAuthority> listOfGA = new ArrayList<>();
        List<String> roles = (List<String>) realmAccessLoc.get("roles");
        for (String roleLoc : roles) {
            listOfGA.add(new SimpleGrantedAuthority("ROLE_" + roleLoc));
        }
        String str = sourceParam.getClaim("scope");
        String[] splitLoc = str.split(" ");
        for (String scopeLoc : splitLoc) {
            listOfGA.add(new SimpleGrantedAuthority("SCOPE_" + scopeLoc));
        }
        return listOfGA;
    }

}
