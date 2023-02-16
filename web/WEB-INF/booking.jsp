<%-- 
    Document   : booking
    Created on : 14-Feb-2023, 5:39:43 PM
    Author     : RT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entertainment Booking Form</title>
    </head>
    <body>
<div class="booking">
    <form action="event?action=add" method="POST">
        <div class="header">
            <h1>Entertainment Booking Form</h1>
        </div>
        <h1>${message}</h1>
<!--        <h3>Client Information</h3>
        <div class="client">
            <label>Name</label>
            <input type="text" name="firstname" placeholder="First Name" value="">
            <input type="text" name="lastname" placeholder="Last Name" value="">
            <br>

            <label>Contact Email</label>
            <input type="text" name="email" placeholder="abcsmith@email.com" value=""><br>

            <label>Contact Number</label>
            <input type="phone" name="phone" placeholder="4035551111" value="">
        </div>-->
        <h3>Event Information</h3>
        <div class="datetime">
            <p>Date of Event</p>
            <input type="date" name="date" value="eventdate">
            <p>Time of Event</p>
            <label>Start Time</label>
            <input type="time" name="start" value="start"><br>
            <label>End Time</label>
            <input type="time" name="end" value="end"><br>
        </div>
        <div class="addDay">
            <h4>Booking for Multiple Days?</h4>
            <div id="added"></div>
            <input type="button" value="Add Day" onclick="addDay()">
            <input type="button" id="removebutton" value="Remove Day" onclick="removeLast()">
            <br>
        </div>
        <div class="service">
            <h4>Select Services Needed</h4><br>
            <input type="checkbox" id="balloons" name="balloons">
            <label for="balloons">Balloon Tying</label><br>
            <input type="checkbox" id="mascot" name="mascot">
            <label for="mascot">Mascot</label><br>
            <input type="checkbox" id="photography" name="photography">
            <label for="photography">Photography</label><br>
            <input type="checkbox" id="photobooth" name="photobooth">
            <label for="photobooth">Photo Booth</label><br>
            <input type="checkbox" id="facepainting" name="facepainting">
            <label for="facepainting">Face Painting</label><br>
            <input type="checkbox" id="henna" name="henna">
            <label for="henna">Henna</label><br>
        </div>


        <div class="venue">
            <p>Venue Address</p>
            <input type="text" name="address" placeholder="Street address"><br>
<!--            <input type="text" name="address2" placeholder="Street address line 2">-->
            <input type="text" name="city" placeholder="City"/>
            <input type="text" name="province" placeholder="Province"/>

            <p>Venue Capacity</p>
            <input type="number" name="capacity"/><br>

            <label>Venue Type</label><br>
            <input type="radio" id="indoor" name="venue_type" value="Indoor">
            <label for="indoor">Indoor</label><br>
            <input type="radio" id="outdoor" name="venue_type" value="Outdoor">
            <label for="outdoor">Outdoor</label><br>
        </div>

        <input type="submit" value="submit">
    </form>
</div>
</body>
<script>
    function addDay() {

        const div = document.createElement("div");

        div.innerHTML +=
            "<h4>Date of Event</h4>\n" +
            "            <input type=\"date\" name=\"date\"><br>\n" +
            "            <p>Time of Event</p><br>\n" +
            "            <label>Start Time</label>\n" +
            "            <input type=\"time\" name=\"start\"/><br>\n" +
            "            <label>End Time</label>\n" +
            "            <input type=\"time\" name=\"end\">"

        document.getElementById("added").appendChild(div);

    }


    function removeLast() {
        const addedDay = document.getElementById("added");
        const node = addedDay.lastChild;

        addedDay.removeChild(node);
    }
</script>
</html>
