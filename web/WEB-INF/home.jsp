<%-- 
    Document   : home
    Created on : 10-Feb-2023, 9:07:15 PM
    Author     : Patrick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <h1>${message}</h1>
        <h1>${RegisterMessage}</h1>
           <table border="1px">
            <tr>
                <th>username</th>
                <th>email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Prefer</th>
                <th></th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.username}</td>
                    <td>${client.email}</td>
                    
                    <td>${client.fName}</td>
                    <td>${client.lName}</td>
                    <td>${client.phone}</td>
                    <td>${client.prefer}</td>
<td>
    <form method="post" action="<c:url value='/home?email=${client.email}&amp;fName=${client.fName}&amp;lName=${client.lName}&amp;password=${client.password}&amp;phone=${client.phone}prefer=${client.prefer}&amp;action=delete'></c:url>">
        <input type="submit" value="remove">
    </form>
              
</td>
                </tr>
                
            </c:forEach>
            
    </body>
</html>
