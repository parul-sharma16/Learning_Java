<%--
  Created by IntelliJ IDEA.
  User: PARUL SHARMA
  Date: 29-08-2026
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- normal jsp way
<%
     String name=request.getAttribute("label").toString();
     out.println(name);
%>
--%>

<%--writing the above block using EL (expression language):
${label}:
--%>

<%-- basic implementation:
<c:out value="Hello World, this is ${label}"/>
--%>

<%-- to print the name of one student:
${student.name}
--%>

<%-- to print a list of student: --%>
<c:forEach items="${student}" var="s">
    ${s} <br/>
</c:forEach>

</body>
</html>
