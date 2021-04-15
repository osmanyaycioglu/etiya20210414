package com.training.micro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -6015047129410267107L;

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        respParam.getWriter()
                 .write("Servlet Response");
    }
}
