

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Event Planner</title>
    </head>
    <body>
        <h1>Hello Customer ${username}</h1>
        <p>${message}</p>
        <form id="form" action="chooseevent" method="post" style="display: inline; float: left">
            <p>Event Start Date: <input type="date" id="eventStartDate" name="eventStartDate"/> &nbsp;&nbsp;&nbsp;Event End Date: <input type="date" id="eventEndDate" name="eventEndDate"/></p>
            <p>Event Venue: <input type="text" name="eventVenue"/></p>
            <table border="1px, solid">
                <tr style="font-weight: bold">
                    <td>Event Service</td>
                    <td>Short Description</td>
                    <td>Quantity</td>
                </tr>
                <c:forEach items="${category}" var="cat" varStatus="loop">
                    <tr>
                        <td>${cat.name}</td>
                        <td>${cat.desc}</td>
                        <td><input type="number" min="0" max="99" value="0" name="quantityId${loop.count}" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"/></td>
                    </tr>

                </c:forEach>
            </table>
            <input type="submit" name="action" value="Cancel" >
            <input type="submit" name="action" value="Continue">
        </form>
        <script>
            let todayDate = new Date();
            todayDate.setDate(todayDate.getDate() + 1);
            let year = todayDate.getUTCFullYear();
            let month = todayDate.getMonth() + 1;
            let day = todayDate.getDate();
            if (month < 9) {
                month = "0" + month;
            }

            if (day < 10) {
                day = "0" + day;
            }
            let minDate = year + "-" + month + "-" + day;
            console.log(minDate);
            document.getElementById("eventStartDate").setAttribute("min", minDate);
            document.getElementById("eventEndDate").setAttribute("min", minDate);</script>
        <script>
            const form = document.getElementById("form");
            const start = document.getElementById("eventStartDate");
            const end = document.getElementById("eventEndDate");

            form.addEventListener("submit", function(e) {
                const startValue = start.value;
                const endValue = end.value;
                localStorage.setItem("eventStartValue", startValue);
                localStorage.setItem("eventEndValue", endValue);
            })
        </script>
    </body>
</html>
