<%-- 
    Document   : TicketItem
    Created on : 22 de mai. de 2021, 15:39:27
    Author     : Klein
--%>

<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="CSS\ticketItem.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>

        <%
            Ticket t = (Ticket) request.getAttribute("objTicketDesc");

            if (t == null) {
                t = new Ticket();

                t.setId(0);
                t.setDescription("");
            }
        %>

        <div>
            <label for="Description">Description</label>
            <textarea class="formInput" name="description" rows="4" cols="50"><%= t.getDescription()%></textarea>
        </div>
        <br>
        <a href='Menu.jsp'>Back</a>
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved"></a></button>
    </body>
</html>
