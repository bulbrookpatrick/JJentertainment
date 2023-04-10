/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Role;
import models.User;

/**
 *
 * @author kurtm
 */
public class UserDB {

    public User get(String username) throws SQLException {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        RoleDB rdb = new RoleDB();
        String sql = "SELECT * FROM user WHERE user_username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String username1 = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String fName = rs.getString(5);
                String lName = rs.getString(6);
                String phone = rs.getString(7);
                int prefer = rs.getInt(8);
                int roleid = rs.getInt(9);
                Role role = rdb.get(roleid);
                user = new User(username1, email, password, fName, lName, phone, prefer, role);
                user.setId(id);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return user;
    }

    public int countUname(String username) throws SQLException {
        int count = 0;

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM user WHERE user_username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return count;
    }

    public int countEmail(String email) throws SQLException {
        int count = 0;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM user WHERE user_email=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return count;
    }

    public void add(User user) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO USER VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFirstname());
            ps.setString(5, user.getLastname());
            ps.setString(6, user.getPhonenumber());
            ps.setInt(7, user.getPrefContact());
            ps.setInt(8, user.getRole().getId());
            ps.executeUpdate();
        } finally {
 
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
