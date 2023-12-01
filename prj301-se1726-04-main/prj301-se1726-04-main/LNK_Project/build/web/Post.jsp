<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Lendlord.lendlordDTO"%>
<!DOCTYPE html>
<html lang="en">

    

<%
    lendlordDTO lend = (lendlordDTO) request.getSession().getAttribute("user");
%>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/information.css">
        <title>Document</title>
    </head>

    <body>

        <!-- partial:index.partial.html -->
        <header class="header">
            <a href="#"><img src="images/image1.png" class="logo" alt=""></a>
            <div>
                <ul class="navbar">
                    <li><a href="#home">Home</a></li
                    <li><a style="text-decoration: none; color: white; " href="#booking">Booking</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                    <li><a href="#user">Login</a></li>
                </ul>
            </div>
        </header>

        <div id="container">
            <div class="title">
                <h1>Information</h1>
            </div>

            <form action="InformationController" method="post" id="contact_form">

                <div class="box">
                    <label for="title"></label>
                    <input type="text" placeholder="Title" name="infoTitle" required>
                </div>

                <div class="box">
                    <label for="locate"></label>
                    <input type="text" placeholder="Locate" name="infoAddress" required>
                </div>

                <div class="box">
                    <label for="type"></label>
                    <select name="infoType" required>
                        <option disabled hidden selected>Type</option>
                        <option>Hotel</option>
                        <option>Homestay</option>
                        <option>Tour</option>
                    </select>
                </div>

                <div class="box">
                    <label for="typeroom"></label>
                    <select name="infoTypeRoom" required>
                        <option disabled hidden selected>Type of room</option>
                        <option>Single Bed & 1 Toilet</option>
                        <option>Double Beds & 1 Toilet</option>
                        <option>2 rooms & 2 Toilets</option>
                        <option>3 rooms & 2 Toilets</option>
                        <option>4 rooms & 3 Toilets</option>
                        <option>Other</option>
                    </select>
                </div>




                <div class="box">
                    <label for="price"></label>
                    <input type="number" placeholder="Price" name="infoPrice" required>
                </div>

                 <div class="box">
                    <label for="file"></label>
                    <input type="text" placeholder="Add link URL your image" name="infoImage" required>
                </div>

                <div class="box">
                    <label for="description"></label>
                    <textarea cols="30" rows="5" name="infoDescription" placeholder="Description" required></textarea>
                </div>

<div class="submit">
            <input type="hidden" name="lendID" value="<%= lend.getLendID()%>">
            <input type="hidden" name="action" value="Create" />

  <input type="submit" value="Create Post" id="form_button" />
        </div>
            </form><!-- // End form -->
        </div><!-- // End #container -->
    </body>

</html>

