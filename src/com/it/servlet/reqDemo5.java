package com.it.servlet;

import com.it.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet("/reqDemo5")
public class reqDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        Student stu = new Student();
        for (String name : map.keySet()) {
            String[] value = map.get(name);
            //
            try {
                PropertyDescriptor pd = new PropertyDescriptor(name, stu.getClass());
                Method writeMethod = pd.getWriteMethod();
                if (value.length > 1) {
                    writeMethod.invoke(stu, (Object) value);
                } else {
                    writeMethod.invoke(stu,value);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(stu);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
