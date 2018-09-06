package com;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./src/main/resources/test_db", "root", "root");
        PreparedStatement preparedStatement =
                connection.prepareCall(
                        "select id, name from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getInt(1));
            System.out.println("name=" + resultSet.getString(2));
        }

    }
}
