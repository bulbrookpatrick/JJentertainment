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
import java.util.List;

import models.Manager;

/**
 *
 * @author Patrick
 */
public class ManagerDB {
//          public List<Manager> getAll() throws Exception {
//          return null;
//          }
//    
       public Manager get(String email) throws Exception {
        Manager manager = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from manager where email=?";
        
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
                
                manager = new Manager(username, email, password, fName, lName, phone);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return manager;
    }
    
    public void insert (Manager manager) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = " Insert into manager (manager_username, manager_email, manager_password, manager_first_name, manager_last_name, manager_phone_number) values (?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, manager.getUsername());
            ps.setString(2,manager.getEmail()); 
            ps.setString(3, manager.getPassword());
            ps.setString(4, manager.getfName());
            ps.setString(5, manager.getlName());
            ps.setString(6, manager.getPhone());
            
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(Manager manager) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update manager set manager_username=?, manager_email=?, manager_password=?, manager_first_name=?, manager_last_name=?, manager_phone_number=? where email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, manager.getUsername());
            ps.setString(2, manager.getEmail());
            ps.setString(3, manager.getPassword());
            ps.setString(4, manager.getfName());
            ps.setString (5, manager.getlName());
            ps.setString(6, manager.getPhone());
            
            
            
            ps.setString(7, manager.getEmail());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(Manager manager) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from manager where email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, manager.getEmail());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
}
