<%-- 
    Document   : User
    Created on : 8 de abr. de 2021, 14:23:20
    Author     : Klein
--%>
<%@page import="Entity.LoggedUser"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<%@page import="Entity.Equipment"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipment CRUD</title>

        <script language="JavaScript" src="js/Validate.js"></script>
    </head>
    <link href="CSS\equipment.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>
        <div class="page">
            <%
                Equipment eq = (Equipment) request.getAttribute("objEquipment");

                if (eq == null) {
                    eq = new Equipment();

                eq.setId(0);
                eq.setName("");
                eq.setModel("");
                eq.setType("");
                eq.setVendor("");
                eq.setSerialNumber("");
                eq.setStatus("");
                eq.setUser_id(0);
                }
            %>
            <h2>Add Equipment</h2>

            <form name='Equipmentform' method='post' action='/HelpDesk/Action?param=saveEquipment' onSubmit="return validateData();">
                <input type="hidden" name="id" value="<%= eq.getId()%>">
                <div>
                    <label for="Name">Name</label>
                    <input type='text' name='name' required value='<%= eq.getName()%>'>
                </div>
                <br>
                <div>
                    <label for="Model">Model</label>
                    <input type='text' name='model' required value='<%= eq.getModel()%>'>
                </div>
                <br>
                <div>
                    <label for="Type">Type</label>
                    <input type='text' name='type' required value='<%= eq.getType()%>'>
                </div>
                <br>
                <div>
                    <label for="Vendor">Vendor</label>
                    <input type='text' name='vendor' required value='<%= eq.getVendor()%>'>
                </div>
                <br>
                <div>
                    <label for="SerialNumber">Serial Number</label>
                    <input type='text' name='serialNumber' required value='<%= eq.getSerialNumber()%>'>
                </div>
                <br>
                <div>
                    <label for="Status">Status</label>
                    <!--<input type='text' name='status' required value='<%= eq.getStatus()%>'>-->

                    <select name="status" id="status">
                        <option value="Choose">Choose</option>
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>

                        <%
                            System.out.println("dasuhduas " + eq.getStatus());
                            if (eq.getStatus().equals("Active")) {
                        %>
                        <option selected="selected">Active</option>
                        <%} else if (eq.getStatus().equals("Inactive")) {
                        %>
                        <option selected="selected">Inactive</option>
                        <%}
                        %>
                    </select>

                    <input type="hidden" name="user_id" value="<%= LoggedUser.getId()%>">
                    </form
                </div>
                <br>
                <br>
                <input type='submit' value='Save'>
            </form>


            <%@include file="ListEquipment.jsp" %>
        </div>
    </body>
</html>
