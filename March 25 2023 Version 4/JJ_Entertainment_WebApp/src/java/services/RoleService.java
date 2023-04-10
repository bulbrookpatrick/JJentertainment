/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.sql.SQLException;
import models.Role;

/**
 *
 * @author kurtm
 */
public class RoleService {

    public Role get(int i) throws SQLException {
        RoleDB roledb = new RoleDB();
        Role role = roledb.get(i);
        return role;
    }

}
