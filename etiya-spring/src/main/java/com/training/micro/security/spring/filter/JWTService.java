package com.training.micro.security.spring.filter;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final Key key;


    public JWTService() {
        this.key = Keys.hmacShaKeyFor("1238947238r23890py72340978y23r790y237803208237yer8237ry2387ry2387ry23r32r2302389798321238947238r23890py72340978y23r790y237803208237yer8237ry2387ry2387ry23r32r230238979832".getBytes());

    }

    public JWTResponse generateJWTToken(final User user) {
        String token = Jwts.builder()
                           .setId(UUID.randomUUID()
                                      .toString())
                           .setIssuedAt(new Date())
                           .setIssuer("xyz")
                           .setSubject(user.getUsername())
                           .signWith(this.key)
                           .compact();
        JWTResponse jwtResponseLoc = new JWTResponse();
        jwtResponseLoc.setToken(token);
        jwtResponseLoc.setUsername(user.getUsername());
        jwtResponseLoc.setValidityPeriod(300);
        jwtResponseLoc.setValidUntil(ZonedDateTime.now()
                                                  .plusSeconds(300));
        return jwtResponseLoc;
    }

}
