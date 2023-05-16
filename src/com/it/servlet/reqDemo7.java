package com.it.servlet;

import com.it.bean.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/reqDemo7")
public class reqDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* BufferedReader br = req.getReader();
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();*/
        ServletInputStream is = req.getInputStream();
        byte[] arr = new byte[1024];
        int len;
        while ((len = is.read(arr)) != -1) {
            System.out.println(new String(arr,0,len));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
