
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  
<head>
    <meta charset="utf-8">
    <title>Calendar</title>
    <meta name="viewport" content=
        "width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/calendar.css">
        
    <link rel="stylesheet" href=
"https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200">

</head>
  
<body>
    

        <!-- nav bar -->
        <!-- <div class="banner"> -->
            <div class="nav">
                <a href ="landing?page=landing">
                <img src="/css/pics/logo.png" class="logo">
                </a>
                <ul>
                <li><form action="eventapprove" method="get"> <input type="submit" name="action" value="Pending Events" class="navMan" style="border: none;"></form></li>
                <li><form action="inventory" method="get"><input type="submit" name="action" value="Active Events" class="navMan" style="border: none;"></form></li>
                <li><form action="manageperformers" method="get"><input type="submit" name="action" value="Manage Performers" class="navMan" style="border: none;"></form></li>
                <li><form action="manageeventservices" method="get"><input type="submit" name="action" value="Manage Event Services" class="navMan" style="border: none;"></form></li>
                <li><form action="loggedcustomer" method="post"><input type="submit" name="action" value="Logout" class="navMan" style="border: none;"></form></li>
            </ul>
        </div>
            <!-- </div> -->
            
    
            <div class="contentContainer">
    <div class="calendar-container">
        <header class="calendar-header">
            
            <div class="calendar-navigation">
                
                <!--add links to chevrons-->   
                <a href="/inventory?action=prevMonth&AMP;month=${month}&AMP;year=${year}" method="GET" style="margin-right: 1.5vw">
                <span id="calendar-prev" 
                    class="material-symbols-rounded chevrons">
                 
                    chevron_left
                    
                </span>
                </a>
                <p class="calendar-current-date">${month} ${year}</p>
                 <a href="/inventory?action=nextMonth&AMP;month=${month}&AMP;year=${year}" method="GET" style="margin-right: 1.5vw">
                <span id="calendar-next" 
                    class="material-symbols-rounded chevrons">
                    chevron_right
                </span>
                 </a>
            </div>
        
        </header>
        
        <div class="calendar-body">
            <div class="calendar-weekdays">
                <div>Sun</div>
                <div>Mon</div>
                <div>Tue</div>
                <div>Wed</div>
                <div>Thu</div>
                <div>Fri</div>
                <div>Sat</div>
            </div>
            <div class="calendar-dates">
                
                <c:forEach items="${dates}" var="date">
                   
                    <div class="grid-item <c:choose>
                             <c:when test="${date.getMonthValue() + 1 == intMonth}">
                                 "
                             </c:when>
                             <c:otherwise>
                                 otherMonth"
                             </c:otherwise>
                    </c:choose>><span class = "day"><c:out value="${date.getDayOfMonth()}"/> </span>
                         <c:forEach items="${events}" var="event">
                            
                             <c:if test = "${date.getDayOfMonth() == event.getStart().getDate()}">
                             <c:if test = "${(date.getMonthValue() - 1) == event.getStart().getMonth()}">
                       
                       
                                 <div class = "eventClass">
                                     <p>${event.event.location}</p>
                                     <p>${event.category.getName()}</p>
                                     
                                     <p></p>
                                     <!--start time-->
                                     <c:choose>
                                         <c:when test = "${event.start.getMinutes() <= 9}">
                                             <span>${(event.start.getHours())}:0${event.start.getMinutes()}<span> - </span></span>
                                             
                                             
                                         </c:when>
                                            
                                             <c:otherwise>
                                                 <span>${(event.start.getHours())}:${event.start.getMinutes()}<span> - </span></span>
                                             </c:otherwise>
                                     </c:choose>
                                    
                                                 <!--end time-->
                                    <c:choose>
                                         <c:when test = "${event.end.getMinutes() <= 9}">
                                             <span>${(event.end.getHours())}:0${event.end.getMinutes()}</span></br>
                                             
                                             
                                         </c:when>
                                            
                                             <c:otherwise>
                                                 <span>${(event.end.getHours())}:${event.end.getMinutes()}</span></br>
                                             </c:otherwise>
                                     </c:choose>
                                         
                                     <br>
                                 </div>
                             </c:if>
                             </c:if>
                           </c:forEach>
                            
                            
                        
                        
                    </div>
                        </c:forEach>
                    
               
                      <!--index into the events array using the date-->
                        
                    

                    
              
            
        </div>
    </div>
</body>
  
</html>