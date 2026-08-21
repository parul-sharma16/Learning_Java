package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.*;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        /* FOR REQUEST DISPATCHER
        int k=(int) req.getAttribute("ans");
        */

        //FOR REQUEST REDIRECT
        HttpSession session=req.getSession();
        int k=(int) session.getAttribute("divAns");

        k*=k;
        PrintWriter out = res.getWriter();
        out.println("Square result: "+k);
    }
}
