/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package dao;

import entity.User;

/**
 * This interface provides methods to query the necessary data from User table
 * in the database. <code>java.lang.Exception</code> throws when error occurs
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public interface UserDAO {

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
    public User getUserByUserName(String userName) throws Exception;

    /**
     * This method insert a <code>User</code> object into User table in the
     * database.
     *
     * @param user is the <code>User</code> object.
     * @throws Exception if querying informations from database is error
     */
    public void insertUser(User user) throws Exception;

}
