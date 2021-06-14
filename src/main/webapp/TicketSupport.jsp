<%-- 
    Document   : Ticket
    Created on : 16 de mai. de 2021, 17:53:38
    Author     : Klein
--%>

<%@page import="Entity.LoggedUser"%>
<%@page import="java.util.Date"%>
<%@page import="Entity.Ticket"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
        <script language="JavaScript" src="Js/Validate.js"></script>
        <title>Suport Page</title>
    </head>
    <link href="CSS\ticketUser.css" rel="stylesheet">
    <script type="text/javascript" src="Js/AjaxFunctionSupport.js"></script> 
    <%@include file="Menu.jsp" %>
    <body>
        <Script>
            window.onload = function () {
                document.getElementById('search').click();
            }
        </script>

        <h2>Suport Page</h2>

        <!--<form method="post" action="/HelpDesk/Action?param=SearchBoxTicketSupport">-->
        <form method="post" name="formsupport" onSubmit="return validadeDateTicketSupport();" action="javascript:loadPage('ListTicketSupport.jsp');">


            <input type="text" name="title" placeholder="Title">
            <input type="text" name="description" placeholder="Description">
            <input type="text" name="user" placeholder="User">
            <input type="text" name="atendant" placeholder="Atendant">
            <input class="date" placeholder="Initial Date" class="textbox-n" type="text" onfocus="this.type = 'date'" name="initialdate", id="initialdate">
            <input class="date" placeholder="Final Date" class="textbox-n" type="text" onfocus="(this.type = 'date')" name="finaldate", id="finaldate">

            <button type="submit" id='search' ><a class="glyphicon glyphicon glyphicon-search"></a></button>
            <input type="reset" value="Reset">
            <input type="checkbox" id="checkboxcriteria" name="checkboxcriteria">List Finished


        </form>

        <br>

        <div id="AjaxReturn">

        </div>


        <%--<%@include file="ListTicketSupport.jsp" %>--%>
    </body>
</html>
