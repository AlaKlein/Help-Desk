<%-- 
    Document   : ListEquipment
    Created on : 29 de mar. de 2021, 19:41:32
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<%@page import="Entity.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TicketSupportDAO"%>
<!DOCTYPE html>
<html>
     <head>
        <title>Equipment</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <link href="CSS\equipment.css" rel="stylesheet">
    <body>
        <h2>Ticket Listing</h2>
        <br>
        <%
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String user = request.getParameter("user");
            String atendant = request.getParameter("atendant");
            String finished = request.getParameter("checkboxcriteria");
            String initialdate = request.getParameter("initialdate");
            String finaldate = request.getParameter("finaldate");
            String initialdate2 = initialdate + " 00:00:00";
            String finaldate2 = finaldate + " 23:59:59";
            
            if (title == null) {
                title = "";
            }
            if (description == null) {
                description = "";
            }
            if (user == null) {
                user = "";
            }
            if (atendant == null) {
                atendant = "";
            }
            if (finished == null) {
                finished = "";
            }
             if (initialdate == "") {
                initialdate2 = "";
            }
              if (finaldate == "") {
                finaldate2 = "";
            }
            
            if (finished.equals("false")) {
                finished = "finished";
            }else if (finished.equals("true")) {
                finished = "";
            }
            
            System.out.println("InitialDate " + initialdate2);
            System.out.println("FinalDate " + finaldate2);
            
            ArrayList<Ticket> tickets = new TicketSupportDAO().consultarr(title, description, user, atendant, finished, initialdate2, finaldate2);
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
                    <!--<td><a href='/HelpDesk/Action?param=edTicket&id<%= tk.getId()%>'><span class="glyphicon glyphicon glyphicon-edit"></a></td>-->
                    <td><a href='/HelpDesk/Action?param=edTicketSupport&id=<%= tk.getId()%>&desc=<%= tk.getDescription()%>'><span class="glyphicon glyphicon glyphicon-edit"></a></td>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
        <a href='Menu.jsp'>Back</a>
    </body>
</html>
