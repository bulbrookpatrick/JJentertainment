/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Event;
import models.User;

/**
 *
 * @author kurtm
 */
public class EventDB {

    public Event add(Event event) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO EVENT (event_start_date, event_end_date, event_location, event_status, event_interest, event_reservation_cost, User_user_username, event_price, event_total) " + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, (Date) event.getStart());
            ps.setDate(2, (Date) event.getEnd());
            ps.setString(3, event.getLocation());
            ps.setInt(4, event.getStatus());
            ps.setDouble(5, event.getInterest());
            ps.setDouble(6, event.getReservation());
            ps.setString(7, event.getUser().getUsername());
            ps.setDouble(8, event.getPrice());
            ps.setDouble(9, event.getTotal());
            System.out.println(ps);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                event.setId(rs.getInt(1));
            }
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return event;
    }

    public List<Event> getAllPending() throws SQLException {
        List<Event> events = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from event WHERE event_status = 0 order by event_start_date, event_end_date";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                String loc = rs.getString(4);
                int status = rs.getInt(5);
                double interest = rs.getDouble(6);
                double resCos = rs.getDouble(7);
                String user = rs.getString(8);
                double eventPrice = rs.getDouble(9);
                double eventTotal = rs.getDouble(10);

                UserDB userdb = new UserDB();
                User userObj = userdb.get(user);
                Event Event = new Event(id, start, end, loc, status, interest, resCos, eventPrice, eventTotal, userObj);
                events.add(Event);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return events;
    }

    public Event get(int eventid) throws SQLException {
        Event event = new Event();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from event WHERE event_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventid);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                Date start = rs.getDate(2);
                Date end = rs.getDate(3);
                String loc = rs.getString(4);
                int status = rs.getInt(5);
                double interest = rs.getDouble(6);
                double resCos = rs.getDouble(7);
                String user = rs.getString(8);
                double eventPrice = rs.getDouble(9);
                double eventTotal = rs.getDouble(10);

                UserDB userdb = new UserDB();
                User userObj = userdb.get(user);
                event = new Event(id, start, end, loc, status, interest, resCos, eventPrice, eventTotal, userObj);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return event;

    }

    public void activate(int eventSel) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE event set event_status = 1 WHERE event_id = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventSel);
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void refund(int eventSel) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE event set event_status = 2 WHERE event_id = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventSel);
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void finish(int eventSel) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE event set event_status = 3 WHERE event_id = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventSel);
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
