/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package dao.impl;

import context.DBContext;
import dao.UserDAO;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class is an implementation of the UserDAO interface and extends
 * DBContext class. This class has methods to query the necessary data from User
 * table in the database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error while querying
 * the data.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
public class UserDAOImpl extends DBContext implements UserDAO {

    /**
     * This method returns a <code>User</code> object from database with a
     * specify username. The result contain a <code>User</code> objects with id,
     * userName, password, type and email attributes.
     *
     * @param userName is the username of the <code>User</code> object. It is a
     * <code>java.lang.String</code> object.
     * @return a <code>User</code> object.
     * @throws Exception if querying informations from database is error
     */
    @Override
    public User getUserByUserName(String userName) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from [User] where username = ?";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int type = rs.getInt("type");
                user = new User(id, userName, password, email, type);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return user;
    }

    /**
     * This method insert a <code>User</code> object into User table in the
     * database.
     *
     * @param user is the <code>User</code> object.
     * @throws Exception if querying informations from database is error
     */
    @Override
    public void insertUser(User user) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into [User] values (?,?,?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getType());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
    }

}
