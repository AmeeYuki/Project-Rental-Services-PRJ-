
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Lendlord.lendlordDTO"%>


<!DOCTYPE html>
<html lang="en">
    <%

        lendlordDTO lend = (lendlordDTO) request.getSession().getAttribute("user");
        if (lend != null) {
    %>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile <%= lend.getLendFullname()%></title>
        <link rel="stylesheet" type="text/css" href="css/Landlord.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <script>
            function openUser(evt, tab) {
                // Declare all variables
                var i, box, tablinks;

                // Get all elements with class="tabcontent" and hide them
                box = document.getElementsByClassName("box");
                for (i = 0; i < box.length; i++) {
                    box[i].style.display = "none";
                }

                // Get all elements with class="tablinks" and remove the class "active"
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }

                // Show the current tab, and add an "active" class to the link that opened the tab
                document.getElementById(tab).style.display = "block";
                evt.currentTarget.className += " active";
            }
            document.addEventListener("DOMContentLoaded", function () {
                var rows = document.querySelectorAll("tbody .box2");
                rows.forEach(function (row) {
                    var statusCell = row.querySelector("td:nth-child(5)");
                    if (statusCell.textContent === "Approved") {
                        row.style.backgroundColor = "#C2E6DA";
                        statusCell.style.color = "green";
                    } else if (statusCell.textContent === "Not Approved") {
                        row.style.backgroundColor = "#FACFCF";
                        statusCell.style.color = "red";
                    } else if (statusCell.textContent === "Canceled") {
                        row.style.backgroundColor = "#80868B";
                        statusCell.style.color = "blue";
                    }
                });
            });

            document.addEventListener("DOMContentLoaded", function () {
                // Toggle visibility of submenu on click
                var menuItems = document.querySelectorAll("nav ul li");
                menuItems.forEach(function (menuItem) {
                    menuItem.addEventListener("click", function () {
                        this.classList.toggle("active");
                    });
                });
            });

        </script>
    </head>

    <body>

        <header class="header">
            <a href="#"><img src="images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#booking">Booking</a></li>
                    <li><a href="#products">Products</a></li>
                    <li><a href="#user">Hi, <%= lend.getLendUsername()%></a></li>
                </ul>
            </div>
        </header>
        <nav>
            <ul>
                <li class="tablinks" onclick="openUser(event, 'Profile')">PROFILE</li>
                <li class="tablinks" onclick="openUser(event, 'MyPost')">ROOM RENTAL POST</li>
                <li class="tablinks" onclick="openUser(event, 'Notifications')">NOTIFICATIONS</li>
            </ul>
        </nav>
        <div id="Profile" class="box">
            <h2>Landlord details</h2>
            <div class="container">
                <div class="image">
                    <img src="https://nhadepso.com/wp-content/uploads/2023/03/suu-tam-60-hinh-anh-avatar-trang-cho-facebook-dep-doc-dao_1.jpg" alt="Avatar">
                </div>
                <div class="content">
                    <h3>Username</h3>
                    <div class="box2">
                        <p><%= lend.getLendUsername()%></p>
                    </div>
                    <h3>FullName</h3>
                    <div class="box2">
                        <p><%= lend.getLendFullname()%></p>
                    </div>
                    <h3>Phone Number</h3>
                    <div class="box2">
                        <p><%= lend.getLendPhoneNumber()%></p>
                    </div>
                    <h3>Email</h3>
                    <div class="box2">
                        <p><%= lend.getLendEmail()%></p>
                    </div>
                    <h3>Password</h3>
                    <div class="box2">
                        <p><%= lend.getLendPassword()%></p>
                    </div>
                </div>
            </div>
            <h2>Payment methods</h2>
            <div class="box2">
                <p>Save my credit card information</p>
            </div>
            <h2>Email subcriptions</h2>
            <div class="box2">
                <p>Reminder all my upcoming or booking assist</p>
            </div>
            <button class="logout"><a href="./login.jsp" class="link">Logout</a></button>
        </div>

        <div id="MyPost" class="box">
            <form action="PostController" method="Post">       
                <input type="submit" value="newPost"   <button style="background-color: #32B4B7; padding: 12px 28px; border-radius: 5px; border: none; margin-left: 87%; color: white; margin-bottom: 10px;"></button>
</form>
<div class="box1">
    <c:forEach var="info" items="${infoList}">
        <table>
            <tr>
                <td>    
                    <img src="${info.inforImage}" alt="Info Image" class="box-image">
                </td>
                <td>
                    <div class="box-info">
                        <h4>${info.infoTitle}</h4>
                        <button style="background-color: #32B4B7; border: none; padding: 5px; border-radius: 5px;">
                            ${info.infoType}
                        </button>
                        <p style="color: blue; margin: 0;">${info.infoAddress}</p>
                    </div>
                </td>
                <td>
                    <div class="box-price">
                        <p style="color: red;">${info.infoPrice} VND</p>
                    </div>
                </td>
            </tr>
        </table>
    </c:forEach>
</div>



            </div>
        </div>
        <div id="Notifications" class="box">
            <table>
                <thead>
                    <tr style="background-color: #0096C7;">
                        <th style="padding: 30px; color: white;" class="sortable">Name User</th>
                        <th style="color: white;" class="sortable">Book</th>
                        <th class="sortable"></th>
                        <th class="sortable"></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="box2">
                        <td style="padding: 15px;">Ame</td>
                        <td>Sam Son Tour</td>
                        <td>15.2.2023</td>
                        <td>20.2.2023</td>
                        <td>Not Approved</td>
                    </tr>
                    <tr class="box2">
                        <td style="padding: 15px;">Ame</td>
                        <td>Rang Garden Beach Side</td>
                        <td>3.4.2023</td>
                        <td></td>
                        <td>Approved</td>
                    </tr>
                    <tr class="box2">
                        <td style="padding: 15px;">Ame</td>
                        <td>Estrella Boutique Hotel</td>
                        <td>15.8.2023</td>
                        <td>20.8.2023</td>
                        <td>Canceled</td>
                    </tr>
                </tbody>
            </table>
        </div>


        <% } else { %>

        <div >
            <h3>User not found!</h3>
        </div>

        <% }%>  
    </body>
</html>