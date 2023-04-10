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
import models.Category;

/**
 *
 * @author kurtm
 */
public class CategoryDB {

    public List<Category> getAll() throws Exception {
        List<Category> categories = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Category order by category_name";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String desc = rs.getString(3);
                double rate = rs.getDouble(4);
                int minNumPar = rs.getInt(5);
                int minNumPer = rs.getInt(6);

                Category Category = new Category(id, name, desc, rate, minNumPar, minNumPer);

                categories.add(Category);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return categories;
    }

    public Category get(int catid) throws SQLException {
        Category category = new Category();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Category where category_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, catid);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String desc = rs.getString(3);
                double rate = rs.getDouble(4);
                int minNumPar = rs.getInt(5);
                int minNumPer = rs.getInt(6);

                category = new Category(id, name, desc, rate, minNumPar, minNumPer);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return category;
    }

    public void del(int parseInt) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM Category WHERE category_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, parseInt);
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(Category cat) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE Category SET category_name=?, category_description=?, category_rate=?, min_number_of_participants=?, min_number_of_performers=? WHERE category_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getDesc());
            ps.setDouble(3, cat.getRate());
            ps.setInt(4, cat.getMinNumPar());
            ps.setInt(5, cat.getMinNumPer());
            ps.setInt(6, cat.getId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void add(Category cat) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO CATEGORY (category_name, category_description, category_rate, min_number_of_participants, min_number_of_performers) " + "VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getDesc());
            ps.setDouble(3, cat.getRate());
            ps.setInt(4, cat.getMinNumPar());
            ps.setInt(5, cat.getMinNumPer());
            ps.executeUpdate();
            System.out.println(cat.getName());
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
