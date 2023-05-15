package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqDemo1")
public class reqDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
