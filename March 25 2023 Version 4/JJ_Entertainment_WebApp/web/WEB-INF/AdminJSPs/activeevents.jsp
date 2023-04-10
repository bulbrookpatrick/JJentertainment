<%-- 
    Document   : activeevents
    Created on : 21-Mar-2023, 3:11:08 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active Events</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
        
        <div class="ESDiv">
        <h1>Active Events</h1>
        <table border="1px, solid">
            <tr style="font-weight: bold">
                <td>Customer</td>
                <td>Start</td>
                <td>End</td>
                <td>View</td>
            </tr>
            <c:forEach items="${pendingEvent}" var="pending" varStatus="loop">
                <tr>
                    <td>${pending.user.username}</td>
                    <td>${pending.start}</td>
                    <td>${pending.end}</td>
                    <td><a href="eventapprove?action=view&amp;pendEventSel=${pending.id}"/>View</td>
                </tr>

            </c:forEach>
        </table>
        </div>
    </body>
</html>
