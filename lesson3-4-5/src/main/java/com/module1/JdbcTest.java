package com.module1;

import com.module1.models.City;
import com.module1.models.Country;
import com.module1.models.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:C:/Users/sereg/Desktop/Hillel/java-ee/home/homework4db", "sa", "sa");
        Map<Integer, Country> countryMap = getIntegerCountryMap(connection);
        System.out.println(countryMap);
        Map<Integer, City> cityMap = getIntegerCityMap(connection, countryMap);
        System.out.println(cityMap);
        Map<Integer, User> userMap =
                getIntegerUserMap(connection, cityMap);
        System.out.println(userMap);

    }

    private static Map<Integer, User> getIntegerUserMap(Connection connection, Map<Integer, City> cityMap) throws SQLException {
        PreparedStatement preparedStatement3 = connection.prepareStatement("select ID, NAME, CITY_ID FROM USER");
        ResultSet resultSet3 = preparedStatement3.executeQuery();
        Map<Integer, User> userMap = new HashMap<Integer, User>();
        while (resultSet3.next()) {
            int id = resultSet3.getInt("id");
            String name = resultSet3.getString("name");
            int cityId = resultSet3.getInt("city_id");
            City city = cityMap.get(cityId);
            userMap.put(id, new User(id, name, city));
        }
        return userMap;
    }

    private static Map<Integer, City> getIntegerCityMap(Connection connection, Map<Integer, Country> countryMap) throws SQLException {
        PreparedStatement preparedStatement2 = connection.prepareStatement("select ID, NAME, COUNTRY_ID FROM CITY");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        Map<Integer, City> cityMap = new HashMap<Integer, City>();
        while (resultSet2.next()) {
            int id = resultSet2.getInt("id");
            String name = resultSet2.getString("name");
            int countryId = resultSet2.getInt("country_id");
            Country country = countryMap.get(countryId);
            cityMap.put(id, new City(id, name, country));
        }
        return cityMap;
    }

    private static Map<Integer, Country> getIntegerCountryMap(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select ID, NAME FROM COUNTRY");
        ResultSet resultSet = preparedStatement.executeQuery();

        Map<Integer, Country> countryMap = new HashMap<Integer, Country>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            countryMap.put(id, new Country(id, name));
        }
        return countryMap;
    }
}
