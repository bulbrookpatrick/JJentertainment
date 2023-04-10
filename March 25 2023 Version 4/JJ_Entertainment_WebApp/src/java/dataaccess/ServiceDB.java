/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.Event;
import models.Service;
import models.User;

/**
 *
 * @author kurtm
 */
public class ServiceDB {

    public void add(Service ser) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO SERVICE (service_start_date, service_end_date, service_duration, service_price, number_of_participants, number_of_performers_to_be_assigned, CATEGORY_category_id, EVENT_event_id)"
                + "VALUES(?,?,?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ser.getStart());
            ps.setObject(2, ser.getEnd());
            ps.setInt(3, ser.getDuration());
            ps.setDouble(4, ser.getPrice());
            ps.setInt(5, ser.getParticipants());
            ps.setInt(6, ser.getNumPerformersAssigned());
            ps.setInt(7, ser.getCategory().getId());
            ps.setInt(8, ser.getEvent().getId());
            System.out.println(ps);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
      public List<Service> get(int month, int year) throws SQLException {
         List<Service> services = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from service where MONTH(service_start_date) = ? && YEAR(service_start_date) = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                Date startdb = (Date) rs.getObject(2);
                Date enddb = (Date) rs.getObject(3);
                int duration = rs.getInt(4);
                double price = rs.getDouble(5);
                int participants = rs.getInt(6);
                int performers = rs.getInt(7);
                int catid = rs.getInt(8);
                int eventid = rs.getInt(9);

                EventDB eventdb = new EventDB();
                CategoryDB catdb = new CategoryDB();
                Event eventObj = eventdb.get(eventid);
                Category catObj = catdb.get(catid);
                
                
                Service service = new Service(id, startdb, enddb, duration, price, participants, performers, catObj, eventObj);
                
                services.add(service);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return services;
        
        
    
    }

    public List<Service> getAllServEvent(int eventSel) throws SQLException, ParseException {
        List<Service> services = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from service WHERE event_event_id = ? order by category_category_id, service_start_date, service_end_date";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventSel);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                Date startdb = (Date) rs.getObject(2);
                Date enddb = (Date) rs.getObject(3);
                int duration = rs.getInt(4);
                double price = rs.getDouble(5);
                int participants = rs.getInt(6);
                int performers = rs.getInt(7);
                int catid = rs.getInt(8);
                int eventid = rs.getInt(9);

                EventDB eventdb = new EventDB();
                CategoryDB catdb = new CategoryDB();
                Event eventObj = eventdb.get(eventid);
                Category catObj = catdb.get(catid);

                Date start = startdb;
                Date end = enddb;

                Service Service = new Service(id, start, end, duration, price, participants, performers, catObj, eventObj);
                System.out.println(start);
                services.add(Service);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return services;
    }

}
