<%-- 
    Document   : user_message
    Created on : Jan 15, 2021, 9:33:50 PM
    Author     : Msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getAttribute("form_message") %></h1>
    </body>
</html>
