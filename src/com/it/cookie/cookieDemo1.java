package com.it.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookiedemo1")
public class cookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("欢迎访问，您的最后访问时间为：<br>");

        Cookie cookie = new Cookie("time", System.currentTimeMillis() + "");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        Cookie[] arr = req.getCookies();
        for (Cookie c : arr) {
            if ("time".equals(c.getName())){
                String value = c.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
                String format = sdf.format(new Date(Long.parseLong(value)));
                pw.write(format);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
