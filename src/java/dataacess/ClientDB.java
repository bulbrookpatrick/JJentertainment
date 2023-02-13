/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import javax.persistence.EntityManager;
import models.Client;

public class ClientDB {
    public Client get(String username) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Client client = em.find(Client.class, username);
            return client;
        } finally {
            em.close();
        }
    }
}
