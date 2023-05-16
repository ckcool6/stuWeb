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
import java.io.PrintWriter;

@WebServlet("/respDemo3")
public class respDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        String realPath = getServletContext().getRealPath("/img/a.jpg");
        System.out.println(realPath);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));
        ServletOutputStream os = resp.getOutputStream();

        byte[] arr = new byte[1024];
        int len;
        while ((len = bis.read()) != -1) {
            os.write(arr,0,len);
        }
        bis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
