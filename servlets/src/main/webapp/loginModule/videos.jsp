<%--
  Created by IntelliJ IDEA.
  User: PARUL SHARMA
  Date: 30-08-2026
  Time: 21:57
  SECURE PAGE SO NOT DISPLAYED WITHOUT LOGIN
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videos</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    //used to prevent users from accessing secure pages after logging out, via the back button.

    response.setHeader("Expires","0"); //Proxies

    if(session.getAttribute("username") == null){
        response.sendRedirect("loginModule/login.jsp");
    }
%>
Videos.
<br>
<form action="../Logout">
    <input type="submit" value="logout">
</form>

</body>
</html>
