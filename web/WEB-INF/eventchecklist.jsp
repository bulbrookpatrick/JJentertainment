<%-- 
    Document   : eventchecklist
    Created on : 13-Feb-2023, 11:53:34 AM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Planner</title>
    </head>
    <body>
        <form action="eventchecklist" method="post" style="display: inline; float: left">
            <table border="1px, solid">
                <tr style="font-weight: bold">
                    <td></td>
                    <td>Event Service</td>
                    <td>Short Description</td>
                    <td>Quantity</td>
                </tr>
                <c:forEach items="${category}" var="cat">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${cat.categoryName}</td>
                        <td>${cat.categoryDescription}</td>
                        <td><input type="number" min="0" max="99" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
