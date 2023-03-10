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
public class Service {
    private int id;
    private Date start;
    private Date end;
    private int duration;
    private double cost;
    private int participants;
    private int performers;

    public Service() {
    }

    public Service(int id, Date start, Date end, int duration, double cost, int participants, int performers) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.cost = cost;
        this.participants = participants;
        this.performers = performers;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getPerformers() {
        return performers;
    }

    public void setPerformers(int performers) {
        this.performers = performers;
    }
    
    
    
}
