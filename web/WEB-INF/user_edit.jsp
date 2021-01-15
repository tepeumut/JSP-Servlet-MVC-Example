<%-- 
    Document   : user-add
    Created on : Jan 15, 2021, 8:37:54 PM
    Author     : Msi
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Edit <a href="user-list">list</a></h1>

        <%
            User user = (User) request.getAttribute("user");
        if (request.getAttribute("form_message") != null) {
            out.print(request.getAttribute("form_message"));
        }
        %>
        <form action="user-edit?id=${user.getId()}" method="post">
            Username: 
            <input type="text" name="username" value="${user.getUsername()}"/><br/>
            Firstname:
            <input type="text" name="firstname" value="${user.getFirstName()}"/><br/>
            Lastname:
            <input type="text" name="lastname" value="${user.getLastName()}"/><br/>
           
            <input type="submit">
        </form>
    </body>
</html>
