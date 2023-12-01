<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Register Page</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'><link rel="stylesheet" href="./css/style2.css">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <header class="header">
            <a href="#"><img src="images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#booking">Booking</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                    <li><a href="#user">Login</a></li>
                </ul>
            </div>
        </header>

        <div class="register-form">
            <form action="<%= request.getContextPath() %>/Register" name="registerForm" method="POST">
                <div class="action">
                    <button class="login"><a href="./login.jsp" class="link">Login</a></button>
                    <button class="register"><a href="./Register.jsp" class="link">Register</a></button>
                </div>
                <div class="content">
                    <div class="input-field">   
                        <input type="text" id="usr" name="username" placeholder="Username" autocomplete="nope">
                    </div>
                    <div class="input-field">
                        <input type="text" id="email" name="email" placeholder="Email" autocomplete="nope">
                    </div>
                    <div class="input-field">
                        <input type="text" id="phone" name="phone" placeholder="PhoneNumber" autocomplete="nope">
                    </div>
                    <div class="input-field">
                        <input type="password" id="pw" name="password" placeholder="Password" autocomplete="new-password">
                    </div>
                    <div class="input-field">
                        <input type="password" id="fir-pw" name="fir" placeholder="Confirm Password" autocomplete="confirm-password">
                    </div>
                    <% String err = (String) request.getAttribute("error");
                        if (err != null) {
                            out.print("<p style=\"color: #ff3333; font-weight: bold\">" + err + "</p>");
                }%> 
                    <input id="swap" name="role" value="1" style="display: none">  <!-- This field is giving role they are user or landlord -->
                    <div style="display: flex">
                        <p id="swaper1" style="margin-top: 8px">Register as Landlord?</p> <a style="margin-top: 8px; margin-left: 4px" href="#" id="swaper" class="link">Click here</a>
                    </div>
                    <script>
                        let user = "Register as Landlord?";
                        let landlord = "Register as User?";
                        let oldValue = "1";
                        let newValue = "2";
                        document.getElementById("swaper").addEventListener("click", function (event) {
                            event.preventDefault();
                            let input = document.getElementById("swap");
                            let input1 = document.getElementById("swaper1");
                            if (input.value === oldValue && input1.textContent === user) {
                                input.value = newValue;
                                input1.textContent = landlord;
                            } else {
                                input.value = oldValue;
                                input1.textContent = user;
                            }
                        });
                    </script>
                    <p style="margin-top: 10px">Do you already have an account? <a href="./login.jsp" class="link">Sign in here </a> </p> 
                    <!--<button><a href="./login.jsp" class="link2">Register</a></button>-->
                    <button><input style="border: none; background: none;   font-family: 'Rubik', sans-serif; font-weight: bold"  type="submit" value="REGISTER"></button>
                </div>
            </form>
        </div>
    </body>
</html>
