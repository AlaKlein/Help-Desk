<%-- 
    Document   : ListUser
    Created on : 29 de mar. de 2021, 19:41:32
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UserDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
        <title>User</title>
    </head>
    <link href="CSS\user.css" rel="stylesheet">
    <body>
        <h2>User Listing</h2>
        <br>
        <form method="post" action="/HelpDesk/Action?param=SearchBox">

            <input type="text" name="criteria" placeholder="Type here to search">

            <input type="submit" value="Search">

        </form>
        <br>
        <%
            String criteria = request.getParameter("criteria");
            if (criteria == null) {
                criteria = "";
            }
            System.out.println("aquiiiii " + criteria);
            ArrayList<User> users = new UserDAO().consultar(criteria);
        %>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <th>Id</th>
                <th>Email</th>
                <th>Name</th>
                <th>Status</th>

                <%
                    for (int i = 0; i < users.size(); i++) {
                        User u = users.get(i);
                %>
                <tr>
                    <td><a href='/HelpDesk/Action?param=edUser&id=<%= u.getId()%>'><%= u.getId()%></a></td>
<!--                    <td><%= u.getId()%></td>-->
                    <td><%= u.getEmail()%></td>
                    <td><%= u.getName()%></td>
                    <td><%= u.getStatus()%></td>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
        <a href='Menu.jsp'>Back</a>
    </body>
</html>
