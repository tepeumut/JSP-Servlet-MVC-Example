<%-- 
    Document   : welcome
    Created on : Jan 15, 2021, 12:44:16 PM
    Author     : Msi
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login");
        return;
    }
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%=user.getFirstName()%></h1>
        <a href="user-list">user list</a> <a href="user-add">user add</a>
    </body>
</html>
