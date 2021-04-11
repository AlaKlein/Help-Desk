<%-- 
    Document   : User
    Created on : 8 de abr. de 2021, 14:23:20
    Author     : Klein
--%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<%@page import="Entity.User"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User CRUD</title>
        
        <script language="JavaScript" src="js/Validate.js"></script>
    </head>
    <link href="CSS\user.css" rel="stylesheet">
    <%@include file="Menu.jsp" %>
    <body>
        <div class="page">
            <%
                User user = (User) request.getAttribute("objUser");

                if (user == null) {
                    user = new User();

                    user.setId(0);
                    user.setEmail("");
                    user.setName("");
                    user.setPassword("");
                    user.setStatus("");
                }
            %>
            <h2>Add User</h2>

            <form name='Userform' method='post' action='/HelpDesk/Action?param=saveUser' onSubmit="return validateData();">
                <input type="hidden" name="id" value="<%= user.getId()%>">
                <div>
                    <label for="Email">Email</label>
                    <input type='text' name='email' required value='<%= user.getEmail()%>'>
                </div>
                <br>
                <div>
                    <label for="Name">Name</label>
                    <input type='text' name='name' required value='<%= user.getName()%>'>
                </div>
                <br>
                <div>
                    <label for="Password">Password</label>
                    <input type='password' name='password' required value='<%= user.getPassword()%>'>
                </div>
                <br>
                <div>
                    <label for="Status">Status</label>
                    <!--<input type='text' name='status' required value='<%= user.getStatus()%>'>-->

                    <select name="status" id="status">
                        <option value="Choose">Choose</option>
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>

                        <%
                            System.out.println("dasuhduas " + user.getStatus());
                            if (user.getStatus().equals("Active")) {
                        %>
                        <option selected="selected">Active</option>
                        <%} else if (user.getStatus().equals("Inactive")) {
                        %>
                        <option selected="selected">Inactive</option>
                        <%}
                        %>
                    </select>
            </form
        </div>
        <br>
        <br>
        <input type='submit' value='Save'>

    </form>


    <%@include file="ListUser.jsp" %>
</div>
</body>
</html>
