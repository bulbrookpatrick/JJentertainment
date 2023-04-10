<%-- 
    Document   : mainpage
    Created on : 21-Mar-2023, 6:50:21 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
        <div class="banner">
            <div class="nav">
            <a href ="loggedadmin">
            <img src="css/pics/logo.png" class="logo">
            </a>
            <ul>
                <li><form action="eventapprove" method="get"> <input type="submit" name="action" value="Pending Events" class="navMan" ></form></li>
                <li><form action="inventory" method="get"><input type="submit" name="action" value="Active Events" class="navMan"></form></li>
                <li><form action="manageperformers" method="get"><input type="submit" name="action" value="Manage Performers" class="navMan"></form></li>
                <li><form action="manageeventservices" method="get"><input type="submit" name="action" value="Manage Event Services" class="navMan"></form></li>
                <li><form action="loggedcustomer" method="post"><input type="submit" name="action" value="Logout" class="navMan"></form></li>
            </ul>
        
        </div>
             <div class="welcome">Welcome ${username}</div>
<!--            <div class="managerMain">
        <h1>Hello ${username}</h1>
                <h1 class="managerHead">Welcome Jayn</h1>
        <form action="eventapprove" method="get">
            <input type="submit" name="action" value="Pending Events" class="managerField">
        </form>
        <form action="inventory" method="get">
            <input type="submit" name="action" value="Active Events" class="managerField">
        </form>
         <form action="manageperformers" method="get">
            <input type="submit" name="action" value="Manage Performers" class="managerField">
        </form>
         <form action="manageeventservices" method="get">
             <input type="submit" name="action" value="Manage Event Services" class="managerField">
        </form>
        <form action="loggedcustomer" method="post">
            <input type="submit" name="action" value="Logout" class="managerField">
        </form>
        </div>-->
        </div>
    </div>
    </body>
</html>
