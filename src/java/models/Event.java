/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Patrick
 */
public class Event {
    private int id;
    // use date to perform opertaions on the date
    private Date start;
    private Date end;
    private String location;
    private int status;
    private double interest;
    private double cost;

    public Event() {
    }
 public Event(Date start, Date end, String location, int status, double interest, double cost) {
        id = 0;
        this.start = start;
        this.end = end;
        this.location = location;
        this.status = status;
        this.interest = interest;
        this.cost = cost;
    }
    public Event(int id, Date start, Date end, String location, int status, double interest, double cost) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.location = location;
        this.status = status;
        this.interest = interest;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}
