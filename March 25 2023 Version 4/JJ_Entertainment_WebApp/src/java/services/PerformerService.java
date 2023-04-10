/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.PerformerDB;
import java.sql.SQLException;
import java.util.List;
import models.Performer;

/**
 *
 * @author kurtm
 */
public class PerformerService {

    public List<Performer> getAll() throws SQLException {
        PerformerDB perDB = new PerformerDB();
        List<Performer> performers = perDB.getAll();
        return performers;
    }

    public Performer get(int userid) throws SQLException {
        PerformerDB perDB = new PerformerDB();
        Performer performer = perDB.get(userid);
        return performer;
    }

    public void update(Performer performer, int userid) throws SQLException {
        PerformerDB perDB = new PerformerDB();
        perDB.update(performer, userid);
    }

    public Performer add(Performer performer) throws SQLException {
        PerformerDB perDB = new PerformerDB();
        Performer per = perDB.add(performer);
        return per;
    }

}
