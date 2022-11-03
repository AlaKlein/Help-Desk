<%-- 
    Document   : User
    Created on : 8 de abr. de 2021, 14:23:20
    Author     : Klein
--%>
<%@page import="Entity.LoggedUser"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<%@page import="Entity.Equipment"%>
<%--<%@page import="javax.servlet.RequestDispatcher"%>--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.EquipmentChartDAO"%>
<%@page import="Entity.EquipmentChart"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipment CRUD</title>
        <script language="JavaScript" src="Js/Validate.js"></script>
        <script type="text/javascript" src="Js/AjaxFunctionEquipment.js"></script> 


        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/navbar.css" rel="stylesheet">


        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </head>
    <link href="CSS\equipment.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>
        <Script>
            window.onload = function () {
                document.getElementById('search').click();
            }
        </script>
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
                    eq.setIp("");
                    eq.setStatus("");
                    eq.setUser_id(0);
                }
            %>
            <h2>Add Equipment-AEHOOO</h2>
            <br>
            <br>
            <div id = "rightbox">
                <div id="Chart"></div>
                <thead>
                </thead>
            </div>

            <script>
                google.charts.load('current', {'packages': ['corechart']});
                google.charts.setOnLoadCallback(Chart);

                function Chart() {

                <%
                    EquipmentChartDAO x = new EquipmentChartDAO();
                    ArrayList<EquipmentChart> equip = x.consultarTodos();

                    String Vendors = "[['Vendor', 'Quantity'],";

                    for (int i = 0; i < equip.size(); i++) {
                        EquipmentChart categ = equip.get(i);
                        Vendors += "['" + categ.getVendor() + "', " + categ.getQtd() + "],\n";
                    }

                    Vendors += "]";

                    System.out.println(Vendors);
                %>

                    var data = google.visualization.arrayToDataTable(<%= Vendors%>);

                    var options = {
//                        title: 'Equipment Vendor',
                        chartArea: {
                            height: '100%',
                            width: '100%',
                            top: 0,
                            left: 0,
                            right: 0,
                            bottom: 0
                        },
                        height: '100%',
                        width: '100%',
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('Chart'));
                    chart.draw(data, options);
                }
            </script>
            <script src="js/bootstrap.bundle.min.js"></script>

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
                <!--                <div>
                                    <label for="Vendor">Vendor</label>
                                    <input class="formInput" type='text' name='vendor' value='<%= eq.getVendor()%>'>
                                </div>-->
                <div>
                    <label for="Vendor">Vendor</label>
                    <select name="vendor" id="vendor">
                        <option value="Choose">Choose</option>
                        <option value="Dell">Dell</option>
                        <option value="HP">HP</option>
                        <option value="Lenovo">Lenovo</option>
                        <option value="Acer">Acer</option>

                        <%
                            if (eq.getVendor().equals("Dell")) {
                        %>
                        <script>
                            function selectDell() {
                                document.getElementById("vendor").selectedIndex
                                        = "1";
                            }
                            selectDell();
                        </script>
                        <%} else if (eq.getVendor().equals("HP")) {
                        %>
                        <script>
                            function selectHP() {
                                document.getElementById("vendor").selectedIndex
                                        = "2";
                            }
                            selectHP();
                        </script>
                        <%} else if (eq.getVendor().equals("Lenovo")) {
                        %>
                        <script>
                            function selectLenovo() {
                                document.getElementById("vendor").selectedIndex
                                        = "3";
                            }
                            selectLenovo();
                        </script>
                        <%} else if (eq.getVendor().equals("Acer")) {
                        %>
                        <script>
                            function selectAcer() {
                                document.getElementById("vendor").selectedIndex
                                        = "4";
                            }
                            selectAcer();
                        </script>
                        <%}
                        %>
                    </select>
                </div>

                <br>
                <div>
                    <label for="SerialNumber">Serial Number</label>
                    <input class="formInput" type='text' name='serialNumber' value='<%= eq.getSerialNumber()%>'>
                </div>
                <br>
                <div>
                    <label for="SerialNumber">IP Address</label>
                    <input class="formInput" type='text' name='ipAddress' value='<%= eq.getIp()%>'>
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
            <br>

            <!--<form method="post" action="/HelpDesk/Action?param=SearchBoxEquipment">-->
            <form method="post" name="formequipment" action="javascript:loadPage('ListEquipment.jsp');">

                <input type="text" name="id" placeholder="ID">
                <input type="text" name="name" placeholder="Name">
                <input type="text" name="vendor" placeholder="Vendor">
                <input type="text" name="serial" placeholder="SerialNumber">
                <input type="text" name="ip" placeholder="IP Address">

                <button type="submit" id='search'><a class="glyphicon glyphicon glyphicon-search"></a></button>
                <input type="checkbox" id="checkboxcriteria" name="checkboxcriteria">List Inactive
            </form>


            <div id="AjaxReturn">

            </div>


            <%--<%@include file="ListEquipment.jsp" %>--%>
        </div>
    </body>
</html>
