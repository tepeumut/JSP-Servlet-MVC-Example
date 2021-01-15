<%-- 
    Document   : login
    Created on : Jan 15, 2021, 10:29:27 AM
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
        <h1>Login</h1>

        <%
        if (request.getAttribute("form_message") != null) {
            out.print(request.getAttribute("form_message"));
        }
        %>
        <form action="login" method="post">
            <input type="text" name="username"/><br/>
            <input type="password" name="password"/><br/>
            <input type="submit">
        </form>
    </body>
</html>
