<%-- 
    Document   : ListUser
    Created on : 29 de mar. de 2021, 19:41:32
    Author     : Klein
--%>

<%@page import="Entidade.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
        <title>User</title>
    </head>
    <body>
        <h1>User Listing</h1>
        <%    
            ArrayList<User> users = new UserDAO().consultarTodos();
        %>
        <div class="table-responsive">
            <table class="table table-striped table-sm" border='1'>
                <th>Id</th>
                <th>Email</th>
                <th>Name</th>
                <th>Status</th>
                    <%            
                        for (int i = 0; i < users.size(); i++) {
                            User u = users.get(i);
                    %>
                <tr>
                   <td><a href='/TicketSystem/Action?param=edUser&id=<%= u.getId()%>'><%= u.getId()%></a></td>
                    <td><%= u.getId()%></td>
                    <td><%= u.getEmail()%></td>
                    <td><%= u.getName()%></td>
                    <td><%= u.getStatus()%></td>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
        <br>
        <br>
        <a href='index.jsp'>Voltar</a>
    </body>
</html>
