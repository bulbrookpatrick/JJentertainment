/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.EventDB;
import java.util.Date;
import java.util.List;
import models.Event;

/**
 *
 * @author Patrick
 */
public class EventService {
       public List<Event> getAll() throws Exception {
        EventDB EventDB = new EventDB();
        List<Event> events = EventDB.getAll();
        return events;
    }
    
    public Event get(int id) throws Exception {
        EventDB eventDB = new EventDB();
        Event event = eventDB.get(id);
        return event;
    }
    
    public void insert(int id, Date start, Date end, String location, int status, double interest, double cost) throws Exception {
        Event event = new Event(id, start, end, location, status, interest, cost);
        EventDB eventDB = new EventDB();
        eventDB.insert(event);
    }
    
    public void update(int id, Date start, Date end, String location, int status, double interest, double cost) throws Exception {
        Event event = new Event(id, start, end, location, status, interest, cost);
        EventDB eventDB = new EventDB();
        eventDB.update(event);
    }
    

    public void delete(int id) throws Exception {
        Event event = new Event();
        event.setId(id);
        EventDB eventDB = new EventDB();
        eventDB.delete(event);
    }
    
}
