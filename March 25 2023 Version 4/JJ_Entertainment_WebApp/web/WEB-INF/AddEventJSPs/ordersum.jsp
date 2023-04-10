
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Planner</title>
    </head>
    <body>
        <table border="1px, solid">
            <tr>
                <td>Event Service</td>
                <td>Event Price</td>
            </tr>
            <c:forEach items="${summCat}" var="sumCat">
                <tr>
                    <td>${sumCat.catName}</td>
                    <td>$${sumCat.totalPrice}</td>
                </tr>

            </c:forEach>
        </table>
        <h1>Total Event Price is: $${eventSerPriceInterest}</h1>
        <h1>Total Reservation Cost is: $${eventResCost}</h1>
        
        <form action="ordersummary" method="post" style="display: inline; float: left">
            <input type="submit" name="action" value="Cancel">
            <input type="submit" name="action" value="Continue">
        </form>

    </body>
</html>
