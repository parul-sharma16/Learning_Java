package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/addAlien")
public class ValidateIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out= response.getWriter();
        HttpServletRequest req=(HttpServletRequest) request;
        int id=Integer.parseInt(req.getParameter("aId"));
        if(id>0)
            chain.doFilter(request,response);
        else
            out.println("Invalid input");
    }
    
}
