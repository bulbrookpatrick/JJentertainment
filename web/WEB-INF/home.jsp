<%-- 
    Document   : home
    Created on : 10-Feb-2023, 9:07:15 PM
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        
           <table border="1px">
            <tr>
                <th>Email</th>
                <th>Active</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Role</th>
                <th></th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.clientname}</td>
                    <td>${client.email}</td>
                    <td>${client.password}</td>
                    <td>${client.fName}</td>
                    <td>${client.lName}</td>
                    <td>${client.phone}</td>
                    <td>${client.prefer}</td>
<td>
    <form method="post" action="<c:url value='/client?email=${client.email}&amp;fName=${client.fName}&amp;lName=${client.lName}&amp;password=${client.password}&amp;phone=${client.phone}prefer=${client.prefer}&amp;action=delete'></c:url>">
        <input type="submit" value="remove">
    </form>
</td>
                </tr>
                
            </c:forEach>
            
    </body>
</html>
