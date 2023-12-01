<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
        <link rel="stylesheet" href="./css/style.css">
        <style>
            .hidden {
                display: none;
            }
        </style>
    </head>
    <body>
        <header class="header">
            <a href="#"><img src="./images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#booking">Booking</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                    <li><a href="#user">Login</a></li>
                </ul>
            </div>
        </header>

        <div class="login-form">
            <form action="LoginController" method="POST">
                <div class="action">
                    <button class="login"><a href="./login.jsp" class="link">Login</a></button>
                    <button class="register"><a href="./Register.jsp" class="link">Register</a></button>
                </div>
                <div class="content">
                    <div class="input-field">
                        <input type="text" name="username" placeholder="Username" autocomplete="nope">
                    </div>
                    <div class="input-field">
                        <input type="password" name="password" placeholder="Password" autocomplete="new-password">
                    </div>
                    <%-- Display error message if login is incorrect --%>
                    <% if (request.getAttribute("mess") != null) {%>
                    <p style="color: #ff3333;font-weight: bold;"><%= request.getAttribute("mess")%></p>
                    <% }%>
                    <p id="lendlordMessage">Are you Landlord? <a href="#" onclick="hideLendlordMessage()" class="link">Click here</a></p>
                    <p>Do not have an account? <a href="./Register.html" class="link">Sign up here</a></p>
                    <button><a href="#" class="link2" type="submit">Login</a></button>
                </div>
            </form>
        </div>

        <script src="./js/login.js"></script>
        <script>
                        function hideLendlordMessage() {
                            document.getElementById("lendlordMessage").classList.add("hidden");
                        }</script>

    </body>
</html>
