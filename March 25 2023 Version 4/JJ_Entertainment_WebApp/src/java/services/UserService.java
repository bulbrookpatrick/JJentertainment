/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.sql.SQLException;
import models.User;

/**
 *
 * @author kurtm
 */
public class UserService {

    public User get(String username) throws SQLException {
        UserDB userdb = new UserDB();
        User user = userdb.get(username);
        return user;
    }

    public int countUname(String username) throws SQLException {
        UserDB userdb = new UserDB();
        int count = userdb.countUname(username);
        return count;
    }

    public int countEmail(String email) throws SQLException {
        UserDB userdb = new UserDB();
        int count = userdb.countEmail(email);
        return count;
    }

    public void add(User user) throws SQLException {
        UserDB userdb = new UserDB();
        userdb.add(user);
    }

}
