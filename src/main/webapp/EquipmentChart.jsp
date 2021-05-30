<%-- 
    Document   : EquipmentChart
    Created on : 29 de mai. de 2021, 22:04:43
    Author     : Klein
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.EquipmentChartDAO"%>
<%@page import="Entity.EquipmentChart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gráfico</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/navbar.css" rel="stylesheet">


        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
        <style>
            .bloco {                
                padding: 0 200px 200px 200px;
            }
        </style>


        <script>
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(Chart);

            function Chart() {

            <%
                EquipmentChartDAO x = new EquipmentChartDAO();
                ArrayList<EquipmentChart> eq = x.consultarTodos();

                String Vendors = "[['Vendor', 'Quantity'],";

                for (int i = 0; i < eq.size(); i++) {
                    EquipmentChart categ = eq.get(i);
                    Vendors += "['" + categ.getVendor() + "', " + categ.getQtd() + "],\n";
                }

                Vendors += "]";

                System.out.println(Vendors);
            %>

                var data = google.visualization.arrayToDataTable(<%= Vendors%>);


                var options = {
                    title: 'Equipment Vendor Chart',
                    chartArea: {width: '50%'},
                    hAxis: {
                        title: '',
                        minValue: 0
                    },
                    vAxis: {
                        title: ''
                    }
                };

                var chart = new google.visualization.PieChart(document.getElementById('Chart'));
                chart.draw(data, options);
            }
        </script>
    </head>
    <body>     
        <div class="bloco">
            <div id="Chart" style="height: 500px"></div>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
