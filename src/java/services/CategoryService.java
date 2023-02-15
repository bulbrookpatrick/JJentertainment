/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataAccess.CategoryDB;
import java.util.List;
import javax.naming.Name;
import models.Category;

/**
 *
 * @author Patrick
 */
public class CategoryService {
      public List<Category> getAll() throws Exception {
        CategoryDB CategoryDB = new CategoryDB();
        List<Category> categorys = CategoryDB.getAll();
        return categorys;
    }
    
    public Category get(String name) throws Exception {
        CategoryDB categoryDB = new CategoryDB();
        Category category = categoryDB.get(name);
        return category;
    }
    
    public void insert(String name, String desc, double rate, int min, int max) throws Exception {
        Category category = new Category(name, desc, rate, min, max);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.insert(category);
    }
    
    public void update(String name, String desc, double rate, int min, int max) throws Exception {
        Category category = new Category(name, desc, rate, min, max);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.update(category);
    }
    

    public void delete(String name) throws Exception {
        Category category = new Category();
        category.setName(name);
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.delete(category);
    }
    
}
