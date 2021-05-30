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
        <script language="JavaScript" src="Js/Validate.js"></script>
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

            <form name='Equipmentform' method='post' action='/HelpDesk/Action?param=saveEquipment' onSubmit="return validateDataEquipment();">
                <input type="hidden" name="id" value="<%= eq.getId()%>">
                <div>
                    <label for="Name">Name</label>
                    <input class="formInput" type='text' name='name' value='<%= eq.getName()%>'>
                </div>
                <br>
                <div>
                    <label for="Model">Model</label>
                    <input class="formInput" type='text' name='model' value='<%= eq.getModel()%>'>
                </div>
                <br>
                <div>
                    <label for="Type">Type</label>
                    <input class="formInput" type='text' name='type' value='<%= eq.getType()%>'>
                </div>
                <br>
                <div>
                    <label for="Vendor">Vendor</label>
                    <input class="formInput" type='text' name='vendor' value='<%= eq.getVendor()%>'>
                </div>
                <br>
                <div>
                    <label for="SerialNumber">Serial Number</label>
                    <input class="formInput" type='text' name='serialNumber' value='<%= eq.getSerialNumber()%>'>
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
                        <script>
                            function select() {
                                document.getElementById("status").selectedIndex
                                        = "1";
                            }
                            select();
                        </script>
                        <%} else if (eq.getStatus().equals("Inactive")) {
                        %>
                        <script>
                            function select2() {
                                document.getElementById("status").selectedIndex
                                        = "2";
                            }
                            select2();
                        </script>
                        </script>
                        <%}
                        %>
                    </select>

                    <input type="hidden" name="user_id" value="<%= LoggedUser.getId()%>">
                </div>
                <br>
                <!--<input type='submit' value='Save'>-->
                <button type="submit" ><a class="glyphicon glyphicon glyphicon-floppy-saved"></a></button>
            </form>
            <%@include file="ListEquipment.jsp" %>
        </div>
    </body>
</html>
