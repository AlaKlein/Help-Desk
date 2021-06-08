<%-- 
    Document   : Ticket
    Created on : 16 de mai. de 2021, 17:53:38
    Author     : Klein
--%>

<%@page import="DAO.EquipmentDAO"%>
<%@page import="Entity.Equipment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.LoggedUser"%>
<%@page import="java.util.Date"%>
<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TicketUser</title>
    </head>
    <link href="CSS\ticketUser.css" rel="stylesheet">
    <script type="text/javascript" src="Js/AjaxFunctionUser.js"></script> 
    <script language="JavaScript" src="Js/Validate.js"></script>
    <%@include file="Menu.jsp" %>
    <body>
        <Script>
        window.onload = function(){
        document.getElementById('search').click();
    }
        </script>
        
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

        <form name='Ticketform' method='post' action='/HelpDesk/Action?param=saveTicketUser' onSubmit="return validateDataTicketUser();">
            <input type="hidden" name="id" value="<%= t.getId()%>">
            <input type="hidden" name="date" value="<%= t.getDate()%>">
            <input type="hidden" name="user_id" value="<%= t.getUser_id()%>">
            <input type="hidden" name="atendant" value="<%= t.getAtendant()%>">
            <input type="hidden" name="status" value="<%= t.getStatus()%>">
            <input type="hidden" name="equipment_id" value="<%= t.getEquipment_id()%>">
            <div>
                <label for="Title">Title</label>
                <input class="formInput" type='text' name='title' value='<%= t.getTitle()%>'>
            </div>
            <br>
            <div>
                <label for="Telephone">Telephone</label>
                <input class="formInput" type='text' name='telephone' data-mask="(00) 00000-0000" value='<%= t.getTelephone()%>'>
            </div>
            <br>
            <div>
                <label for="Equipment">Equipment</label>
                <!--<input class="formInput" type='text' name='equipment_id' value='<%= t.getEquipment_id()%>'>-->
                <select name="equipmentId" id="equipmentId">
                    <option value="Choose">Choose</option>
                    <%
                        ArrayList<Equipment> equipments = new EquipmentDAO().consultarTodos();

                        for (int i = 0; i < equipments.size(); i++) {
                    %>           
                    <option value="<%= equipments.get(i).getId()%>"><%= equipments.get(i).getName()%></option>
                    <%
                        }

                        if (t.getEquipment_id() != 0) {
                    %>
                   
                    <%
                        ArrayList<Equipment> equipments2 = new EquipmentDAO().consultarEquip(t.getEquipment_id());

                        for (int i = 0; i < equipments2.size(); i++) {
                    %>   
                    
                    <input type="hidden" name="equipment_name" id="equipment_name" value="<%= equipments2.get(i).getId()%>">
                    <%}%>
                    
                    <script type="text/javascript">
                        function selectEquipment() {
                            var a = document.getElementById("equipment_name");
                            document.getElementById("equipmentId").value = a.value;

                        }
                        selectEquipment();
                    </script>
                    <%}%>
                </select>
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
            <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved" onclick="myFunction()"></a></button>
        </form>

        <script>
            function myFunction() {
                document.getElementById("search").click();
            }
        </script>

        <br>
        <!--<form method="post" action="/HelpDesk/Action?param=SearchBoxTicketUser">-->
        <form method="post" name="formuser" action="javascript:loadPage('ListTicketUser.jsp');">

            <input type="text" name="title" placeholder="Type here to search">

            <!--<input type="submit" value="Search"><br>-->
            <button type="submit" id='search' ><a class="glyphicon glyphicon glyphicon-search"></a></button>


            <input type="checkbox" id ="checkboxcriteria" name="checkboxcriteria">List Finished

        </form>

        <div id="AjaxReturn">

        </div>

        <%--<%@include file="ListTicketUser.jsp" %>--%>
    </body>
</html>
