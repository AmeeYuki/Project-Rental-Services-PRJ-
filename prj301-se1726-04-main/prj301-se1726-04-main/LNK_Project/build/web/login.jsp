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
            .circle {
                color: white;
                transform: skew(-10deg);
                display: inline-block;
                padding: 5px 10px;
                border-radius: 15px;
                float: left;
                margin: 10px 0;
            }
        </style>
    </head>
    <body>
    <header class="header">
        <a href="#"><img src="images/image1.png" class="logo" alt=""></a>
        <div>
            <ul class="navbar">
                <li><a href="./Homepage">Home</a></li>  <!-- cai nay link toi Homepage.jsp -->
                <li><a href="#booking">Booking</a></li>
                <li><a href="#contact">Contact Us</a></li>
                <c:set var="cur" value="${sessionScope.usersession.userUsername}" />
                <li><a href="login.jsp">Login</a></li>
                
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
                    
                    <div class="circle">
                        <label for="userType">You are:</label>
                        <input type="radio" id="userTypeUser" name="userType" value="user" checked>
                        <label for="userTypeUser">User</label>
                        <input type="radio" id="userTypeLendlord" name="userType" value="lendlord">
                        <label for="userTypeLendlord">Lendlord</label>
                    </div>
                    
                    <%-- Display error message if login is incorrect --%>
                    <% if (request.getAttribute("mess") != null) {%>
                    <p style="color: #ff3333;font-weight: bold;"><%= request.getAttribute("mess")%></p>
                    <% }%>
                    <br>
                    <p>Do not have an account? <a href="./Register.html" class="link">Sign up here</a></p>
                    <button><a href="#" class="link2" type="submit">Login</a></button>
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile&redirect_uri=http://localhost:8084/LNK_Project/LoginGoogleController&response_type=code&client_id=771000613635-1lqg91lqfj1jti9cr76psdurou6q3i52.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
                </div>
            </form>
        </div>

        <script src="./js/login.js"></script>
        
              
    </body>
</html>
