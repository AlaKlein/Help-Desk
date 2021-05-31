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
    <link href="CSS\ticketItem.css" rel="stylesheet">
    <script language="JavaScript" src="Js/Validate.js"></script>
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
                <textarea class="formInput" name="descriptionItem" rows="4" cols="50" value="<%= t.getDescription_item()%>"></textarea>
                <br>
                <a href='TicketSupport.jsp'>Back</a>
                <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved""></a></button>

        </div>
    </form>
    <div>
        <!--            <form name='TicketItemformStatus' method='get' action='/HelpDesk/Action?param=TicketItemformStatus'>
                        <input type="hidden" name="ticket_id" value="<%= t.getTicket_id()%>">
                        <label name="finish">Finish Ticket</label>
                        <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved"></a></button>-->
        <td><a href="/HelpDesk/Action?param=TicketItemformStatus&ticket_id=<%= t.getTicket_id()%>"><span class="glyphicon glyphicon glyphicon-ok"></span>  Finish Ticket</a>
    </div>
</form>
</body>
</html>
