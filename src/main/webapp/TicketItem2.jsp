<%-- 
    Document   : TicketItem
    Created on : 22 de mai. de 2021, 15:39:27
    Author     : Klein
--%>

<%@page import="DAO.TicketItemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.TicketItem"%>
<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TicketItem</title>
    </head>
    <link href="CSS\ticketItem2.css" rel="stylesheet">
    <script language="JavaScript" src="Js/Validate.js"></script>
    <%@include file="Menu.jsp" %>
    <body>

        <%
            TicketItem t = (TicketItem) request.getAttribute("objTicketItem");

            if (t == null) {
                t = new TicketItem();

                t.setId(0);
                t.setDescription_item("");
                t.setDate("");
                t.setAtendant("");
                t.setTicket_id(Integer.parseInt(request.getAttribute("ticketId").toString()));
            }
        %>


        <label for="Description">Description</label>

        <div>
            <form name='TicketItemform' method='post' action='/HelpDesk/Action?param=saveTicketItem' onSubmit="return validateDataTicketItem();">
                <input type="hidden" name="id" value="<%= t.getId()%>">
                <input type="hidden" name="ticket_id" value="<%= t.getTicket_id()%>">
                <textarea class="formInput" name="descriptionItem" rows="4" cols="50""><%= t.getDescription_item()%></textarea>

                <br>
                <a href='TicketSupport.jsp'>Back</a>
                <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved"></a></button>
        </div>
    </form>
</body>
</html>
