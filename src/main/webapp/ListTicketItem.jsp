<%-- 
    Document   : ListTicketItem
    Created on : 25 de mai. de 2021, 21:40:32
    Author     : Klein
--%>

<%@page import="DAO.TicketItemDAO"%>
<%@page import="Entity.TicketItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TicketItem</title>
    </head>
    <link href="CSS\ticketItem.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>


        <br>
        <%

            int ticket_id = (Integer.parseInt(request.getAttribute("ticketId").toString()));
            ArrayList<TicketItem> tkitems = new TicketItemDAO().consultarr(ticket_id);
        %>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <th>Id</th>
                <th>Description Item</th>
                <th>Date</th>
                <th>User</th>
                <th>Ticket ID</th>
                <th>Edit</th>
                <th>Delete</th>
                    <%
                        for (int i = 0; i < tkitems.size(); i++) {
                            TicketItem tkid = tkitems.get(i);
                    %>
                <tr>
                    <td><%= tkid.getId()%></td>
                    <td><%= tkid.getDescription_item()%></td>
                    <td><%= tkid.getDate()%></td>
                    <td><%= tkid.getAtendant()%></td>
                    <td><%= tkid.getTicket_id()%></td>
                    <td><a href='/HelpDesk/Action?param=edTicketItem&id=<%= tkid.getId()%>&tkid=<%= tkid.getTicket_id()%>'><span class="glyphicon glyphicon glyphicon-edit"></a></td>
                    <td><a href="/HelpDesk/Action?param=exTicketItem&id=<%= tkid.getId()%>&tkid=<%= tkid.getTicket_id()%>"><span class="glyphicon glyphicon glyphicon-trash"></span></a>
                </tr>
                <%
                    }
                %>

            </table>
    </body>
    <%@include file="TicketItem.jsp"%>
</html>
