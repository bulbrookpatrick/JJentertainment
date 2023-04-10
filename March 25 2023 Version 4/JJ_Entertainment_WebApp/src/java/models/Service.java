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
public class Service {
    private int id;
    private Date start;
    private Date end;
    private int duration;
    private double price;
    private int participants;
    private int numPerformersAssigned;
    Category category;
    Event event;

    public Service() {
    }

    public Service(int id, Date start, Date end, int duration, double price, int participants, int numPerformersAssigned, Category category, Event event) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.price = price;
        this.participants = participants;
        this.numPerformersAssigned = numPerformersAssigned;
        this.category = category;
        this.event = event;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getNumPerformersAssigned() {
        return numPerformersAssigned;
    }

    public void setNumPerformersAssigned(int numPerformersAssigned) {
        this.numPerformersAssigned = numPerformersAssigned;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    
}
