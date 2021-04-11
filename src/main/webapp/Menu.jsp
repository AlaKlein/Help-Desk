<%-- 
    Document   : Menu.jsp
    Created on : 9 de abr. de 2021, 10:45:05
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help Desk Menu</title>
    </head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/menu.css">
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Menu.jsp">Help Desk</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="User.jsp">User</a></li>
                    <li><a href="Equipment.jsp">Equipment</a></li>
                </ul>
                <ul>
                    <li class="nav-item">
                        <a class="nav-link" href="/HelpDesk/Action?param=logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav> 
</html>
