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
        <!--to do: manager basic user and make inactive/active, check hyperlinks, registration page, update-->
        
        
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
        <form method="post" action ="user?action=add">
            <label>Email: </label><input type="email" name="emailInput">
             <input type="hidden" name="email" value="<c:out value='${emailInput}'></c:out>">
                    
            <br><label>Password: </label>
            <input type="password" value="${passwordInput}" name="password">
            <input type="hidden" name="fName" value="${passwordInput}">
            <br>
            
            <label>First Name: </label>
            <input type="text" value ="${fName}" name="fName">
            <input type="hidden" name="fName" value="${fNameInput}">
            
            <br>
            <label>Last Name: </label>
            <input type="text" name="lNameInput"/>
            <input type="hidden" name="lName" value="${lNameInput}">
            <br>
            
            
            
            <!--message when user is added-->
        <input type ="submit" value="register">
        </form>
    </body>
</html>
