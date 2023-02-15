/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.ServiceDB;
import java.util.Date;
import java.util.List;
import models.Service;

/**
 *
 * @author Patrick
 */
public class ServiceService {
      public List<Service> getAll() throws Exception {
        ServiceDB ServiceDB = new ServiceDB();
        List<Service> services = ServiceDB.getAll();
        return services;
    }
    
    public Service get(int id) throws Exception {
        ServiceDB serviceDB = new ServiceDB();
        Service service = serviceDB.get(id);
        return service;
    }
    
    public void insert(int id, Date start, Date end, int duration, double cost, int participants, int performers) throws Exception {
        Service service = new Service(id, start, end, duration, cost, participants, performers);
        ServiceDB serviceDB = new ServiceDB();
        serviceDB.insert(service);
    }
    
    public void update(int id, Date start, Date end, int duration, double cost, int participants, int performers) throws Exception {
        Service service = new Service(id, start, end, duration, cost, participants, performers);
        ServiceDB serviceDB = new ServiceDB();
        serviceDB.update(service);
    }
    

    public void delete(int id) throws Exception {
        Service service = new Service();
        service.setId(id);
        ServiceDB serviceDB = new ServiceDB();
        serviceDB.delete(service);
    }
    
}
