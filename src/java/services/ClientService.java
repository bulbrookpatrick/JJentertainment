/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataacess.ClientDB;
import models.Client;

public class ClientService {
    public Client get(String username) throws Exception {
        ClientDB clientDB = new ClientDB();
        Client client = clientDB.get(username);
        return client;
    }
}
