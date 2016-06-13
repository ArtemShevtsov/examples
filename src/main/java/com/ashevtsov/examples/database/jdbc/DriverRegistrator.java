package com.ashevtsov.examples.database.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 * Created by Artem_Shevtsov on 6/6/2016.
 */
public class DriverRegistrator {
    public static void registerMySQLDriver(){
        try {
            Driver mySqlDriver = new Driver();
            DriverManager.registerDriver(mySqlDriver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
