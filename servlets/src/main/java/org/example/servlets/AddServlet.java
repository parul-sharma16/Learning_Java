package org.example.servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//-------PRIMARY SERVLET---------
//-------SIMPLE SERVLET--------

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i + j;
        System.out.println("Addition result is: " + k); //only prints to the console, not to the browser

        PrintWriter out = res.getWriter();
        out.println("Addition result is: " + k); //prints to the browser

        /*
        doGet() only works for GET requests, if you want to handle POST requests, doPost() method is required.
        The service() method can be used to handle both GET and POST requests, but it is not recommended as it
        can lead to confusion and security issues.
         */
    }
}