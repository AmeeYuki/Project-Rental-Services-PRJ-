<%@page import="Information.infoDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
    <link rel="stylesheet" href="./css/search2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <script>
        function changeValue(value) {
            document.getElementById('selectedValue').innerHTML = value;
        }
        function changeValue(value) {
            document.getElementById('selectedValue').innerHTML = value;
        }
        function getVals() {
            // Get slider values
            let parent = this.parentNode;
            let slides = parent.getElementsByTagName("input");
            let slide1 = parseFloat(slides[0].value);
            let slide2 = parseFloat(slides[1].value);
            // Neither slider will clip the other, so make sure we determine which is larger
            if (slide1 > slide2) { let tmp = slide2; slide2 = slide1; slide1 = tmp; }

            let displayElement = parent.getElementsByClassName("rangeValues")[0];
            //innerHTML property allows Javascript code to manipulate a website being displayed
            displayElement.innerHTML = "$" + slide1 + " - $" + slide2;
        }
        window.onload = function () {
            // Initialize Sliders
            let sliderSections = document.getElementsByClassName("range-slider");
            for (let x = 0; x < sliderSections.length; x++) {
                let sliders = sliderSections[x].getElementsByTagName("input");
                for (let y = 0; y < sliders.length; y++) {
                    if (sliders[y].type === "range") {
                        //oninput attribute fires when the value of an <input> element is changed
                        sliders[y].oninput = getVals;
                        // Manually trigger event first time to display values
                        sliders[y].oninput();
                    }
                }
            }
        }
    </script>
</head>

<body>
    <!-- partial:index.partial.html -->
    <header class="header">
        <a href="#"><img src="images/image1.png" class="logo" alt=""></a>
        <div>
            <ul class="navbar">
                <li><a href="./Homepage.jsp">Home</a></li>  <!-- cai nay link toi Homepage.jsp -->
                <li><a href="#booking">Booking</a></li>
                <li><a href="#contact">Contact Us</a></li>
                <c:set var="cur" value="${sessionScope.usersession.userUsername}" />
                <c:if test = "${empty cur}">
                <li><a href="login.jsp">Login</i></a></li>
                </c:if>
                <c:if test = "${not empty cur}">
                <li><a href="./profileUser">Hi, ${sessionScope.usersession.userUsername}</i></a></li>  <!-- cai nay link toi ProfileController -->
                <%@include file="logout.jsp" %>
                </c:if>
                
            </ul>
        </div>
    </header>
    <div class="image"> 
        <img src="./images/2.jpg">
    </div>
    <div class="container">
        <form action="HomepageController" method="post">
            <div class="search">
                <div class="slogan">
                    <h2 class="slo">HOTEL, APARTMENT, TOUR</h2><br>
                    <h2 class="slo2">Get the best services on 1,000,000+ places worldwide</h2>
                </div>
                <div class="front">
                    <input type="radio" id="option1" name="options" value="option1-value1" checked>
                    <label for="option1">Hotels & Homes</label>

                    <input type="radio" id="option2" name="options" value="option2-value1">
                    <label for="option2">Private Stays</label>

    <!--                    <input type="radio" id="option3" name="options" value="option3-value1">
                        <label for="option3">Tours</label>-->
                </div>
                <div class="back">
                    <input id="search-box" name="searchMain" type="text" placeholder="Search for hotels or homes... " required="">
                    <div class="date-display">
                        <label for="Check-in">Check-in</label>
                        <label for="Check-out">Check-out</label>
                        <label for="Quantity">Amount of People</label>
                        <label for="Roomtype">Room Type</label>
                    </div>
                    <input name="Check-in" style="margin-right: 5%;" class="below" id="Check-in" type="date"
                        placeholder="Check-in">
                    <input style="margin-right: 5%;" name="Check-out" class="below" id="Check-out" type="date"
                        placeholder="Check-out">
                    <input name="Quantity" class="below" id="Quantity" type="number" placeholder="Number of people"
                        max="50" min="0">
                    <select name="Roomtype" aria-placeholder="Roomtype">
                        <option value="param1">Single Bed & 1 Toilets</option>
                        <option value="param2">Double Beds & 1 Toilets</option>
                        <option value="param3">2 rooms</option>
                        <option value="param4">3 rooms</option>
                        <option value="param5">4 rooms</option>
                    </select>
                </div>
                <div class="search-button">
                    <input type="submit" name="action" value="SEARCH">
                </div>
            </div>
        </form>
    </div>
    <div class="container2">
        <div class="left-boxes">
            <div class="box">
                <h4>Sort Results:</h4> 
                <h4>Sort your results by:</h4>
                <hr>
                <label>
                    <input type="radio" name="option" value="Option 1">
                        Highest Price
                </label>
                <label><br>
                    <input type="radio" name="option" value="Option 2">
                    Lowest Price
                </label><br>
                <label>
                    <input type="radio" name="option" value="Option 3">
                    Highest Popularity
                </label><br>
                <label>
                    <input type="radio" name="option" value="Option 4">
                    Longest Popularity
                </label>
            </div>
            <div class="box">
                <h4>Filter Results:</h4>
                <h4 style="margin: 0;">Showing results by categories:</h4>
                <hr>
                <h4>Price range per room, per people</h4><br>
                <div class="range-slider">
                    <br>
                    <div class="rangeValues"></div>
                    <input value="0" min="0" max="10000000" step="500" type="range">
                    <input value="10000000" min="0" max="10000000" step="500" type="range">
                </div>
            </div>
        </div>
        <div class="right-boxes">
            <% List<infoDTO> list = (List<infoDTO>) request.getAttribute("listActive"); %>
            <% if(list != null && !list.isEmpty()) {%>
                <% for(infoDTO l : list) { %>
            <div class="box">
                <table>
                    <tr>
                        <td>
                            <img src="./images/6.png" alt="Image 3" class="box-image">
                        </td>
                        <td>
                            <div class="box-info">
                                <h4><%= l.getInfoTitle() %></h4>
                                <button
                                    style="background-color: #32B4B7;border: none; padding: 5px;border-radius: 5px;"> <%= l.getInfoType() %></button>
                                <p style="color: blue;margin: 0;"><%= l.getInfoAddress() %></p>
                                <div style="white-space: nowrap;"><span style="color: green;">Impressive</span><span>
                                        (1,283 reviews)</span></div>
                            </div>
                        </td>
                        <td>
                            <div class="box-price">
                                <p style="color: green;">Save <%= l.getCouponDiscount()%>%</p>
                                <br>
                                <p style="color: red;"> <%= l.getInfoPrice() - (l.getInfoPrice() * l.getCouponDiscount()/100) %> VND</p>  <!-- Money after using discount -->
                                <p><del><%= l.getInfoPrice() %> </del>VND</p>
                                <i class="fas fa-shopping-basket"></i><span>  <i class="far fa-heart"></i></span><span>  <i class="far fa-bookmark"></i></span>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
                <% } %>
            <% }%>
        </div>
        <br>
<!--    <button style="background-color: #32B4B7;color: white; border: none; padding: 20px 30px; border-radius: 10px; margin-left: 63%;">See More</button>-->
</body>

</html>