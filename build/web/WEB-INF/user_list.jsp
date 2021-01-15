<%-- 
    Document   : user_list
    Created on : Jan 15, 2021, 3:42:05 PM
    Author     : Msi
--%>

<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
</style>
    </head>
    <body>
        <h1>Users List! <a href="user-add">add</a></h1>
        <table style="width:100%">
            <caption>users list</caption>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>firstname</th> 
                <th>lastname</th>
                <th></th>
                <th></th>
            </tr>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
            %>
            <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td><a href="user-edit?id=${user.getId()}">edit</a></td>
                <td><a href="user-delete?id=${user.getId()}">delete</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
