/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Event;
// event creation established
/**
 *
 * @author Patrick
 */
public class eventDB {
      public List<Event> getAll() throws Exception {
        List<Event> events = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from event";
        
        try {
           ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                String location = rs.getString(4);
                int status = rs.getInt(5);
                double interest = rs.getDouble(6);
                double cost = rs.getDouble(7);
                Event event= new Event(id, start, end, location, status, interest, cost);
                
                events.add(event);
            }
        }
        
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return events;
    }
  public Event get(int id) throws Exception {
        Event event = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        // category name is tied to event id
        String sql = "select * from event where event_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                String location = rs.getString(4);
                int status = rs.getInt(5);
                double interest = rs.getDouble(6);
                double cost = rs.getDouble(7);
                event = new Event(id, start, end, location, status, interest, cost);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return event;
    }
    
    public void insert (Event event) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = " Insert into event (event_start_date, event_end_date, event_location, event_status, event_interest, event_reservation_cost, CLIENT_client_username) values (?,?,?,?,?,?, 'pat')";
        
        
       // changes java date to long (ms from 1977) to sql date
       java.sql.Date start = new java.sql.Date(event.getStart().getTime());
       java.sql.Date end = new java.sql.Date(event.getEnd().getTime());
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setDate(1, start); 
            ps.setDate(2, end);
            ps.setString(3, event.getLocation());
            ps.setInt(4, event.getStatus());
            ps.setDouble(5, event.getInterest());
            ps.setDouble(6, event.getCost());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(Event event) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update event set event_start_date=?, event_end_date=?, event_location=?, event_status=?, event_interest=?, event_reservation_cost=? where event_id=?";
        
       java.sql.Date start = new java.sql.Date(event.getStart().getTime());
       java.sql.Date end = new java.sql.Date(event.getEnd().getTime());
        try {
            ps = con.prepareStatement(sql);
            
    
            ps.setDate(1, start); 
            ps.setDate(2, end);
            ps.setString(3, event.getLocation());
            ps.setInt(4, event.getStatus());
            ps.setDouble(5, event.getInterest());
            ps.setDouble(6, event.getCost());
            ps.executeUpdate();
            
            ps.setInt(7, event.getId());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(Event event) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from event where event_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, event.getId());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
