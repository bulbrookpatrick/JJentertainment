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
import models.category;

/**
 *
 * @author Patrick
 */
public class CategoryDB {
     public List<category> getAll() throws Exception {
        List<category> categories = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from category";
        
        try {
           ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                double rate = rs.getDouble(3);
                int min = rs.getInt(4);
                int max = rs.getInt(5);

                category category= new category(name, desc, rate, min, max);
                
                categories.add(category);
            }
        }
        
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return categories;
    }
  public category get(String name) throws Exception {
        category category = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from category where category_name=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                String desc = rs.getString(1);
                double rate = rs.getDouble(3);
                int min = rs.getInt(4);
                int max = rs.getInt(5);

                category= new category(name, desc, rate, min, max);
                
            }
            

        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return category;
    }
    
    public void insert (category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "Insert into category "
                + "(category_id, category_name, category_description,"
                + " category_rate, min_number_of_participants, "
                + "max_number_of_participants) values (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2,category.getDesc()); 
            ps.setDouble(3, category.getRate());
            ps.setInt(4, category.getMin());
            ps.setInt(5, category.getMax());
 
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
    }
    
  
    
    
   
    
 
    
    public void update(category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "update category set category_name=?, category_description=?, category_rate=?, min_number_of_participants=?, max_number_of_participants=? where category_name = ?";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, category.getName());
            ps.setString(2,category.getDesc()); 
            ps.setDouble(3, category.getRate());
            ps.setInt(4, category.getMin());
            ps.setInt(5, category.getMax());
 
            
            
            ps.setString(6, category.getName());
           
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    
    
    public void delete(category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from category where category_name?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.executeUpdate();
            
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
}
