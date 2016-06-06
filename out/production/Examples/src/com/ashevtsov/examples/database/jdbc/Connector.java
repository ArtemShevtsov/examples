package com.ashevtsov.examples.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 * Created by Artem_Shevtsov on 6/6/2016.
 */
public class Connector {
    public static Connection getMySQLConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql_training", "root", "mysqlroot");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
