<%-- 
    Document   : Menu.jsp
    Created on : 9 de abr. de 2021, 10:45:05
    Author     : Klein
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Menu</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/menu.css">
        
    </head>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        .navbar {
            width: 100%;
            background-color: #555;
            overflow: auto;
        }

        .navbar a {
            float: left;
            padding: 12px;
            color: white;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #000;
        }

        .active {
            background-color: #0d6efd;
        }

        @media screen and (max-width: 500px) {
            .navbar a {
                float: none;
                display: block;
            }
        }
    </style>
    <body>

        <div class="navbar">
            <a class="active" href="Menu.jsp"><span class="glyphicon glyphicon glyphicon-home"></i> Home</a> 
            <a href="User.jsp"><span class="glyphicon glyphicon glyphicon-user"></i> User</a> 
            <a href="Equipment.jsp"><span class="glyphicon glyphicon glyphicon-hdd"></i> Equipment</a> 
            <a href="/HelpDesk/Action?param=logout"><span class="glyphicon glyphicon glyphicon-log-out"></i> Logout</a>
            <a href="EquipmentReport.jsp"><span class="glyphicon glyphicon glyphicon-log-out"></i> Report</a>
        </div>

    </body>

    <div class="welcome">
    </div>
</main>
</html> 

