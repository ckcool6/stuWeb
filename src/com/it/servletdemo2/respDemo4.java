package com.it.servletdemo2;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/respDemo4")
public class respDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        String news = "这是个新闻";

        //设置缓存一小时
        resp.setDateHeader("Expires", System.currentTimeMillis() + 1 * 60 * 60 * 1000);

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(news);

        System.out.println("aaa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
