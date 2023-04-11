<%-- 
    Document   : gallery
    Created on : 14-Feb-2023, 8:00:42 PM
    Author     : Jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/style.css">
        <title>Gallery</title>
    </head>
    <body>
        <div class="banner">
        <div class="nav">
            <a href ="loggedcustomer?page=landing">
                <img src="css/pics/logo.png" class="logo"></a>
            <ul>
                 <li><a href="loggedcustomer?page=landing">Home</a></li>
                <li><a href="chooseevent">Booking</a></li>
                <li><a href="loggedcustomer?page=gallery">Gallery</a></li>
                <li><a href="loggedcustomer?page=about">About</a></li>
                <li><a href="loggedcustomer?page=contact">Contact</a></li>
                <li><a id="profile" onclick="openNav()">${username}</a></li>
            </ul>
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
    
        </div>
           
    </div>
        
    </body>
</html>
