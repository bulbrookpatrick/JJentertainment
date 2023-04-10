/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import java.sql.SQLException;
import java.util.List;
import models.Category;

/**
 *
 * @author kurtm
 */
public class CategoryService {

    public List<Category> getAll() throws Exception {
        CategoryDB CategoryDB = new CategoryDB();
        List<Category> categories = CategoryDB.getAll();
        return categories;
    }

    public Category get(int parseInt) throws SQLException {
        CategoryDB categoryDB = new CategoryDB();
        Category cat = categoryDB.get(parseInt);
        return cat;
    }

    public void del(int parseInt) throws SQLException {
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.del(parseInt);
    }

    public void update(Category cat) throws SQLException {
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.update(cat);
    }

    public void add(Category cat) throws SQLException {
        CategoryDB categoryDB = new CategoryDB();
        categoryDB.add(cat);
    }

}
