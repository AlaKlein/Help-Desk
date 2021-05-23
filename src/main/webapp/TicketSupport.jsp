<%-- 
    Document   : Ticket
    Created on : 16 de mai. de 2021, 17:53:38
    Author     : Klein
--%>

<%@page import="Entity.LoggedUser"%>
<%@page import="java.util.Date"%>
<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suport Page</title>
    </head>
    <link href="CSS\ticketUser.css" rel="stylesheet">
    <script type="text/javascript" src="Js/AjaxFunctionSupport.js"></script> 
    <%@include file="Menu.jsp" %>
    <body>

        <h2>Suport Page</h2>

        <!--<form method="post" action="/HelpDesk/Action?param=SearchBoxTicketSupport">-->
        <form method="post" name="formsupport" action="javascript:loadPage('ListTicketSupport.jsp');">

            
            <input type="text" name="title" placeholder="Title">
            <input type="text" name="description" placeholder="Description">
            <input type="text" name="user" placeholder="User">
            <input type="text" name="atendant" placeholder="Atendant">

            <button type="submit" ><a class="glyphicon glyphicon glyphicon-search"></a></button>

            <input type="checkbox" id="checkboxcriteria" name="checkboxcriteria">List Finished
            
            
        </form>

        <br>

        <div id="AjaxReturn">

        </div>


        <%--<%@include file="ListTicketSupport.jsp" %>--%>
    </body>
</html>
