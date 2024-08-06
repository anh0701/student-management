package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();
    private Connection connection;

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                System.exit(1);
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean connected() {
        String url = DatabaseConfig.getDbUrl();
        String username = DatabaseConfig.getDbUsername();
        String password = DatabaseConfig.getDbPassword();
        try{
            connection = DriverManager.getConnection(url, username, password);
            return  true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

//    public ResultSet execQuery(String query) throws SQLException {
//        return this.connection.createStatement().executeQuery(query);
//    }
//
//    public ResultSet queryWithParameter(String query, Object... params) throws SQLException {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            for (int i = 0; i < params.length; i++) {
//                preparedStatement.setObject(i + 1, params[i]);
//            }
//            return preparedStatement.executeQuery();
//    }


    public static String getDbUrl() {
        return properties.getProperty("url");
    }

    public static String getDbUsername() {
        return properties.getProperty("username");
    }

    public static String getDbPassword() {
        return properties.getProperty("password");
    }
}
