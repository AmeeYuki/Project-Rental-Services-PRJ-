<%@page import="Invoice.invoiceDTO"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      .header{
        display: flex;
        justify-content: space-between;
      }
      body{
        font-family: 'Inter', sans-serif;
      }
      .bodyTag {
        padding: 0.5% 1%;
        border: 0.2px black solid;
        
      }
      table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 10px;
      }
      th, td {
        text-align: left;
        padding: 8px;
        
      }
      tr:nth-child(even) {
        background-color: #f2f2f2;
      }
      th {
        background-color: #4CAF50;
        color: white;
      }
      .info {
        display: flex;
        justify-content: center;
        
      }
      .info > div {
        margin: 0 150px;
        border: 1px black solid;
        padding: 8px 20px;
        width: 30%;
        border-radius: 10px;
        box-shadow: 0px 5px 4px rgba(0, 0, 0, 0.25);
        border: none;
      }
      h3{
        width:200px;
      }
      li{
        padding-bottom: 4px;
      }
      img{
        width: 200px;
        height: 183px;
      }
    </style>
  </head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@500;600&display=swap" rel="stylesheet">

  <body>
      <% invoiceDTO in = (invoiceDTO) request.getAttribute("invoice");  %>
      
    <div class="bodyTag">
    <div class="header">
      <div>
        <h2>Invoice       <span style="margin-left:30px;font-size: 15px; font-weight: normal;"> ID: #<%= in.getContractID()%></span></h2>
        <p>Date and Time: <p style="font-weight: bolder;"><span id="datetime"></span> </p> </p>
      </div>
      
      <div class="img-edit">
          <img src="./images/img2.png" alt="">
      </div>
      
    </div>

    

    <script>
      function updateClock() {
        var dt = new Date();
        
        var day = dt.getDate();
        var month = dt.getMonth() + 1; // getMonth() returns a zero-based value (0-11)
        var year = dt.getFullYear();
        
        // Format the date as dd/mm/yyyy
        var formattedDate = day + "/" + month + "/" + year;

        // Format the time as hh:mm:ss
        var hours = dt.getHours();
        
        var minutes = dt.getMinutes();
        
        // Add a leading zero to the minutes if it's less than 10
        if (minutes < 10) {
          minutes = "0" + minutes;
        }

        var seconds = dt.getSeconds();
        
         // Add a leading zero to the seconds if it's less than 10
         if (seconds < 10) {
          seconds = "0" + seconds;
         }

        
         var formattedTime = hours + ":" + minutes + ":" + seconds;

         document.getElementById("datetime").innerHTML = formattedDate + " " + formattedTime;
       }

       // Update the clock every second
       setInterval(updateClock, 1000);
     </script>

    <div class="info">
      <div>
        <h3>Renter Information</h3>
        <p>Name: <%=in.getUserName() %></p>
        <p>Phone Number: <%=in.getUserPhone()%></p>
      </div>

      <div>
        <h3>Landlord Information</h3>
        <p>Name: <%=in.getLandName()%></p>
        <p>Phone Number: <%=in.getLandPhone()%></p>
      </div>

      <div>
        <h3>Booking Infomation</h3>
        <ul style="list-style: none;padding-left: 0px;">
          <li>Booking Date: <%=in.getBookingDate()%></li>
          <li>Check-In Date: <%=in.getCheckin()%></li>
          <li>Check-Out Date: <%=in.getCheckout()%></li>
        </ul>
      </div>

    </div>

    <table>
      <tr>
        <th>Info Title</th>
        <th>Address</th>
        <th>People</th>
        <th>Price</th>
      </tr>
      <tr>
        <td><%=in.getInfoTitle()%></td>
        <td><%=in.getInfoAddress()%></td>
        <td>1</td>
        <td><%=in.getInvoiceTotal()%></td>
      </tr>
    </table>

    <p><%=in.getInvoiceTotal()%></p>
  </div>
  <div class="js" style="margin-top:50px; margin-left: 45%;">
    <form action="ProfileController" method="post">
      <button  type="submit" name="return" style="font-family: 'Inter', sans-serif;;background-color: rgb(105, 95, 236); color: white; border: none; border-radius: 5px; margin: 0 auto; width:10%; height: 50px">RETURN</button>
    </form>
  </div>
</body> 

</html>

