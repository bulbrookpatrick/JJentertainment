

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
        <form action="filloutservice" method="post" style="display: inline; float: left">
            <table border="1px, solid">
                <tr>
                    <td>Service Start Date-Time</td>
                    <td>Service End Date-Time</td>
                    <td>Num. of Participants</td>
                </tr>
                <c:forEach items="${chosenCategory}" var="cat" varStatus="outerloop">
                    <c:set var="concat" value="chosenCategory${outerloop.getCount()}"></c:set>
                        <tr>
                            <td align="center" colspan="4">${cat.category.name}</td>
                    </tr>

                    <c:forEach items="${sessionScope[concat]}" var="chosen" varStatus="innerloop">
                        <tr>
                            <td><input class="startDateServ" type="datetime-local" name="${outerloop.getCount()}serviceStartDate${innerloop.count}"></td>
                            <td><input class="endDateServ" type="datetime-local" name="${outerloop.getCount()}serviceEndDate${innerloop.count}"></td>
                            <td><input type="number" min="1" value="1" name="${outerloop.getCount()}serviceNumParticipants${innerloop.count}" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                        </tr>


                    </c:forEach>

                </c:forEach>
            </table>
            <input type="submit" name="action" value="Cancel">
            <input type="submit" name="action" value="Continue">
        </form>
        <script>
            let limitStart = localStorage.getItem("eventStartValue");
            let limitEnd = localStorage.getItem("eventEndValue");
            limitStart = limitStart + "T00:00";
            limitEnd = limitEnd + "T23:59";
            console.log(limitStart);
            console.log(limitEnd);
            const starts = document.getElementsByClassName("startDateServ");
            const startsLength = starts.length;
            for(let i = 0; i < startsLength; i++) {
                starts[i].setAttribute("min", limitStart);
                starts[i].setAttribute("max", limitEnd);
            }
            
            const ends = document.getElementsByClassName("endDateServ");
            const endsLength = ends.length;
            for(let i = 0; i < endsLength; i++) {
                ends[i].setAttribute("min", limitStart);
                ends[i].setAttribute("max", limitEnd);
            }
        </script>
    </body>
</html>
