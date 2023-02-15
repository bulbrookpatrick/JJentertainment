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
import models.Service;

/**
 *
 * @author Patrick
 */
public class ServiceDB {
    public List<Service> getAll() throws Exception {
        List<Service> services = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from service";
        
        try {
           ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                int duration = rs.getInt(4);
                double cost = rs.getDouble(5);
                int participants = rs.getInt(6);
                int performers  = rs.getInt(7);
                Service service= new Service(id, start, end, duration, cost, participants, performers);
                
                services.add(service);
            }
        }
        
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return services;
    }
  public Service get(int id) throws Exception {
        Service service = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        // category name is tied to service id
        String sql = "select * from service where service_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                int duration = rs.getInt(4);
                double cost = rs.getDouble(5);
                int participants = rs.getInt(6);
                int performers  = rs.getInt(7);
                service= new Service(id, start, end, duration, cost, participants, performers);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return service;
    }
    
    public void insert (Service service) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = " Insert into service (service_id, service_start_date, service_end_date, service_duration, service_price, number_of_participants, number_of_performers_to_be_assigned) values (?,?,?,?,?,?)";
        
        
       // changes java date to long (ms from 1977) to sql date
       java.sql.Date start = new java.sql.Date(service.getStart().getTime());
       java.sql.Date end = new java.sql.Date(service.getEnd().getTime());
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, service.getId());
            ps.setDate(2, start); 
            ps.setDate(3, end);
            ps.setInt(4, service.getDuration());
            ps.setDouble(5, service.getCost());
            ps.setDouble(6, service.getParticipants());
            ps.setDouble(7, service.getPerformers());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(Service service) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update service set service_start_date=?, service_end_date=?, service_location=?, service_status=?, service_interest=?, service_reservation_cost=? where service_id=?";
        
       java.sql.Date start = new java.sql.Date(service.getStart().getTime());
       java.sql.Date end = new java.sql.Date(service.getEnd().getTime());
        try {
            ps = con.prepareStatement(sql);
            
    
            ps.setDate(1, start); 
            ps.setDate(2, end);
           ps.setInt(3, service.getDuration());
            ps.setDouble(4, service.getCost());
            ps.setInt(5, service.getParticipants());
            ps.setInt(6, service.getPerformers());
            ps.executeUpdate();
            
            ps.setInt(7, service.getId());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(Service service) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from service where service_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, service.getId());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
