package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        value="/home",
        initParams = {
                @WebInitParam(name="name", value="Parul")
        }
)
public class ConflictConfig extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        PrintWriter out=res.getWriter();

        ServletConfig cfg=getServletConfig();
        String str2=cfg.getInitParameter("name");
        out.println("Hi, I am "+str2);
        
        ServletContext ctx=getServletContext();
        String str1=ctx.getInitParameter("Phone");
        out.println("I use "+str1);

        String str3=ctx.getInitParameter("name");
        out.println("I am learning from "+str3);


    }
}
