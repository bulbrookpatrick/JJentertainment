/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.PerformerCategoryDB;
import java.sql.SQLException;
import java.util.List;
import models.PerformerCategory;

/**
 *
 * @author kurtm
 */
public class PerformerCategoryService {

    public List<PerformerCategory> getAll() throws SQLException {
        PerformerCategoryDB pcDB = new PerformerCategoryDB();
        List<PerformerCategory> pc = pcDB.getAll();
        return pc;
    }

    public List<PerformerCategory> getAllPerId(int userid) throws SQLException {
        PerformerCategoryDB pcDB = new PerformerCategoryDB();
        List<PerformerCategory> pc = pcDB.getAllPerId(userid);
        return pc;
    }

    public void del(int delPer, int delCat) throws SQLException {
        PerformerCategoryDB pcDB = new PerformerCategoryDB();
        pcDB.del(delPer, delCat);
    }

    public void add(int username, int categoryId, String catName) throws SQLException {
        PerformerCategoryDB pcDB = new PerformerCategoryDB();
        pcDB.add(username, categoryId, catName);
    }

}
