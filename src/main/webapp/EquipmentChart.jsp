<%-- 
    Document   : EquiomentChart
    Created on : 29 de mai. de 2021, 22:04:43
    Author     : Klein
--%>

<%@page import="DAO.EquipmentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Equipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <html>
        <head>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
                google.charts.load('current', {'packages': ['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                function drawChart() {

                    //        var data = google.visualization.arrayToDataTable([
                    //          ['Task', 'Hours per Day'],
                    //          ['Work',     11],
                    //          ['Eat',      2],
                    //          ['Commute',  2],
                    //          ['Watch TV', 2],
                    //          ['Sleep',    7]
                    //        ]);

              

                var data = google.visualization.([
                    ['Brand', 'Quantity'],
                    ['
                    <% ArrayList<Equipment> equipments = new EquipmentDAO().consultarChart();
                    for (int i = 0; i < equipments.size(); i++) {
                            Equipment equip = equipments.get(i);
                            
                            equip.getVendor();
                    %>
                                    ', 2],
                    ['dell', 1],
                    
                
        ]);

                    var options = {
                        title: 'My Daily Activities'
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                    chart.draw(data, options);
                }
            </script>
        </head>
        <body>
            <div id="piechart" style="width: 900px; height: 500px;"></div>
        </body>
    </html>

</body>
</html>
