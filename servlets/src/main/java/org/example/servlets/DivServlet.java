package org.example.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

//-------PRIMARY SERVLET---------
//-------REQUEST REDIRECT---------

@WebServlet("/div")
public class DivServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));

        int k=(int)i/j;
        System.out.println("Division result: "+k);

        /*=========URL Rewriting=======
        res.sendRedirect("sq?k="+k); not the best method, since the parameter might be
        required by a servlet being called by the SqServlet and so on, by other servlets
        during the session, so should not rewrite the url.
        */

        /*========COOKIES===========
        Cookie cookie=new Cookie("divAns",k+"");
        res.addCookie(cookie);
        */

        //=======SESSION MANAGEMENT========
        HttpSession sesh= req.getSession();
        sesh.setAttribute("divAns",k);

        res.sendRedirect("sq");
    }
}