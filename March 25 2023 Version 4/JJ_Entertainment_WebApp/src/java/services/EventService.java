/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EventDB;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import models.User;
import models.Event;

/**
 *
 * @author kurtm
 */
public class EventService {

    public Double getInterest(Double eventPrice) {
        double interestRate = 0.10; // 10 percent
        double interest = interestRate * eventPrice;
         double rounded = (double) Math.round(interest * 100) / 100;
        return rounded;
    }

    public Double getResCost(Double eventPrice_Interest) {
        double reservationRate = 0.10; // 10 percent of service prices + interest
        double reservation = reservationRate * eventPrice_Interest;
         double rounded = (double) Math.round(reservation * 100) / 100;
        return rounded;
    }

    public Event add(String startDate, String endDate, String venue, int status, Double interest, Double resCost, Double eventPrice, Double total, User user) throws SQLException {
        EventDB eventdb = new EventDB();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lds = LocalDate.parse(startDate, formatter);
        Date start = java.sql.Date.valueOf(lds);
        LocalDate lde = LocalDate.parse(endDate, formatter);
        Date end = java.sql.Date.valueOf(lde);

        Event event = new Event();
        event.setUser(user);
        event.setStart(start);
        event.setEnd(end);
        event.setInterest(interest);
        event.setLocation(venue);
        event.setPrice(eventPrice);
        event.setTotal(total);
        event.setReservation(resCost);
        event.setStatus(status);
        Event compEvent = eventdb.add(event);
        return compEvent;
    }

    public List<Event> getAllPending() throws SQLException {
        EventDB eventdb = new EventDB();
        List<Event> events = eventdb.getAllPending();
        return events;
    }

    public void activate(int eventSel) throws SQLException {
        EventDB eventdb = new EventDB();
        eventdb.activate(eventSel);
    }
    
    public void refund(int eventSel) throws SQLException {
        EventDB eventdb = new EventDB();
        eventdb.refund(eventSel);
    }
    
    public void finish(int eventSel) throws SQLException {
        EventDB eventdb = new EventDB();
        eventdb.finish(eventSel);
    }

    public Event get(int eventSel) throws SQLException {
        EventDB eventdb = new EventDB();
        Event event = eventdb.get(eventSel);
        return event;
    }

}
