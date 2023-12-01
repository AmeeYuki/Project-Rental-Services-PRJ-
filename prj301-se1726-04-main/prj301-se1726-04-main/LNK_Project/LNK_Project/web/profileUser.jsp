<%@page import="java.util.List"%>
<%@page import="Contract.contractDTO"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile's ${sessionScope.usersession.userUsername}</title>
        <link rel="stylesheet" type="text/css" href="./css/user.css">
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
                    if (statusCell.textContent === "COMPLETED") {
                        row.style.backgroundColor = "#C2E6DA";
                        statusCell.style.color = "green";
                    } else if (statusCell.textContent === "CANCELED") {
                        row.style.backgroundColor = "#FACFCF";
                        statusCell.style.color = "red";
                    } else if (statusCell.textContent === "PENDING") {
                        row.style.backgroundColor = "#D4E4F2";
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

        <style>
            #field{
                border: none;
                background-color: inherit;
                padding: 3px auto;
            }
        </style>



    </head>

    <body>

        <header class="header">
            <a href="#"><img src="./images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="./Homepage">Home</a></li>  <!-- cai nay link toi Homepage.jsp -->
                    <li><a href="#booking">Booking</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                    <li><a href="./profileUser">Hi, ${sessionScope.usersession.userUsername}</i></a></li> <!-- cai nay link toi ProfileController -->
                    <li><%@include file="logout.jsp" %></li>

                </ul>
            </div>
        </header>
        <nav>
            <ul>
                <li class="tablinks" onclick="openUser(event, 'Profile')">PROFILE</li>
                <li class="tablinks" onclick="openUser(event, 'MyBooking')">MY BOOKING</li>
                <ul class="submenu">
                    <li class="tablinks" onclick="openUser(event, 'hbooking')">HISTORY BOOKINGS</li>
                </ul>
                <li class="tablinks" onclick="openUser(event, 'Notifications')">NOTIFICATIONS</li>
                <li class="tablinks" onclick="openUser(event, 'Coupons & Discounts')">COUPONS & DISCOUNTS</li>
            </ul>
        </nav>
        <div id="Profile" class="box">
            <h2>User details</h2>
            <div class="container">
                <div class="image">
                    <img style="width:300px; height: 300px" src="./images/avatar.jpg" alt="Avatar">
                </div>
                <div class="content">
                    <form action="ProfileController" method="post">
                        <h3>Name</h3>
                        <div class="box2">
                            <input id="field" type="text" name="fullname" value="${sessionScope.usersession.userFullname}">
                        </div>
                        <h3>Phone Number</h3>
                        <div class="box2">
                            <input id="field" type="text" name="phone" value="${sessionScope.usersession.userPhoneNumber}">
                        </div>
                        <h3>Email</h3>
                        <div class="box2">
                            <input id="field" type="text" name="email" value="${sessionScope.usersession.userEmail}">
                        </div>
                        <h3>Password</h3>
                        <div class="box2">
                            <input id="field" type="password" name="password" value="${sessionScope.usersession.userPassword}">
                        </div>
                        <input type=hidden name="action" value="edit">
                        <input style="float:right; border: none; padding: 10px 20px; background-color: #32B4B7; color: white; font-weight: bolder" type="submit" name="action" value="Save your infomation">
                    </form>

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

        </div>


        <div id="MyBooking" class="box" style="display:none">
            <h2>Upcoming bookings</h2>
            <div class="row">
                <div class="section">
                    <div class="label">Booking ID</div>
                    <div class="search-container">
                        <form action="ProfileController" method="POST">
                            <input type="text" id="search-input" name="searchUp" placeholder="Search...">
                            <input type="hidden" name="action" value="searchUp"> 
                            <button type="submit" name="action" id="search-button"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                </div>
                <div class="section">
                    <div class="label">Sort by</div>
                    <div class="option-container">
                        <input type="radio" id="option1" name="options" value="option1-value1" checked>
                        <label for="option1">Booking Date</label>

                        <input type="radio" id="option2" name="options" value="option2-value1">
                        <label for="option2">Check-in date</label>
                    </div>
                </div>
            </div>
            <% List<contractDTO> list = (List<contractDTO>) request.getAttribute("listComming"); %>
            <%               if (list != null && list.size() > 0) {%>
<table>                
    <thead>
        <tr>
            <th class="sortable">Contract ID</th>
            <th class="sortable">Name</th>
            <th class="sortable">Booking Date</th>
            <th class="sortable">Check-in Date</th>
            <th>Status</th>
            <th>View Contract</th>
            <th>Cancel Contract</th>
        </tr>
    </thead>
    <tbody>
        <% for (contractDTO l : list) {%>
        <tr class="box2">
            <td><%= l.getContractID()%></td>
            <td><%= l.getInfoTitle()%></td>
            <td><%= l.getBookingDate()%></td>
            <td><%= l.getCheckInDate()%></td>
            <td><%= l.getContractStatus()%></td>
            <td>
                <form action="ProfileController" method="post">
                    <input type="hidden" name="view">
                    <input type="hidden" name="contractID" value="<%=l.getContractID() %>">
                    <!--                                <button name="action" type="submit" style="width: 70px;border-radius: 5px; border:none;background-color: #34a203;"><i class='fa fa-eye' style="margin-top: 15px;width: 30px;height: 30px; text-align: center;font-size: 15px;font-weight: 900; color:white"></i></button>-->
                    <input type="submit" name="action" value="VIEW">
                </form>
            </td>
            <td>
                <form action="ProfileController" method="post">
                    <input type="hidden" name="cancel">
                    <input type="hidden" name="contractID" value=" <%=l.getContractID() %>">
<!--                    <button name="action" type="submit" style="width: 70px;border-radius: 5px;border:none;background-color: #ff5252;" onclick=""><i i class="fa fa-times" aria-hidden="true" style="margin-top: 15px;width: 30px;height: 30px; text-align: center;font-size: 15px;font-weight: 900; color:white"></i></button>-->
                    <input type="submit" name="action" value="CANCEL">
                </form>
            </td>
        </tr>
        <%  } %>
    </tbody>

</table>

<script>
    // get all rows in the table
    var rows = document.querySelectorAll('.box2');

    // loop through each row
    for (var i = 0; i < rows.length; i++) {
        // get the contract status cell and cancel button cell
        var statusCell = rows[i].children[4];
        var cancelButtonCell = rows[i].children[6];

        // get the contract status text
        var statusText = statusCell.textContent;

        // if the contract status is "COMPLETED" or "CANCELLED"
        if (statusText === 'COMPLETED' || statusText === 'CANCELLED') {
            // hide the cancel button
            cancelButtonCell.style.display = 'none';
        }
    }
</script>

            <% } %>
            
            
            
        </div>


        <% List<contractDTO> listHistory = (List<contractDTO>) request.getAttribute("listHistory"); %>    
        <div id="hbooking" class="box" style="display:none">
            <h2>History bookings</h2>
            <div class="row">
                <div class="section">
                    <div class="label">Booking ID</div>
                    <div class="search-container">
                        <input type="text" id="search-input" placeholder="Search...">
                        <button type="submit" id="search-button"><i class="fa fa-search"></i></button>
                    </div>
                </div>
                <div class="section">
                    <div class="label">Sort by</div>
                    <div class="option-container">
                        <input type="radio" id="option5" name="options" value="option5-value1" checked>
                        <label for="option5">Booking Date</label>

                        <input type="radio" id="option6" name="options" value="option6-value1">
                        <label for="option6">Check-in date</label>
                    </div>
                </div>
            </div>
            <% if (listHistory != null && !listHistory.isEmpty()) { %>
            <table>
                <thead>
                    <tr>
                        <th class="sortable">ID</th>
                        <th class="sortable">Name</th>
                        <th class="sortable">Booking Date</th>
                        <th class="sortable">Check-in Date</th>
                        <th>Status</th>
                        <th>View</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (contractDTO listH : listHistory) {%>
                    <tr class="box2">
                        <td><%= listH.getContractID()%></td>
                        <td><%= listH.getInfoTitle()%></td>
                        <td><%= listH.getBookingDate()%></td>
                        <td><%= listH.getCheckInDate()%></td>
                        <td><%= listH.getContractStatus()%></td>
                                                <td>
                             <form action="ProfileController" method="post">
                                <input type="hidden" name="view">
                                <input type="hidden" name="contractID" value="<%=listH.getContractID() %>"
<!--                                <button name="action" type="submit" style="width: 70px;border-radius: 5px; border:none;background-color: #34a203;"><i class='fa fa-eye' style="margin-top: 15px;width: 30px;height: 30px; text-align: center;font-size: 15px;font-weight: 900; color:white"></i></button>-->
                                <input type="submit" name="action" value="VIEW">
                            </form>
                        </td>
                        <td>
                            <form action="ProfileController" method="post">
                                 <input type="hidden" name="remove">
                                <input type="hidden" name="contractID" value="<%=listH.getContractID() %>"
                                <button name="action" type="submit" style="width: 70px;border-radius: 5px;border:none;background-color: #ff5252;"><i i class="fa fa-times" aria-hidden="true" style="margin-top: 15px;width: 30px;height: 30px; text-align: center;font-size: 15px;font-weight: 900; color:white"></i></button>
                            </form>
                        </td>   
                    </tr>

                    <% } %>
                </tbody>
            </table>
            <% } else { %>   <h4 style="text-align: center">NOT FOUND!</h4> <%}%>

        </div>

        <div id="Notifications" class="box" style="display: none;">
            <h2>Notifications</h2>
            <div class="box2">
                <h3>Your booking is coming! Get Ready!</h3>
                <p>In 2 days, you will be arriving at Estrella Boutique Hotel for your reservation. Have a great...</p>
            </div>
        </div>

        <div id="Coupons" class="box" style="display:none">
            <h2>Coupon & Discount</h2>
            <div class="box2">
                <h3>We have some coupon for you!</h3>

            </div>
        </div>

    </body>
</html>