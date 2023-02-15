/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.ManagerDB;
import java.util.List;
import models.Manager;

/**
 *
 * @author Patrick
 */
public class ManagerService {
     public Manager login(String email, String password) {
        ManagerDB managerDB = new ManagerDB();
        
        try {
            Manager manager = managerDB.get(email);
            if(password.equals(manager.getPassword())) {
                return manager;
            }
        }
            catch (Exception ex) {
                    
            }
        return null;
        }
//    
//    public List<Manager> getAll() throws Exception {
//        ManagerDB ManagerDB = new ManagerDB();
//        List<Manager> managers = ManagerDB.getAll();
//        return managers;
//    }
//    
    public Manager get(String email) throws Exception {
        ManagerDB managerDB = new ManagerDB();
        Manager manager = managerDB.get(email);
        return manager;
    }
    
    public void insert(String username, String email, String password, String fName, String lName, String phone) throws Exception {
        Manager manager = new Manager(username, email, password, fName, lName, phone);
        ManagerDB managerDB = new ManagerDB();
        managerDB.insert(manager);
    }
    
    public void update(String username, String email, String password, String fName, String lName, String phone) throws Exception {
        Manager manager = new Manager(username, email, password, fName, lName, phone);
        ManagerDB managerDB = new ManagerDB();
        managerDB.update(manager);
    }
    

    public void delete(String email) throws Exception {
        Manager manager = new Manager();
        manager.setEmail(email);
        ManagerDB managerDB = new ManagerDB();
        managerDB.delete(manager);
    }
    
    
    
}
