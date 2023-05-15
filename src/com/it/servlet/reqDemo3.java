package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/reqDemo3")
public class reqDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println("------------------------");
        String password = req.getParameter("password");
        System.out.println(password);
        System.out.println("-------------------------");

        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("----------------------------");

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            System.out.println(element);
        }
        System.out.println("------------------------------");

        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            System.out.print(key + ":");
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
