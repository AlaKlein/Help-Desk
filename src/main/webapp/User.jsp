<%-- 
    Document   : User
    Created on : 8 de abr. de 2021, 14:23:20
    Author     : Klein
--%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<%@page import="Entity.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("objUser");

            if (user == null) {
                user = new User();

                user.setId(0);
                user.setEmail("");
                user.setName("");
                user.setPassword("");
                user.setStatus("");
            }
        %>
        <h1>Add User</h1>

        <!--<form name='Userform' method='post' action='/TicketSystem/action?param=saveUser' onSubmit="return validardados();">-->
        <form name='Userform' method='post' action='/TicketSystem/Action?param=saveUser'">
            <input type="hidden" name="id" value="<%= user.getId()%>">

            Email
            <input type='text' name='email' required value='<%= user.getEmail()%>'>

            <br>
            <br>

            Name
            <input type='text' name='name' required value='<%= user.getName()%>'>

            <br>
            <br>

            Password
            <input type='text' name='password' required value='<%= user.getPassword()%>'>

            <br>
            <br>

            Status
            <input type='text' name='status' required value='<%= user.getStatus()%>'>

            <br>
            <br>
            <input type='submit' value='Save'>

        </form>

        <%@include file="ListUser.jsp" %>
    </body>
</html>
