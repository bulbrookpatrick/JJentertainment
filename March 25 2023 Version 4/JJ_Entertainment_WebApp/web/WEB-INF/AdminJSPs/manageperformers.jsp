<%-- 
    Document   : manageperformers
    Created on : 23-Mar-2023, 4:14:20 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Performers</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
        
            <div class="nav">
                <a href ="loggedadmin">
            <img src="css/pics/logo.png" class="logo">
            </a>
<!--                <img src="css/pics/logo.png" class="manlogo">-->
            <ul>
                <li><form action="eventapprove" method="get"> <input type="submit" name="action" value="Pending Events" class="navMan" ></form></li>
                <li><form action="inventory" method="get"><input type="submit" name="action" value="Active Events" class="navMan"></form></li>
                <li><form action="manageperformers" method="get"><input type="submit" name="action" value="Manage Performers" class="navMan"></form></li>
                <li><form action="manageeventservices" method="get"><input type="submit" name="action" value="Manage Event Services" class="navMan"></form></li>
                <li><form action="loggedcustomer" method="post"><input type="submit" name="action" value="Logout" class="navMan"></form></li>
            </ul>
        
        </div>
            <div class="manFormDiv">
        
        <h1>Manage Performers</h1>
        Message: ${messageManagePerformers}
        <table border="1px, solid">
            <tr style="font-weight: bold">
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Specialties</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${performers}" var="performer" varStatus="loop">
                <c:set var="concat" value="performerSpecialty${loop.getCount()}"></c:set>

                    <tr>
                    <td>${performer.username}</td>
                    <td>${performer.email}</td>
                    <td>${performer.password}</td>
                    <td>${performer.fname}</td>
                    <td>${performer.lname}</td>
                    <td>${performer.phoneNumber}</td>
                    <td><select>
                            <c:forEach items="${requestScope[concat]}" var="specialty">
                                <option>${specialty.category.name}</option>
                            </c:forEach>
                        </select></td>
                    <td><a href="manageperformers?action=edit&amp;performerSel=${performer.id}"/>Edit</td>
                    <td><a href="manageperformers?action=delete&amp;performerSel=${performer.id}"/>Delete</td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${editing eq true}">
            <h2>Edit Performer</h2>
            <form action="manageperformers" method="post">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="perUNameEdit" value="${perUName}" class="field" required></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="perEmailEdit" value="${perEmail}" class="field" required></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="perPassEdit" value="${perPass}" class="field" required></td>                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="perFNameEdit" value="${perFName}" class="field" required></td>                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="perLNameEdit" value="${perLName}" class="field" required></td>                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type="text" name="perPhoneEdit" value="${perPhone}" class="field" required></td>                    </tr>
                    <tr>
                        <td>Specialties:</td>
                        <td><select><c:forEach items="${perPSEdit}" var="specialty">
                                    <option>${specialty.category.name}</option>
                                </c:forEach></select></td>
                        <td><input type="submit" name="action" value="Manage Specialties" class="mansubsmall">
                        </td>
                    </tr>
                </table>
                <input type="submit" name="action" value="Save" class="save">
            </form>


            <form action="manageperformers" method="post">
                <input type="submit" name="action" value="Cancel" class="can">
            </form>
        </c:if>

        <c:if test="${manageSpecialties eq true}">
            <br>
            <h2>Manage ${performerUsername}'s Specialties</h2><br>
            Message: ${messageManageSpecialty}
            <br>
            <form action="manageperformers" method="post">
                <select name="manSpecAddThis">
                    <c:forEach items="${manageSpecialtyAdd}" var="manSpecAdd">
                        <option value="${manSpecAdd.id}">${manSpecAdd.name}</option>
                    </c:forEach>
                </select>

                <input type="submit" name="action" value="Add Specialty" class="mansub2">

            </form><br>

            <table border="1px, solid">
                <tr style="font-weight: bold">
                    <td>Specialty</td>
                    <td></td>
                </tr>

                <c:forEach items="${manageSpecialtyOfPerformer}" var="manSpec">
                    <tr>
                        <td>${manSpec.category.name}</td>
                        <td><a href="manageperformers?action=deleteSpec&amp;manSpecCat=${manSpec.category.id}&amp;manSpecPer=${manSpec.performer.id}"/>Delete</td>
                    </tr>
                </c:forEach>
            </table>
            <form action="manageperformers" method="post">
                <input type="submit" name="action" value="Go Back" class="mansub3">
            </form>
        </c:if>

        <br><br><h2>Add Performer</h2>
        <form action="manageperformers" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="perUNameAdd" class="field" placeholder="Employee username..." required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="perEmailAdd" class="field" placeholder="Employee email..." required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="perPassAdd" class="field" placeholder="Employee password..." required></td>                    </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="perFNameAdd" class="field" placeholder="Employee first name..." required></td>                    </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="perLNameAdd" class="field" placeholder="Employee last name..." required></td>                    </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="perPhoneAdd" class="field" placeholder="Employee phone number..." required></td>                    </tr>
                <tr>
                    <td class="special">Specialties</td>
                    
                </tr>
                <c:forEach items="${addSpecialties}" var="addSpecialty" varStatus="looper">
                    <tr><td class="specialties"><input type="checkbox" name="addingHere${looper.getCount()}" value="${addSpecialty.name}" ><label>${addSpecialty.name}</label></td></tr>
                        </c:forEach>
            </table>
            <input type="submit" name="action" value="Add Performer" class="mansub">
        </form>
        </div>
        
    </body>
</html>
