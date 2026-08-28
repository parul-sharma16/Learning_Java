<%--Directive--%>
<%@ page import="java.util.Scanner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" errorPage="error.jsp" %>
<html>
<head>
    <title>JSP - Sections</title>
</head>
<body>
<%--
Directive
Declaration
Scriplet
Expression
--%>

<%--Declaration--%>
<%!
    String name="Parul";
//    Scanner sc=new Scanner(System.in);
//    int num=sc.nextInt();
%>

<h1>Hello World!</h1>

<%--Expression--%>
<h3>My Name is <%=name%></h3>

<%--Scriplet--%>
<%
    out.println("I am "+(11+10)+" years old");
    
    /* Exception Handling using error page (can also use try-catch but this is the convention.)
    out.println(21/0);
     */
%>
</body>
</html>