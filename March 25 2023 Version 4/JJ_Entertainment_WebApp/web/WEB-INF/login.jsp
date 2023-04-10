<%-- 
    Document   : Login
    Created on : 10-Feb-2023, 7:48:12 PM
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/style.css">
        <title>Login</title>
    </head>
    <body>

<!--        <div class="banner">-->
            <div class="nav">
                <a href ="landing?page=landing">
                    <img src="css/pics/logo.png" class="logo">
                </a>
                <ul>
                    <li><a href="landing?page=landing">Home</a></li>
                    <li><a href="landing?page=gallery">Gallery</a></li>
                    <li><a href="landing?page=about">About</a></li>
                    <li><a href="landing?page=contact">Contact</a></li>
                    <li><a href="landing?page=login">Login</a></li>
                </ul>
            </div>


            <div class="centerBox">
                <div class="formDiv">
                
                <c:if test="${registerAcc eq false}">
                    <h1>Login</h1>
                    <form method = "post" action="login">
                        <input type="text" name="username" placeholder="Username..." class="field">

                        <br>
                        <input type="password" name="password" placeholder="Password..." >   
                        <br>
                        <input type="submit" name="action" value="Login" class="loginSub">
                    </form>
                    <br>
                    <p>New to Jayn Jeffries Entertainment? <a href="landing?page=login&amp;registerAcc=true"/>Sign up here!</p>
                </c:if>

                <c:if test="${registerAcc eq true}">
                    <h1>New Customer</h1>
                    <form method = "post" action="login">
<!--                        <label>Username: </label>-->
                        <input type="text" name="userReg" placeholder="Username" class="field" required>
                        <br>
<!--                        <label>Email: </label>-->
                        <input type="text" name="emailReg" placeholder="Email" class="field" required>
                        <br>
<!--                        <label>Password: </label>-->
                        <input type="password" name="passReg" placeholder="Password" class="field" required>
                        <br>
<!--                     <label>Name: </label>-->
                        <input type="text" name="firstReg" placeholder="First Name" class="nameField" required>
                        
                        
                        <input type="text" name="lastReg" placeholder="Last Name" class="nameField" required>
                        <br>
<!--                        <label>Phone</label>-->
                        <input type="text" name="phoneReg" placeholder="Phone Number" class="field" required>
                        <br>
                        <label>Preferred Contact: </label><br><select name="prefReg" >
                            <option value="0">Email</option>
                            <option value="1">Phone</option>
                        </select>
                        <br>
                        <input type="submit" name="action" value="Register" class="loginSub">
                    </form>
                    <form action="login" method="post">
                        <input type="submit" name="action" value="Cancel" class="cancelSub">
                    </form>
                </c:if>
            </div>
            </div>
            
    </body>
</html>
