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
        <title>Login</title>
    </head>
    <body>
          <h1>${message}</h1>
          <h1>${regMessage}</h1>
        <!--to do: manager basic user and make inactive/active, check hyperlinks, registration page, update-->
        
        <h1>JJ entertainment</h1>
        <form method = "post" action="login">
            <label>Email: </label><input type="text" name="email">
            
           <br>
           <label>Password: </label><input type="password" name="password">   
           <br>
           <input type="submit" value="login">
           <br>
           <input type="submit" value="logout">
        </form>
        
        <h2>Register</h2>
        <form method="post" action ="register">
            <!--login when registered-->
            <br><label>Email: </label>
            <input type="text" name="emailInput">
            <input type="hidden" name="email" value="${emailInput}">
            <br>
            
            <br><label>Password: </label>
            <input type="text" name="passwordInput">
            <input type="hidden" name="password" value="${passwordInput}">
            <br>
            
            <br>
            <label>First Name: </label>
            <input type="text" name="fNameInput">
            <input type="hidden" name="fName" value="${fNameInput}">
            <br>
            
            <br>
            <label>Last Name: </label>
            <input type="text" name="lNameInput"/>
            <input type="hidden" name="lName" value="${lNameInput}">
            <br>
            
            <br>
            
            <label>Phone Number: </label>
            <input type="text" name="phoneInput"/>
            <input type="hidden" name="phone" value="${phoneInput}">
            
            
        <input type ="submit" value="register">
        </form>
    </body>
</html>
