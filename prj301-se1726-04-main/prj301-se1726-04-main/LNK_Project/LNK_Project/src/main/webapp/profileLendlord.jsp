<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Lendlord.lendlordDAO, Lendlord.lendlordDTO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/profile.css">
   
<style>
    .active-tab {
        background-color: gray; /* Màu nền cho tab được chọn */
    }

    nav ul li a {
        background-color: white; /* Màu nền mặc định cho các tab chưa được chọn */
    }
</style>
</head>
<body>
    <form action="ProfileControllerLendlord" methods="POST" >
<% 
        lendlordDTO lend = (lendlordDTO) request.getSession().getAttribute("user");
        if (lend != null) {
    %>
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

    <div class="">
<div class="">
    <nav>
        <ul>
            <li><a href="#" onclick="showTab('profile')" >PROFILE</a></li>
            <li><a href="#" onclick="showTab('rentalPost')">ROOM RENTAL POST</a></li>
            <li><a href="#" onclick="showTab('notifications')">NOTIFICATIONS</a></li>
            <li><a href="#" onclick="showTab('reviews')">REVIEWS</a></li>
        </ul>
    </nav>
</div>

        <div >
    <div class="box">
        <div id="profile" class="tab">
             <div class="">
                <h2>Lendlord details</h2>
                <div class="container">
                    <div class="avatar">
                        <img src="images/avatar.jpg" alt="Avatar">
                    </div>
                    <div class="content">
                        <h3>Lendlord</h3>
                        <div class="box2">
                            <p><%= lend.getLendFullname() %></p>
                        </div>
                        <h3>Phone Number</h3>
                        <div class="box2">
                            <p><%= lend.getLendPhoneNumber() %></p>
                        </div>
                        <h3>Email</h3>
                        <div class="box2">
                            <p><%= lend.getLendEmail() %></p>
                        </div>
                        <h3>Password</h3>
                        <div class="box2">
                            <p><%= lend.getLendPassword() %></p>
                        </div>
                    </div>
                </div>
                <h2>Payment methods</h2>
                <div >
                    <p>Save my credit card information</p>
                </div>
                <h2>Email subscriptions</h2>
                <div >
                    <p>Remind me of all my upcoming or booking assistance</p>
                </div>
                <a style="text-decoration: none;" href="login.jsp" <button class="logout">Logout</button></a>
                
            </div>
        </div>
        <div id="rentalPost" class="tab" style="display: none;">
            <!-- Nội dung của tab ROOM RENTAL POST -->

        </div>
        <div id="notifications" class="tab" style="display: none;">
            <!-- Nội dung của tab NOTIFICATIONS -->
            
            
        </div>
        <div id="reviews" class="tab" style="display: none;">
            <!-- Nội dung của tab REVIEWS -->
        </div>
    </div>
</div>
                        
        


        
        <% } else { %>
        
        <div >
            <h3>User not found!</h3>
        </div>
        
        <% }%>
    </div>
    </form>
    
<script>
    function showTab(tabName) {
        var tabs = document.querySelectorAll('.tab');
        for (var i = 0; i < tabs.length; i++) {
            tabs[i].style.display = 'none';
        }
        
        var activeTab = document.getElementById(tabName);
        if (activeTab) {
            activeTab.style.display = ' ';
        }
    }
</script>
</body>
</html>



