package com.example.loginsignup.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBHandler extends config {
    static private Connection connection;
    // static private DBHandler dbHandler;
    // static private Connection connection;
    static private PreparedStatement preparedStatement;

    public Connection getDbconnection() throws SQLException {
        String connectionUrl = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + dbTimezone;
        connection = DriverManager.getConnection(connectionUrl,
                dbUser, dbPassword);

        return connection;
    }

    public static void addUser(String firstname, String lastname, String userName, String email, String password)
            throws SQLException {
        DBHandler dbHandler = new DBHandler();
        connection = dbHandler.getDbconnection();
        String insert = "INSERT INTO users(firstname,lastname,username,email,password)" +
                "VALUES(?,?,?,?,?)";

        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, userName);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, password);
        preparedStatement.executeUpdate();
    }

    public static void insertTask(int userid, String task, String description, Timestamp datecreated)
            throws SQLException {
        DBHandler dbHandler = new DBHandler();
        connection = dbHandler.getDbconnection();
        String insert = "INSERT INTO task(userid,datecreated,description,task)" +
                "VALUES(?,?,?,?)";

        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setInt(1, userid);
        preparedStatement.setTimestamp(2, datecreated);
        preparedStatement.setString(3, description);
        preparedStatement.setString(4, task);
        preparedStatement.executeUpdate();
    }

    public static int userId(String userName) throws SQLException {
        DBHandler dbHandler = new DBHandler();
        connection = dbHandler.getDbconnection();

        String query = "SELECT userid FROM users WHERE username = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        preparedStatement.setString(1, userName);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt("userid");
        }
        return -1;
    }

    public static String checkUser(String userName, String password) throws SQLException {
        DBHandler dbHandler = new DBHandler();
        connection = dbHandler.getDbconnection();
        String username = userName;
        String passwordL = password;
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, passwordL);
        // preparedStatement.setInt(3, userid);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            if (resultSet.getString("username") != null && resultSet.getString("password") != null) {

                return resultSet.getString("username");
            } else {
                return null;
            }
        }
        return null;
    }

}
