/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import dataAccess.ClientDB;
import models.Client;
/**
 *
 * @author Patrick
 */
public class ClientService {
      public Client login(String email, String password) {
        ClientDB clientDB = new ClientDB();
        
        try {
            Client client = clientDB.get(email);
            if(password.equals(client.getPassword())) {
                return client;
            }
        }
            catch (Exception ex) {
                    
            }
        return null;
        }
    

    
    
    public Client get(String email) throws Exception {
        ClientDB clientDB = new ClientDB();
        Client client = clientDB.get(email);
        return client;
    }
    
    public void insert(String username, String email, String password, String fName, String lName, int phone, int prefer) throws Exception {
        Client client = new Client(username, email, password, fName, lName, phone, prefer);
        ClientDB clientDB = new ClientDB();
        clientDB.insert(client);
    }
    
    public void update(String username, String email, String password, String fName, String lName, int phone, int prefer) throws Exception {
        Client client = new Client(username, email, password, fName, lName, phone, prefer);
        ClientDB clientDB = new ClientDB();
        clientDB.update(client);
    }
    

    public void delete(String email) throws Exception {
        Client client = new Client();
        client.setEmail(email);
        ClientDB clientDB = new ClientDB();
        clientDB.delete(client);
    }
    
}
