<%-- 
    Document   : contact
    Created on : 13-Feb-2023, 12:02:29 PM
    Author     : RT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="/css/style.css">
        <title>Contact Page</title>
    </head>
    <body>
        
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
                 <link rel="stylesheet" href="/css/sidebar.css">
    <script src="/css/sidebar.js" defer></script>
    <div
            <div id="mySidenav" class="sidenav">
            <!-- &times is the multiplication symbol -->
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <!--sidenav attribute-->
            <a href="/" method="POST" action="Logout">Logout</a>
        </div>
        <div class="centerBox">
<!--    <img src="css/pics/pic2.jpg" class="sidepic">
     <img src="css/pics/pic2.jpg" class="sidepic-right">-->
            <div class="formDiv">
                <form action="https://formsubmit.co/jonathan_Chea@hotmail.com" method="POST" />
                    <h1>Contact Us</h1>
                    <p>Please fill out this form if you have any questions, concerns, or comments.</p><br>
                    <br>
<!--                    <p>Full Name</p>
                    <input type="text" id="name" required><br>-->
                   
<!--                    <input type="email" name="email" placeholder="Email Address">-->
                    <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="Email..." required>
                    <br><br>
                    
                    <textarea type="text" name="message" rows="5" placeholder="Type your message here..." required></textarea><br>
<!--                    <textarea type="text" name="message" rows="5" placeholder="How did you hear about us? Your feedback is greatly appreciated!"></textarea>-->
                    <input type="hidden" name="_autoresponse" value="We have received your message and will get back to you! Thank you!">
                    <input type="submit" value="Submit" class="submit2">
                    
             <br>
             <br>
            <h2> Or call us at </h2>
            <!--            provide real number-->
            <p>403-222-2222</p>
                </form>
            </div>


        
        </div>
<!--         <div class="footer">
        <p class="foot">Jayn Jeffries Entertainment LTD. 2023</p>
         <a href="https://www.facebook.com/jaynjeffries/"><img src="css/pics/fb.png" class="logos2"/></a>
       
        <a href="https://www.instagram.com/jaynjeffriesentertainment/?hl=en"><img src="css/pics/insta.png" class="logos2"/></a>
        
        <a href="https://www.youtube.com/channel/UCUFVq-QKDXB1AesZQsFzIPA"><img src="css/pics/yt.png" class="logos1"/></a>
    </div>-->
    </body>
</html>
