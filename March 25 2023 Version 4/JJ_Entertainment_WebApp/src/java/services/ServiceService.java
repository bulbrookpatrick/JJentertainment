/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.ConnectionPool;
import dataaccess.DBUtil;
import dataaccess.ServiceDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import models.Category;
import models.Service;

/**
 *
 * @author kurtm
 */
public class ServiceService {

    public int getNumOfPerformerAssigned(Service service, Category category) {
        int minNumPer = category.getMinNumPer();
        int minNumPar = category.getMinNumPar();
        int serPar = service.getParticipants();
        double parPerPer = minNumPar / minNumPer;

        int perAssign = minNumPer;
        if (serPar > minNumPar) {
            perAssign = (int) (Math.ceil(serPar / parPerPer));
        }

        return perAssign;
    }

    public double getServicePrice(Service service, Category category) {
        int perAssign = service.getNumPerformersAssigned();
        double rate = category.getRate();
        int duration = service.getDuration();
        double price = perAssign * rate * duration;
        double rounded = (double) Math.round(price * 100) / 100;
        return rounded;
    }

    public void add(Service ser) throws SQLException {
        ServiceDB servicedb = new ServiceDB();
        servicedb.add(ser);
    }

    public int getDuration(Date start, Date end) {
        long secs = (end.getTime() - start.getTime()) / 1000;
        int duration = (int) Math.ceil(secs / 3600);
        return duration;
    }

    public List<Service> getAllServEvent(int eventSel) throws SQLException, ParseException {
        ServiceDB servicedb = new ServiceDB();
        List<Service> services = servicedb.getAllServEvent(eventSel);
        return services;
    }
    
    //    month year
    public List<Service> getByMonthYear(int month, int year) throws SQLException {
            ServiceDB servicedb = new ServiceDB();
            List<Service> services = servicedb.get(month, year);
            return services;
        }

}
