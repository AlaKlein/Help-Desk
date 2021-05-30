<%-- 
    Document   : Reports
    Created on : 30 de mai. de 2021, 14:23:26
    Author     : Klein
--%>

<%@page import="DAO.TicketSupportDAO"%>
<%@page import="Entity.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%@include file="Menu.jsp" %>
    <head>
        <link href="CSS\reports.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="JavaScript" src="Js/Validate.js"></script>
        <title>Report Page</title>
        <!--Equipment Report-->
    <form name='EquipByVendor' method="post" action="/HelpDesk/Action?param=ReportEquipment" onSubmit="return validateDataReportEquipByVendor();">
        <label for="vendor">List Equipments By Vendor</label>
        <input class="formInput" type="text" name="vendor" placeholder="Vendor">
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-copy"></a></button>
    </form>

    <br>

    <!--Ticket Report by atendant-->
    <form name='TicketByAtendant' method="post" action="/HelpDesk/Action?param=TicketReport" onSubmit="return validateDataReportTicketByAtendant();">
        <label for="atendant">List Ticket By Atendant</label>
        <input class="formInput" type="text" name="atendant" placeholder="Atendant">
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-copy"></a></button>
    </form>
    <br>
    <!--Ticket Item by Ticket-->
    <form name='ItemByTicket' method="post" action="/HelpDesk/Action?param=TicketItemreport" onSubmit="return validateDataReportItemByTicket();">
        <label for="atendant">List Ticket Items by Ticket</label>
        <!--<input type="text" name="atendant" placeholder="Date">-->
        <select name="ticket" id="ticket">
            <option value="Choose">Choose</option>
            <%
                ArrayList<Ticket> tickets = new TicketSupportDAO().consultarTodos();

                for (int i = 0; i < tickets.size(); i++) {
            %>           
            <option value="<%= tickets.get(i).getId()%>"><%= tickets.get(i).getDescription()%></option>
            <%
                }
            %>
        </select>
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-copy"></a></button>
    </form>
    <br>
    <!--Ticket List-->
    <form method="post" action="/HelpDesk/Action?param=ListUsers">
        <label for="user">List Users</label>
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-copy"></a></button>
    </form>
    <br>
    <form method="post" action="/HelpDesk/Action?param=ListTickets">
        <label for="user">List Tickets</label>
        <button type="submit" ><a class="glyphicon glyphicon glyphicon-copy"></a></button>
    </form>
</head>

</body>
</html>
