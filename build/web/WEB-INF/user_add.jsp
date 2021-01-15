<%-- 
    Document   : user-add
    Created on : Jan 15, 2021, 8:37:54 PM
    Author     : Msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Add <a href="user-list">list</a></h1>

        <%
        if (request.getAttribute("form_message") != null) {
            out.print(request.getAttribute("form_message"));
        }
        %>
        <form action="user-add" method="post">
            Username: 
            <input type="text" name="username"/><br/>
            Firstname:
            <input type="text" name="firstname"/><br/>
            Lastname:
            <input type="text" name="lastname"/><br/>
            Password:
            <input type="password" name="password"/><br/>
            <input type="submit">
        </form>
    </body>
</html>
