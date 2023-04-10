<%-- 
    Document   : Login
    Created on : 10-Feb-2023, 7:48:12 PM
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/style.css">
        <title>Login</title>
    </head>
    <body>
        
        <div class="banner">
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
                <li><a href="loggedcustomer?page=profile">${username}</a></li>
            </ul>
            </div>
        
        
        <div class="centerBox">
          <h1>${message}</h1>
        
        <h1>Hello ${username}</h1>
       <form action="loggedcustomer" method="post">
            <input type="submit" name="action" value="Logout">
        </form>
       <br>
 
    </body>
</html>
