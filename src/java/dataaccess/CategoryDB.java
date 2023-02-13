/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Category;

/**
 *
 * @author kurtm
 */
public class CategoryDB {

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            categories = em.createNamedQuery("Category.findAll", Category.class).getResultList();
            return categories;
        } finally {
            em.close();
        }
    }
    
}
