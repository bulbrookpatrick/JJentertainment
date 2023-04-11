<%-- 
    Document   : about
    Created on : 14-Feb-2023, 6:20:39 PM
    Author     : Jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="/css/style.css">
            <script src="sidebar.js" defer></script>
</head>
<body>
<!--    <div class="banner">-->
        <div class="nav">
            <a href ="landing?page=landing">
            <img src="css/pics/logo.png" class="logo">
            </a>
            <ul>
                <li><a href="loggedcustomer?page=landing">Home</a></li>
                <li><a href="chooseevent">Booking</a></li>
                <li><a href="loggedcustomer?page=gallery">Gallery</a></li>
                <li><a href="loggedcustomer?page=about">About</a></li>
                <li><a href="loggedcustomer?page=contact">Contact</a></li>
                 <li><a id="profile" onclick="openNav()">${username}</a></li>

            </ul>
        
        </div>
        </div>
            <!--sidebar element-->
            <link rel="stylesheet" href="/css/sidebar.css">
    <script src="/css/sidebar.js" defer></script>
            <div id="mySidenav" class="sidenav">
            <!-- &times is the multiplication symbol -->
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <!--sidenav attribute-->
            <a href="/" method="POST" action="Logout">Logout</a>
          
          </div>
        <div class="aboutUsBox">
            
            <img src="css/pics/pic2.jpg" class="sidepicAbout">
            <div class="about2">
                <div class="aboutInnerBox">
                <br>
                <p class="about1">We strive to offer the best possible service at the most affordable prices <br> so you and your loved ones 
            have something extra to remember about your special day.</p>
        <br>
        
        <h2>Why Choose Us</h2>
        
        <p><img src="css/pics/checkmark2.png" class="checkmark">Cheapest service packages in the market!</p><br>
        <p><img src="css/pics/checkmark2.png" class="checkmark">Flexible scheduling for your convenience!</p><br>
        <p><img src="css/pics/checkmark2.png" class="checkmark">High standard for your quality customer service!</p><br>
        
        
        <p class="about1">We offer face-painting, balloon twisting, henna and glitter tattoos, mascots, and photography.</p>
        <br>
        <br>
        <p class="about1">For more information contact us by:</p>
        <br>
        <p class="about1">Phone: 403-111-1111</p><br><p>Or</p><br>
        <p class="about1">Email: JJEntertainment@hotmail.com / <a href="landing?page=contact">Contact Page</a></p><br><br>
        <p class="about1">Or follow us on: </p>
         <a href="https://www.facebook.com/jaynjeffries/"><img src="css/pics/fb.png" class="logos2about"/></a>
       
        <a href="https://www.instagram.com/jaynjeffriesentertainment/?hl=en"><img src="css/pics/insta.png" class="logos2about"/></a>
        
        <a href="https://www.youtube.com/channel/UCUFVq-QKDXB1AesZQsFzIPA"><img src="css/pics/yt.png" class="logos1about"/></a>
        <br>
        </div>
<!--        <a href="https://www.facebook.com/jaynjeffries/"><img src="css/pics/fb.png" class="logos2about"/></a>
       
        <a href="https://www.instagram.com/jaynjeffriesentertainment/?hl=en"><img src="css/pics/insta.png" class="logos2about"/></a>
        
        <a href="https://www.youtube.com/channel/UCUFVq-QKDXB1AesZQsFzIPA"><img src="css/pics/yt.png" class="logos1about"/></a>-->
      </div>
        </div>
           
        <!--</div>-->
        
    </body>
</html>
