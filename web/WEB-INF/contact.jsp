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
        <title>Contact Page</title>
    </head>
    <body>
    <div class="container">
            <div class="contact">
                <form class="contactform">
                    <h1>Contact Us</h1>
                    <p>Please fill out this form if you have any questions, concerns, or comments.</p><br>
                    <br>
                    <p>Full Name</p>
                    <input type="text" id="name" pattern="[A-Za-z]" required><br>
                    <p>E-Mail</p>
                    <input type="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required><br>
                    <p>Message</p>
                    <textarea id="message" rows="5" ></textarea><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>
