package org.example.classtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pl_1";


    protected Connection getConnection() throws SQLException {
        String username = "user_1";
        String password = "1234";

        return DriverManager.getConnection(URL, username, password);
    }
}
