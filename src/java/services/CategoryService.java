/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import java.util.List;
import models.Category;

/**
 *
 * @author kurtm
 */
public class CategoryService {

    public List<Category> getAll() {
        CategoryDB catdb = new CategoryDB();
        List<Category> categories = catdb.getAll();
        return categories;
    }
    
}
