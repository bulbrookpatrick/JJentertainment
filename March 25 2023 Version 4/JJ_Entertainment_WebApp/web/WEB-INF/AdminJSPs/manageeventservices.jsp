<%-- 
    Document   : managecategories
    Created on : 23-Mar-2023, 4:14:37 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Event Services</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
        
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
<!--        <form action="manageeventservices" method="post">
            <input type="submit" name="action" value="Back">
        </form>-->

        <div class="manFormDiv">
        <h1>Manage Event Services</h1>
        <br>
        ${message}
        
            <table border="1px, solid">
                <tr style="font-weight: bold">
                    <th>Name</th>
                    <th>Short Description</th>
                    <th>Rate</th>
                    <th>Minimum Number of Participants</th>
                    <th>Minimum Number of Performers</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${services}" var="service">
                    <tr>

                        <td>${service.name}</td>
                        <td>${service.desc}</td>
                        <td>$${service.rate}</td>
                        <td>${service.minNumPar}</td>
                        <td>${service.minNumPer}</td>
                        <td><a href="manageeventservices?action=edit&amp;categorySel=${service.id}"/>Edit</td>
                        <td><a href="manageeventservices?action=delete&amp;categorySel=${service.id}"/>Delete</td>
                    </tr>

                </c:forEach>
            </table>
        <br>
            
        <c:if test="${editing eq false}">
            <h2>Add Event Service</h2>
            <form action="manageeventservices" method="post">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="catNameAdd" placeholder="Event name..." class="field" required></td>
                    </tr>
                    <tr>
                        <td>Short Description:</td>
                        <td><input type="text" name="catDescAdd" class="field" placeholder="Event Description..." required></td>
                    </tr>
                    <tr>
                        <td>Rate:</td>
                        <td><input type="number" step="0.01" value="1" min="1" name="catRateAdd" required></td>
                    </tr>
                    <tr>
                        <td>Minimum Number Participants:</td>
                        <td><input type="number" min="1" value="1" name="catMinNumParAdd" required onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                    </tr>
                    <tr>
                        <td>Minimum Number Performers:</td>
                        <td><input type="number" min="1" value="1" name="catMinNumPerAdd" required onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                    </tr>
                </table>
                <input type="submit" name="action" value="Add Event Service" class="mansub">
            </form>
        </c:if>


        <c:if test="${editing eq true}">
            <h2>Edit Event Service</h2>
            <form action="manageeventservices" method="post">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="catNameEdit" value="${catName}" class="field" required></td>
                    </tr>
                    <tr>
                        <td>Short Description:</td>
                        <td><input type="text" name="catDescEdit" value="${catDesc}" class="field" required></td>
                    </tr>
                    <tr>
                        <td>Rate:</td>
                        <td><input type="number" step="0.01" min="1" name="catRateEdit" value="${catRate}" required></td>
                    </tr>
                    <tr>
                        <td>Minimum Number Participants:</td>
                        <td><input type="number" min="1" name="catMinNumParEdit" value="${catMinNumPar}" required onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                    </tr>
                    <tr>
                        <td>Minimum Number Performers:</td>
                        <td><input type="number" min="1" name="catMinNumPerEdit" value="${catMinNumPer}" required onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))"></td>
                    </tr>
                </table>
                <input type="submit" name="action" value="Save" class="save">
            </form>


            <form action="manageeventservices" method="post">
                <input type="submit" name="action" value="Cancel" class="can">
            </form>
        </c:if>
            </div>
        </div>
    </body>
</html>
