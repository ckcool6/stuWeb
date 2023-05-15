package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/reqDemo2")
public class reqDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String connection = req.getHeader("connection");
        System.out.println(connection);
        System.out.println("---------------------------------------");
        Enumeration<String> values = req.getHeaders("accept-encoding");
        while (values.hasMoreElements()) {
            String value = values.nextElement();
            System.out.println(value);
        }
        System.out.println("------------------------------------------");
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + "," + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
