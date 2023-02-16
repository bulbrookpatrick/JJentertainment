/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.CategoryDB;
import java.util.List;
import javax.naming.Name;
import models.category;

/**
 *
 * @author Patrick
 */
public class CategoryService {
      public List<category> getAll() throws Exception {
        CategoryDB CategoryDB = new CategoryDB();
        List<category> categorys = CategoryDB.getAll();
        return categorys;
    }
    
    public category get(String name) throws Exception {
        CategoryDB categoryDB = new CategoryDB();
        category category = categoryDB.get(name);
        return category;
    }
    
    public void insert(String name, String desc, double rate, int min, int max) throws Exception {
        category category = new category(name, desc, rate, min, max);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.insert(category);
    }
    
    public void update(String name, String desc, double rate, int min, int max) throws Exception {
        category category = new category(name, desc, rate, min, max);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.update(category);
    }
    

    public void delete(String name) throws Exception {
        category category = new category();
        category.setName(name);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.delete(category);
    }
    
}
