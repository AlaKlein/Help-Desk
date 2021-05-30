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
        <%
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String vendor = request.getParameter("vendor");
            String serial = request.getParameter("serial");
            String ip = request.getParameter("ip");
            String inactive = request.getParameter("checkboxcriteria");
            if (id == null) {
                id = "";
            }
            if (name == null) {
                name = "";
            }
            if (vendor == null) {
                vendor = "";
            }
            if (serial == null) {
                serial = "";
            }
            if (ip == null) {
                ip = "";
            }
            if (inactive == null) {
                inactive = "";
            }

            if (inactive.equals("false")) {
                inactive = "inactive";
            } else if (inactive.equals("true")) {
                inactive = "asddasdsa";
            }
            ArrayList<Equipment> equipments = new EquipmentDAO().consultarr(id, name, vendor, serial, ip, inactive);
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
                <th>IP Address</th>
                <!--<th>User ID</th>-->
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
                    <td><%= equip.getIp()%></td>
                    <!--<td><%= equip.getUser_id()%></td>-->
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
