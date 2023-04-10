<%-- 
    Document   : eventapproval
    Created on : 14-Mar-2023, 12:02:47 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Events</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
<!--        <div class="banner">-->
            <div class="nav">
            
                <a href ="loggedadmin">
            <img src="css/pics/logo.png" class="logo">
            </a>
            <ul>
                <li><form action="eventapprove" method="get"> <input type="submit" name="action" value="Pending Events" class="navMan" ></form></li>
                <li><form action="inventory" method="get"><input type="submit" name="action" value="Active Events" class="navMan"></form></li>
                <li><form action="manageperformers" method="get"><input type="submit" name="action" value="Manage Performers" class="navMan"></form></li>
                <li><form action="manageeventservices" method="get"><input type="submit" name="action" value="Manage Event Services" class="navMan"></form></li>
                <li><form action="loggedcustomer" method="post"><input type="submit" name="action" value="Logout" class="navMan"></form></li>
            </ul>
        
        </div>
            <div class="manFormDiv">
        
        <h1>Pending Events</h1>
        <table border="1px, solid">
            <tr style="font-weight: bold">
                <th>Customer</th>
                <th>Start (Year-Month-Day)</th>
                <th>End (Year-Month-Day)</th>
                <th>View</th>
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
        <br>
        <c:if test="${view eq false}">
        <h1>Approve Event</h1>
        <h3>Customer: ${eventSelCustomer}</h3> 
        <h3>Location: ${eventSelLocation}</h3> 
        <h3>Total: $${eventSelTotal}</h3> 
        <h3>Interest: $${eventSelInterest}</h3> 
        <h3>Reservation Cost(Paid): $${eventSelResCost}</h3>
        <h3>Services Only: $${eventSelService}</h3>
        <form action="eventapprove" method="post" style="display: inline; float: left">
            <table border="1px, solid">
                <tr style="font-weight: bold">
                    <th>Category</th>
                    <th>Start (Year-Month-Day Hour:Minute:Second.Millisecond)</th>
                    <th>End (Year-Month-Day Hour:Minute:Second.Millisecond)</th>
                    <th>#Participants</th>
                    <th>#Performers</th>
                    <th>Duration</th>
                    <th>Price</th>

                </tr>
                <c:forEach items="${eventSelected}" var="serv" varStatus="loop">
                    <tr>
                        <td>${serv.category.name}</td>
                        <td>${serv.start}</td>
                        <td>${serv.end}</td>
                        <td>${serv.participants} participants</td>
                        <td>${serv.numPerformersAssigned} performers</td>
                        <td>${serv.duration} hours</td>
                        <td>$${serv.price}</td>

                    </tr>

                </c:forEach>
            </table>
            <input type="submit" name="action" value="Cancel" class="approvalCan">
            <input type="submit" name="action" value="Refund" class="approvalRef">
            <input type="submit" name="action" value="Approve" class="approvalApp">
        
        </c:if>
            </div>
        
    </body>
</html>
