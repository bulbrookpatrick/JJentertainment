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
import models.Client;

/**
 *
 * @author Patrick
 */
public class ClientDB {
    
    public List<Client> getAll() throws Exception {
        List<Client> clients = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from client";
        
        try {
           ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString(1);
                String email = rs.getString(2);
                String password = rs.getString(3);
                String fName = rs.getString(4);
                String lName = rs.getString(5);
                String phone = rs.getString(6);
                int prefer = rs.getInt(7);
                Client client= new Client(username, email, password, fName, lName, phone, prefer);
                
                clients.add(client);
            }
        }
        
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return clients;
    }
  public Client get(String email) throws Exception {
        Client client = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from client where client_email=?";
        
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
                int prefer = rs.getInt(7);
                client = new Client(username, email, password, fName, lName, phone, prefer);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return client;
    }
    
    public void insert (Client client) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = " Insert into client (client_username, client_email, "
                + "client_password, client_first_name, client_last_name, "
                + "client_phone_number, client_preferred_contact) values (?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getUsername());
            ps.setString(2,client.getEmail()); 
            ps.setString(3, client.getPassword());
            ps.setString(4, client.getfName());
            ps.setString(5, client.getlName());
            ps.setString(6, client.getPhone());
            ps.setInt(7, client.getPrefer());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(Client client) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update client set client_username=?, client_email=?, client_password=?, client_first_name=?, client_last_name=?, client_phone_number=?, client_prefferred_contact=? where client_email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, client.getUsername());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPassword());
            ps.setString(4, client.getfName());
            ps.setString (5, client.getlName());
            ps.setString(6, client.getPhone());
            ps.setInt(7,client.getPrefer());
            
            
            ps.setString(8, client.getEmail());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(Client client) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from client where client_email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getEmail());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
}
