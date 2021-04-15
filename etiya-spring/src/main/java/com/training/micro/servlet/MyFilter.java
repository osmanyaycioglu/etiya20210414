package com.training.micro.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@WebFilter("/servlet/*")
@Order(1)
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        Authentication authenticationLoc = SecurityContextHolder.getContext()
                                                                .getAuthentication();
        //        responseParam.getWriter()
        //                     .write("Error oluştu");
        chainParam.doFilter(requestParam,
                            responseParam);
    }

}
