package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

//---------PRIMARY SERVLET-----------
//---------REQUEST DISPATCHER--------

@WebServlet("/sub")
public class SubServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));

        int k=i-j;
        System.out.println("Subtraction result: "+k);

        req.setAttribute("ans",k);

        RequestDispatcher rd=req.getRequestDispatcher("sq");
        try {
            rd.forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}