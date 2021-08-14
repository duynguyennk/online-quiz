/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class contain informations to connect to MSSQL Server properties and
 * close the connection.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
public class DBContext {

    private InitialContext initial;
    private Context context;
    private String dbName;
    private String serverName;
    private String portNumber;
    private String userName;
    private String password;

    /**
     * Initializes a newly created DBContext object from a parameterless
     * constructor
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbName = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            userName = context.lookup("username").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {
        }
    }

    /**
     * This method open connection to Database.
     *
     * @return Connection of Database and Application.
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param con connection of application and Database.
     */
    public void closeConntection(Connection con) {
        try {
            if (con == null || con.isClosed()) {
                return;
            }
            con.close();
        } catch (SQLException e) {
        }
    }

    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param ps prepared statement that was executed and not suppose to use.
     */
    public void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps == null || ps.isClosed()) {
                return;
            }
            ps.close();
        } catch (SQLException e) {
        }
    }

    /**
     * This method close ResultSet, free system resources.
     *
     * @param rs a table of data representing a database result set.
     */
    public void closeResultSet(ResultSet rs) {
        try {
            if (rs == null || rs.isClosed()) {
                return;
            }
            rs.close();
        } catch (SQLException e) {
        }
    }
}
