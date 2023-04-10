/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author kurtm
 */
public class Event {
    private int id;
    private Date start;
    private Date end;
    private String location;
    private int status;
    private double interest;
    private double reservation;
    private double price;
    private double total;
    User user;
    
    public Event() {
        
    }

    public Event(int id, Date start, Date end, String location, int status, double interest, double reservation, double price, double total, User user) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.location = location;
        this.status = status;
        this.interest = interest;
        this.reservation = reservation;
        this.price = price;
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getReservation() {
        return reservation;
    }

    public void setReservation(double reservation) {
        this.reservation = reservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
