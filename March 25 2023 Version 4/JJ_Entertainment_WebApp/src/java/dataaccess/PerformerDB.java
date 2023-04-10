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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Performer;

/**
 *
 * @author kurtm
 */
public class PerformerDB {

    public List<Performer> getAll() throws SQLException {
        List<Performer> performers = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from performer order by performer_username";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String fname = rs.getString(5);
                String lname = rs.getString(6);
                String phoneNumber = rs.getString(7);

                Performer performer = new Performer(id, username, email, password, fname, lname, phoneNumber);

                performers.add(performer);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return performers;
    }

    public Performer get(int userFind) throws SQLException {
        Performer performer = new Performer();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from performer WHERE performer_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userFind);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String fname = rs.getString(5);
                String lname = rs.getString(6);
                String phoneNumber = rs.getString(7);

                performer = new Performer(id, username, email, password, fname, lname, phoneNumber);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return performer;
    }

    public void update(Performer performer, int userId) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update performer set performer_username=?, performer_email=?, performer_password=?, performer_first_name=?, performer_last_name=?, performer_phone_number=? WHERE performer_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, performer.getUsername());
            ps.setString(2, performer.getEmail());
            ps.setString(3, performer.getPassword());
            ps.setString(4, performer.getFname());
            ps.setString(5, performer.getLname());
            ps.setString(6, performer.getPhoneNumber());
            ps.setInt(7, userId);
            ps.executeUpdate();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public Performer add(Performer performer) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into performer values (null, ?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, performer.getUsername());
            ps.setString(2, performer.getEmail());
            ps.setString(3, performer.getPassword());
            ps.setString(4, performer.getFname());
            ps.setString(5, performer.getLname());
            ps.setString(6, performer.getPhoneNumber());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                performer.setId(rs.getInt(1));
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return performer;
    }

}
