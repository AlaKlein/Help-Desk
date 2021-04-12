<%-- 
    Document   : Login
    Created on : 8 de abr. de 2021, 16:28:56
    Author     : Klein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login to Help desk</title>

        <script language="JavaScript" src="Js/Validate.js"></script>
        <!-- Bootstrap core CSS -->
        <link href="CSS/bootstrap.min.css" rel="stylesheet">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <!-- Custom styles for this template -->
        <link href="CSS\signin.css" rel="stylesheet">
    </head>
    <body class="text-center">

        <main class="form-signin">
            <form name='Loginform' method='post' action="/HelpDesk/Action?param=login"' onSubmit="return validateDataLogin();">
                <h2>Help desk</h2>
                <img class="mb-4" src="Img/LoginLogo.png" alt="" width="126" height="126">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <div class="form-floating">
                    <input type="text" name="email" class="form-control" id="floatingInput" placeholder="name@example.com" autofocus="">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <%
                    String msg = String.valueOf(request.getAttribute("msgLogin"));
                    String ErrorMessage = String.valueOf(request.getAttribute("ErrorMessage"));

                    if (msg.equals("Error") && ErrorMessage.equals("User Inactive")) {
                %>
                <p id="msgErroLogin">User Inactive!</p>
                <%
                } else if (msg.equals("Error") && ErrorMessage.equals("")) {
                %>
                <p id="msgErroLogin">Wrong E-mail or Password!</p>
                <%
                } else {
                %>
                <p id="msgErroLogin"></p>
                <%
                    }
                %>
                
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
            </form>
        </main>
    </body>
</html>
