<%-- 
    Document   : Success
    Created on : Apr 08, 2021, 15:13:15 PM
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <%@include file="index.jsp" %>

        <%
            String registerType = String.valueOf(request.getAttribute("registerType"));
            String returnPage = String.valueOf(request.getAttribute("returnPage"));
        %>

        <h1>Success!</h1>

        <h4>Action successfully carried out in: <%= registerType%>.</h4>

        <p><a href='<%= returnPage%>' >Return to menu</a></p>
    </body>
</html>
