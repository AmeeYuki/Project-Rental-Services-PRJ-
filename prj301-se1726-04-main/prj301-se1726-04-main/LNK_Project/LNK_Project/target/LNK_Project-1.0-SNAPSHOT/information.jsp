<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/information.css">
  <title>Document</title>
</head>


<body>

  <!-- partial:index.partial.html -->
  <header class="header">
    <a href="#"><img src="image1.png" class="logo" alt=""></a>
    <div>
      <ul class="navbar">
        <li><a href="#home">Home</a></li>
        <li><a href="#booking">Booking</a></li>
        <li><a href="#contact">Contact Us</a></li>
        <li><a href="#user">Login</i></a></li>
      </ul>
    </div>
  </header>

  <div id="container">
    <div class="title">
      <h1>Information</h1>
    </div>



    <form action="#" method="post" id="contact_form">

      <div class="box">
        <label for="title"></label>
        <input type="text" placeholder="Title" name="title" required>
      </div>

      <div class="box">
        <label for="locate"></label>
        <input type="text" placeholder="Locate" name="title" required>
      </div>


      <div class="box">
        <label for="type"></label>
        <select placeholder="Type" name="type" required>
          <option disabled hidden selected>Type</option>
          <option>Hotel</option>
          <option>Homestay</option>
          <option>Tour</option>
        </select>
      </div>

      <div class="box">
        <label for="typeroom"></label>
        <select placeholder="Type of room" name="typeroom" required>
          <option disabled hidden selected>Type of room</option>
          <option>Single Bed & 1 Toilets</option>
          <option>Double Beds & 1 Toilets</option>
          <option>2 rooms & 2 Toilets</option>
          <option>3 rooms & 2 Toilets</option>
          <option>4 rooms & 3 Toilets</option>
          <option>Khác</option>
        </select>
      </div>

      <div class="box">
        <label for="peopleroom"></label>
        <input type="text" placeholder="Maximum people in room" name="peopleroom" required>
      </div>

      <div class="box">
        <label for="area"></label>
        <input type="number" placeholder="Area" name="area" required>
      </div>

      

      <div class="box">
        <label for="price"></label>
        <input type="number" placeholder="price" name="price" required>
      </div>
      <div class="box">
        <label for="imageInput">Chọn file ảnh</label>
        <input  type="file" id="imageInput">
        
      </div>

      <div class="box">
        <label for="decripsion"></label>
        <textarea cols="30" rows="5" name="decripsion" placeholder="decripsion" required></textarea>
      </div>
      <div class="submit">
        <input type="submit" value="save" id="form_button" />
      </div>
    </form><!-- // End form -->
  </div><!-- // End #container -->
</body>

</html>