<%-- 
    Document   : EquipmentReport
    Created on : 8 de mai. de 2021, 16:47:55
    Author     : Klein
--%>

<%@page import="DAO.EquipmentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EquipmentReport</title>
    </head>
    <body>
        <%
            String vendor = request.getParameter("vendor");

            byte[] bytes = new EquipmentDAO().generateReport(vendor);

            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
        %>
    </body>
</html>
