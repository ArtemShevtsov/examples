package com.ashevtsov.examples.database.jdbc;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by Artem_Shevtsov on 6/6/2016.
 */
public class MySQLExample {
    public static void main(String[] args) {
        DriverRegistrator.registerMySQLDriver();
        try(Connection mySQLConnection = Connector.getMySQLConnection()){
            try(Statement statement = mySQLConnection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employee;")) {

                resultSet.next();

                System.out.println("Support batch updates: " + mySQLConnection.getMetaData().supportsBatchUpdates());
                System.out.println(resultSet.getString(2));
                if(!resultSet.wasNull()){
                    System.out.println("It wasnt null!!!");
                }
            }

            try(PreparedStatement statement = mySQLConnection.prepareStatement("insert into employee(first_name, last_name, full_name) values (?, ?, ?);")){
                statement.setString(1, "Nikolay");
                statement.setString(2, "Michailov");
                statement.setString(3, "Misha Michailov");
                statement.addBatch();

                statement.setString(1, "Vanur");
                statement.setString(2, "Kulov");
                statement.setString(3, "Van Kular");
                statement.addBatch();

                statement.setString(1, "Lorem");
                statement.setString(2, "Korinskyi");
                statement.setString(3, "Lorem Korinskiy");
                statement.addBatch();

                for (int i : statement.executeBatch()) {
                    System.out.println("Result: " + i);
                }
            }

            try(Statement statement = mySQLConnection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employee;")){

                while (resultSet.next()){
                    System.out.printf("%s,\t%s,\t%s,\t%s\n",
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
