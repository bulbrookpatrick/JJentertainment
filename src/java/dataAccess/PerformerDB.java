/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Performer;

/**
 *
 * @author Patrick
 */
public class PerformerDB {
    
//    get all method
           public Performer get(String email) throws Exception {
        Performer performer = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from performer where email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(3);
                String fName = rs.getString(4);
                String lName = rs.getString(5);
                String phone = rs.getString(6);
                
                performer = new Performer(username, email, password, fName, lName, phone);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return performer;
    }
    
    public void insert (Performer performer) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = " Insert into performer (performer_username, performer_email, performer_password, performer_first_name, performer_last_name, performer_phone_number) values (?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, performer.getUsername());
            ps.setString(2,performer.getEmail()); 
            ps.setString(3, performer.getPassword());
            ps.setString(4, performer.getfName());
            ps.setString(5, performer.getlName());
            ps.setString(6, performer.getPhone());
            
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(Performer performer) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update performer set performer_username=?, performer_email=?, performer_password=?, performer_first_name=?, performer_last_name=?, performer_phone_number=? where email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, performer.getUsername());
            ps.setString(2, performer.getEmail());
            ps.setString(3, performer.getPassword());
            ps.setString(4, performer.getfName());
            ps.setString (5, performer.getlName());
            ps.setString(6, performer.getPhone());
            
            
            
            ps.setString(7, performer.getEmail());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(Performer performer) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from performer where email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, performer.getEmail());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
