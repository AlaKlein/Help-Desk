<%-- 
    Document   : ListEquipment
    Created on : 29 de mar. de 2021, 19:41:32
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Equipment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.EquipmentDAO"%>
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
        <h2>Equipment Listing</h2>
        <br>
        <form method="post" action="/HelpDesk/Action?param=SearchBoxEquipment">

            <input type="text" name="criteria" placeholder="Type here to search">

            <!--<input type="submit" value="Search"><br>-->
            <button type="submit" ><a class="glyphicon glyphicon glyphicon-search"></a></button>

            <input type="checkbox" name="checkboxcriteria" value="inactives">List Inactives
        </form>
        <br>
        <%
            String criteria = request.getParameter("criteria");
            String inactive = request.getParameter("checkboxcriteria");
            if (criteria == null) {
                criteria = "";
            }
            if (inactive == null) {
                inactive = "";
            }
            System.out.println("aquiiiii " + criteria);
            System.out.println("inativos " + inactive);
            ArrayList<Equipment> equipments = new EquipmentDAO().consultarr(criteria, inactive);
        %>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <th>Id</th>
                <th>Name</th>
                <th>Model</th>
                <th>Type</th>
                <th>Vendor</th>
                <th>Serial Number</th>
                <th>Status</th>
                <th>User ID</th>
                <th>Edit</th>
                <th>Delete</th>
                    <%
                        for (int i = 0; i < equipments.size(); i++) {
                            Equipment equip = equipments.get(i);
                    %>
                <tr>
                    <!--<td><a href='/HelpDesk/Action?param=edEquipment&id=<%= equip.getId()%>'><%= equip.getId()%></a></td>-->
                    <td><%= equip.getId()%></td>
                    <td><%= equip.getName()%></td>
                    <td><%= equip.getModel()%></td>
                    <td><%= equip.getType()%></td>
                    <td><%= equip.getVendor()%></td>
                    <td><%= equip.getSerialNumber()%></td>
                    <td><%= equip.getStatus()%></td>
                    <td><%= equip.getUser_id()%></td>
                    <td><a href='/HelpDesk/Action?param=edEquipment&id=<%= equip.getId()%>'><span class="glyphicon glyphicon glyphicon-edit"></a></td>
                    <td><a href="/HelpDesk/Action?param=exEquipment&id=<%= equip.getId()%>"><span class="glyphicon glyphicon glyphicon-trash"></span></a>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
        <a href='Menu.jsp'>Back</a>
    </body>
</html>
