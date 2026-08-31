package org.example.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addAlien")
public class FilterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        PrintWriter out=res.getWriter();
        int id=Integer.parseInt(req.getParameter("aId"));
        String name=req.getParameter("aName");
        out.println("Welcome "+name);
    }
}
