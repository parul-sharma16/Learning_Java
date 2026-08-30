package org.example.servlets;

import com.sun.net.httpserver.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/jstl")
public class JSTLServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{

        /* basic usage:
        String name="Parul";

        req.setAttribute("label", name);
        RequestDispatcher rd=req.getRequestDispatcher("jstldemo.jsp");
        try {
            rd.forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        */
        
        /* to send an individual student--->
        Student s=new Student(1,"Parul");
        req.setAttribute("student",s);
         */

        List<Student> studs = Arrays.asList(new Student(1, "A"), new Student(2, "B"), new Student(3, "C"));

        req.setAttribute("student",studs);
        RequestDispatcher rd=req.getRequestDispatcher("jstldemo.jsp");
        try {
            rd.forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
