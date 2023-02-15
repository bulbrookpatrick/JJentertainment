/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.PerformerDB;
import models.Performer;

/**
 *
 * @author Patrick
 */
public class PerformerService {
    public Performer get(String email) throws Exception {
        PerformerDB performerDB = new PerformerDB();
        Performer performer = performerDB.get(email);
        return performer;
    }
    
    public void insert(String username, String email, String password, String fName, String lName, String phone) throws Exception {
        Performer performer = new Performer(username, email, password, fName, lName, phone);
        PerformerDB performerDB = new PerformerDB();
        performerDB.insert(performer);
    }
    
    public void update(String username, String email, String password, String fName, String lName, String phone) throws Exception {
        Performer performer = new Performer(username, email, password, fName, lName, phone);
        PerformerDB performerDB = new PerformerDB();
        performerDB.update(performer);
    }
    

    public void delete(String email) throws Exception {
        Performer performer = new Performer();
        performer.setEmail(email);
        PerformerDB performerDB = new PerformerDB();
        performerDB.delete(performer);
    }
    
}
