/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PerformerCategory;

/**
 *
 * @author kurtm
 */
public class PerformerCategoryDB {

    public List<PerformerCategory> getAll() throws SQLException {
        List<PerformerCategory> pc = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PerformerDB pDB = new PerformerDB();
        CategoryDB cDB = new CategoryDB();

        String sql = "select * from PERFORMER_SPECIALTY order by CATEGORY_category_name";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int catId = rs.getInt(1);
                int perId = rs.getInt(2);

                PerformerCategory pCat = new PerformerCategory(pDB.get(perId), cDB.get(catId));
                pc.add(pCat);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return pc;
    }

    public List<PerformerCategory> getAllPerId(int userid) throws SQLException {
        List<PerformerCategory> pc = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PerformerDB pDB = new PerformerDB();
        CategoryDB cDB = new CategoryDB();

        String sql = "select * from PERFORMER_SPECIALTY where PERFORMER_performer_id=? order by CATEGORY_category_name";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            rs = ps.executeQuery();

            while (rs.next()) {
                int catId = rs.getInt(1);
                int perId = rs.getInt(2);

                PerformerCategory pCat = new PerformerCategory(pDB.get(perId), cDB.get(catId));
                pc.add(pCat);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return pc;
    }

    public void del(int delPer, int delCat) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;

        String sql = "delete from PERFORMER_SPECIALTY where PERFORMER_performer_id=? && CATEGORY_category_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, delPer);
            ps.setInt(2, delCat);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void add(int userid, int categoryId, String catName) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;

        String sql = "insert into PERFORMER_SPECIALTY values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ps.setInt(2, userid);
            ps.setString(3, catName);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
