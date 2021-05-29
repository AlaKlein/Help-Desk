<%-- 
    Document   : ListEquipment
    Created on : 29 de mar. de 2021, 19:41:32
    Author     : Klein
--%>

<%@page import="Entity.LoggedUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TicketUserDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
        <title>Equipment</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <link href="CSS\equipment.css" rel="stylesheet">
    <body>
        <h2>Ticket Listing</h2>
        
        <br>
        <%
            String criteria = request.getParameter("title");
            String finished = request.getParameter("checkboxcriteria");
            if (criteria == null) {
                criteria = "";
            }
            if (finished.equals("false")) {
                finished = "";
            }else if (finished.equals("true")) {
                finished = "finished";
            }
            System.out.println("aquiiiii " + criteria);
            System.out.println("inativos " + finished);
            ArrayList<Ticket> tickets = new TicketUserDAO().consultarr(criteria, finished);
        %>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Priority</th>
                <th>User</th>
                <th>Equipment</th>
                <th>Telephone</th>
                <th>Date</th>
                <th>Status</th>
                <th>Atendant</th>
                <th>Edit</th>
                <th>Delete</th>
                    <%
                        for (int i = 0; i < tickets.size(); i++) {
                            Ticket tk = tickets.get(i);
                    %>
                <tr>
                    <!--<td><a href='/HelpDesk/Action?param=edEquipment&id=<%= tk.getId()%>'><%= tk.getId()%></a></td>-->
                    <td><%= tk.getId()%></td>
                    <td><%= tk.getTitle()%></td>
                    <td><%= tk.getDescription()%></td>
                    <td><%= tk.getPriority()%></td>
                    <td><%= tk.getUser_name()%></td>
                    <td><%= tk.getEquipment_id()%></td>
                    <td><%= tk.getTelephone()%></td>
                    <td><%= tk.getDate()%></td>
                    <td><%= tk.getStatus()%></td>
                    <td><%= tk.getAtendant()%></td>
                    <td><a href='/HelpDesk/Action?param=edTicketUser&id=<%= tk.getId()%>'><span class="glyphicon glyphicon glyphicon-edit"></a></td>
                    <td><a href="/HelpDesk/Action?param=exTicketUser&id=<%= tk.getId()%>"><span class="glyphicon glyphicon glyphicon-trash"></span></a>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
        <a href='Menu.jsp'>Back</a>
    </body>
</html>
