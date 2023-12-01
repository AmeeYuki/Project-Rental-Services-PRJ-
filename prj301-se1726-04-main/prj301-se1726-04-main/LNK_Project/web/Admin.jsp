<%@page import="Information.infoDTO"%>
<%@page import="Contract.contractDTO"%>
<%@page import="java.util.List"%>
<%@page import="Coupon.couponDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Administrator</title>
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
            function openPage(evt, tab) {
                var i, tabcontent, tablinks;
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].classList.remove("active");
                }
                document.getElementById(tab).style.display = "block";
                evt.currentTarget.classList.add("active");
            }
            function setStatusStyles() {
                var rows = document.querySelectorAll(".tabcontent tbody .box2");
                rows.forEach(function (row) {
                    var statusCell = row.querySelector("td:nth-child(5)");
                    var statusText = statusCell.textContent.trim().toLowerCase();

                    if (statusText === "approved") {
                        row.style.backgroundColor = "#C2E6DA";
                        statusCell.style.color = "green";
                    } else if (statusText === "canceled") {
                        row.style.backgroundColor = "#FACFCF";
                        statusCell.style.color = "red";
                    } else if (statusText === "pending" || statusText === "not started") {
                        row.style.backgroundColor = "#D4E4F2";
                        statusCell.style.color = "blue";
                    }else if (statusText === "accepted") {
                        row.style.backgroundColor = "#C2E6DA";
                        statusCell.style.color = "green";
                    }
                });
            }

            document.addEventListener("DOMContentLoaded", function () {
                setStatusStyles();

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
            <a href="AdminController"><img src="images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="AdminController">Home</a></li>
                    <li><%@include file="logout.jsp" %></li>
                </ul>
            </div>
        </header>
        <h1 style="text-align: center">ADMINISTRATOR CONTROLLER</h1>
        <div class="nav-controller">
            <button class="tablink" onclick="openPage(event, 'Services')">COUPONS AND DISCOUNTS</button>
            <button class="tablink" onclick="openPage(event, 'Transactions')" id="defaultOpen">CONTRACTS</button>
            <button class="tablink" onclick="openPage(event, 'News')">INFORMATIONS</button>
        </div>


        <div id="Services" class="tabcontent">
            <div class="container">
                <div id="left">
                    <h3>Pending coupons & discounts</h3>
                    Coupon ID/ Discount ID
                    <div class="functions">
                        <form action="AdminController" method="post" name="search" class="search-form">
                            <div class="search-input">
                                <input type="text" name="search" placeholder="Search..">
                            </div>
                            <div class="search-button">
                                <button type="submit" name="action" value="searchcoupon"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                    <% List<couponDTO> list = (List<couponDTO>) request.getAttribute("couponList");
                        if (list != null && !list.isEmpty()) { %>
                    <table>
                        <thead>
                            <tr>
                                <th class="sortable">ID</th>
                                <th class="sortable">Name</th>
                                <th class="sortable">Booking Date</th>
                                <th class="sortable">Check-in Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (couponDTO l : list) {%>
                            <tr class="box2">
                                <td><%= l.getCouponID()%></td>
                                <td><%= l.getCouponName()%></td>
                                <td><%= l.getStartDate()%></td>
                                <td><%= l.getExpiredDate()%></td>
                                <td><%= l.getStatusCoupon()%></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <% } %>
                </div>  

                <div id="right">
                    <h3>Details Coupons</h3>
                    <% couponDTO couponDetail = (couponDTO) request.getAttribute("couponDetail");
                        if (couponDetail != null) {%>
                    <p>ID: <b><%= couponDetail.getCouponID()%></b></p>
                    <p>Name: <b><%= couponDetail.getCouponName()%></b></p><br>
                    <p>Details services: <b><%= couponDetail.getCouponDetails()%></b></p>
                    <p>Apply for: <b><%= couponDetail.getCouponFor()%></b></p>
                    <p>Starting Date: <b><%= couponDetail.getStartDate()%></b></p>
                    <p>End Date: <b><%= couponDetail.getExpiredDate()%></b></p>
                    <p>Status: <b><%= couponDetail.getStatusCoupon()%></b></p>
                    <form action="AdminController" method="post">
                        <input type="hidden" name="id" value="<%= couponDetail.getCouponID()%>">
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px; background-color: #FACFCF;" type="submit" name="action" value="delete">Cancel Coupon</button>
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px;" type="submit" name="action" value="delete2">Approve Coupon</button>
                    </form>
                    <button id="addCoupons" onclick="document.getElementById('id01').style.display = 'block'" style="width: 40%; margin-left: 90%; border-radius: 10px;">Create new coupons</button>

                    <% } %>
                </div>

                <div id="id01" class="modal">
                    <form class="modal-content animate" action="AdminController" method="post">
                        <div class="imgcontainer">
                            <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                        </div>

                        <div class="container2">
                            <h3 style="text-align: center">Create a new coupon</h3>
                            <label for="uname"><b>Name</b></label>
                            <input type="text" placeholder="Name..." name="uname" required>
                            <label for="detail"><b>Details</b></label>
                            <input type="text" placeholder="Details..." name="detail" required>
                            <label for="detail"><b>Discount</b></label>
                            <input type="text" placeholder="Discount..." name="discount" required>
                            <label for="apply"><b>Apply for</b></label>
                            <br>
                            <select name="apply" id="apply">
                                <option value="hotel">Hotel</option>
                                <option value="tour">Tour</option>
                            </select>
                            <label for="startDate"><b>Start Date</b></label>
                            <input type="Date" placeholder="Details..." name="startdate" required>
                            <label for="expiredDate"><b>Expired Date</b></label>
                            <input type="Date" placeholder="Details..." name="expireddate" required>
                            <br>
                            <br>
                            <br>
                            <label for="status"><b>Status</b></label>
                            <input type="text" placeholder="Status..." name="status" required>
                            <button type="submit" name="action" value="addCoupon">Add new coupon</button>
                        </div>
                    </form>
                    <script>
                        var modal = document.getElementById('id01');
                        window.onclick = function (event) {
                            if (event.target == modal) {
                                modal.style.display = "none";
                            }
                        }
                    </script>
                </div>
            </div>
        </div>

        <div id="Transactions" class="tabcontent">
            <div class="container">
                <div id="left">
                    <h3>Pending transactions</h3>
                    Transaction ID
                    <div class="functions">
                        <form action="" method="post" name="search" class="search-form">
                            <div class="search-input">
                                <input type="text" name="search" placeholder="Search..">
                            </div>
                            <div class="search-button">
                                <button type="submit" name="action" value="searchcontract"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                    <% List<contractDTO> list2 = (List<contractDTO>) request.getAttribute("contractList"); %>
                    <%               if (list2 != null && list2.size() > 0) {%>
                    <table>
                        <thead>
                            <tr>
                                <th class="sortable">ID</th>
                                <th class="sortable">Name</th>
                                <th class="sortable">Booking Date</th>
                                <th class="sortable">Check-in Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (contractDTO l2 : list2) {%>
                            <tr class="box2">
                                <td><%= l2.getContractID()%></td>
                                <td><%= l2.getInfoTitle()%></td>
                                <td><%= l2.getBookingDate()%></td>
                                <td><%= l2.getCheckInDate()%></td>
                                <td><%= l2.getContractStatus()%></td>
                            </tr>
                            <%  } %>
                        </tbody>
                    </table>
                    <%  }%>
                </div>

                <div id="right">
                    <h3>Details Transactions</h3>
                    <% contractDTO contractDetail = (contractDTO) request.getAttribute("contractDetail");
                        if (contractDetail != null) {%>
                    <p>ID: <b><%= contractDetail.getContractID()%></b></p>
                    <p>Name: <b><%= contractDetail.getInfoTitle()%></b></p><br>  
                    <p>Booking Date: <b><%= contractDetail.getBookingDate()%></b></p>
                    <p>Check-in Date: <b><%= contractDetail.getCheckInDate()%></b></p>
                    <p>Check-out Date: <b><%= contractDetail.getCheckOutDate()%></b></p>
                    <p>Status : <b><%= contractDetail.getContractStatus()%></b></p>
                    <form action="AdminController" method="post">
                        <input type="hidden" name="id" value="<%= contractDetail.getContractID()%>">
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px; background-color: #FACFCF;" type="submit" name="action" value="delete">Cancel
                            Contract</button>
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px;" type="submit" name="action" value="delete2">Approve Contract</button>
                    </form>
                    <% } %>
                </div>
            </div>
        </div>

        <div id="News" class="tabcontent">
            <div class="container">
                <div id="left">
                    <h3>Pending Information</h3>
                    Information ID
                    <div class="functions">
                        <form action="" method="post" name="search" class="search-form">
                            <div class="search-input">
                                <input type="text" name="search" placeholder="Search..">
                            </div>
                            <div class="search-button">
                                <button type="submit" name="action" value="searchinfo"><i class="fa fa-search"></i></button>
                            </div>
                        </form>
                    </div>
                    <% List<infoDTO> list3 = (List<infoDTO>) request.getAttribute("infoList"); %>
                    <%               if (list3 != null && list3.size() > 0) {%>
                    <table>
                        <thead>
                            <tr>
                                <th class="sortable">ID</th>
                                <th class="sortable">Title</th>
                                <th class="sortable">Author</th>
                                <th class="sortable">Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (infoDTO l3 : list3) {%>
                            <tr class="box2">
                                <td><%= l3.getInfoID()%></td>
                                <td><%= l3.getInfoTitle()%></td>
                                <td><%= l3.getLendFullname()%></td>
                                <td><%= l3.getUploadDate()%></td>
                                <td><%= l3.getInfoStatus()%></td>
                            </tr>
                            <%  } %>
                        </tbody>
                    </table>
                    <%  } %>
                </div>

                <div id="right">
                    <h3>Details Information</h3>   
                    <% infoDTO infoDetail = (infoDTO) request.getAttribute("infoDetail");
                        if (infoDetail != null) {%>
                    <p>ID: <b><%= infoDetail.getInfoID()%></b></p>
                    <p>Title:<b> <%= infoDetail.getInfoTitle()%></b></p><br>
                    <p>Author: <b><%= infoDetail.getLendFullname()%></b></p>
                    <p>Date: <b><%= infoDetail.getUploadDate()%></b></p>
                    <p>Status : <b><%= infoDetail.getInfoStatus()%></b></p>
                    <form action="AdminController" method="post">
                        <input type="hidden" name="id" value="<%= infoDetail.getInfoID()%>">
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px; background-color: #FACFCF;" type="submit" name="action" value="delete">Cancel Information</button>
                        <button style="width: 40%; margin-left: 90%; border-radius: 10px;" type="submit" name="action" value="delete2">Approve Information</button>
                    </form>
                    <%  }%>
                </div>
            </div>
        </div>

    </body>

</html>
