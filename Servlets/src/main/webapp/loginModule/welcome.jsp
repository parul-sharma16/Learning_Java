<%--
  Created by IntelliJ IDEA.
  User: PARUL SHARMA
  Date: 30-08-2026
  Time: 21:57
  SECURE PAGE SO NOT DISPLAYED WITHOUT 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    response.setHeader("Expires", "0"); //Proxies
    //Expires is an HTTP header that tells a browser/proxy when a cached response should be
    //considered expired.

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
    /* with the help of this session, even if you open welcome.jsp page on another browser,
    without logging in, then you will be redirected to login page. Without this session,
    you will be able to open welcome.jsp on another browser without loggin in.
    */
%>
Welcome, ${username}!
<br>

<a href="videos.jsp">Check out our videos.</a>
<br>

<form action="../Logout">
    <input type="submit" value="logout">
</form>

</body>
</html>
