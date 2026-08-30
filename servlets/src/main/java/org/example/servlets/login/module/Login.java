package org.example.servlets.login.module;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String uname=req.getParameter("uname");
        String pass=req.getParameter("pass");
        if("parul".equals(uname) && "123".equals(pass)){
            HttpSession session=req.getSession();
            session.setAttribute("username",uname);
            res.sendRedirect("loginModule/welcome.jsp");
        }
        else{
            res.sendRedirect("loginModule/login.jsp");
        }
        
    }

}
