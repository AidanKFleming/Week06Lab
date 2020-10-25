<%-- 
    Document   : register
    Created on : Oct 22, 2020, 10:02:20 AM
    Author     : 819466
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username:
            <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register">            
            <input type="submit" value="Register Name">
        </form>
        <p style="background-color:lightblue; display: inline-flex;">${loginAlert}</p>
        <p style="background-color:tomato; display: inline-flex;">${nameAlert}</p><br>
    </body>
</html>
