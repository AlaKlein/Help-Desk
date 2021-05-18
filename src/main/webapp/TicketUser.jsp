<%-- 
    Document   : Ticket
    Created on : 16 de mai. de 2021, 17:53:38
    Author     : Klein
--%>

<%@page import="Entity.LoggedUser"%>
<%@page import="java.util.Date"%>
<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="CSS\ticketUser.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>

        <%
            Ticket t = (Ticket) request.getAttribute("objTicket");

            if (t == null) {
                t = new Ticket();

                t.setId(0);
                t.setDescription("");
                t.setTelephone("");
                t.setUser_id(0);
                t.setDate("");
                t.setStatus("");
                t.setTitle("");
                t.setPriority("");
                t.setAtendant("");
            }
        %>

        <h2>New Ticket</h2>

        <form name='Ticketform' method='post' action='/HelpDesk/Action?param=saveTicketUser' onSubmit="return validateDataTicket();">
            <input type="hidden" name="id" value="<%= t.getId()%>">
            <input type="hidden" name="date" value="<%= t.getDate()%>">
            <input type="hidden" name="user_id" value="<%= t.getUser_id()%>">
            <input type="hidden" name="atendant" value="<%= t.getAtendant()%>">
            <input type="hidden" name="status" value="<%= t.getStatus()%>">
            <div>
                <label for="Title">Title</label>
                <input class="formInput" type='text' name='title' value='<%= t.getTitle()%>'>
            </div>
            <br>
            <div>
                <label for="Telephone">Telephone</label>
                <input class="formInput" type='text' name='telephone' value='<%= t.getTelephone()%>'>
            </div>
            <br>
            <div>
                <label for="Equipment">Equipment</label>
                <input class="formInput" type='text' name='equipment_id' value='<%= t.getEquipment_id()%>'>
            </div>
            <br>
            <div>
                <label for="Priority">Priority</label>
                <select name="priority" id="priority">
                    <option value="Choose">Choose</option>
                    <option value="Low">Low</option>
                    <option value="Medium">Medium</option>
                    <option value="High">High</option>
                    <option value="Urgent">Urgent</option>

                    <%
                        if (t.getPriority().equals("Low")) {
                    %>
                    <script>
                        function select() {
                            document.getElementById("priority").selectedIndex
                                    = "1";
                        }
                        select();
                    </script>
                    <%} else if (t.getPriority().equals("Medium")) {
                    %>
                    <script>
                        function select2() {
                            document.getElementById("priority").selectedIndex
                                    = "2";
                        }
                        select2();
                    </script>
                    <%} else if (t.getPriority().equals("High")) {
                    %>
                    <script>
                        function select3() {
                            document.getElementById("priority").selectedIndex
                                    = "3";
                        }
                        select3();
                    </script>
                    <%} else if (t.getPriority().equals("Urgent")) {
                    %>
                    <script>
                        function select4() {
                            document.getElementById("priority").selectedIndex
                                    = "4";
                        }
                        select4();
                    </script>
                    <%}
                    %>
                </select>
            </div>
            <br>
            <div>
                <label for="Description">Description</label>
                <!--<input class="description" type='text' name='description' value='<%= t.getDescription()%>'>-->
                <textarea class="formInput" name="description" rows="4" cols="50"><%= t.getDescription()%></textarea>
            </div>
            <br>
            <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved"></a></button>
        </form>
        <%@include file="ListTicketUser.jsp" %>
    </body>
</html>
