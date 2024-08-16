package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataSource {
    private static DataSource instance;
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    private DataSource(){
        try (InputStream input = DataSource.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            config.setJdbcUrl(properties.getProperty("url"));
            config.setUsername(properties.getProperty("username"));
            config.setPassword(properties.getProperty("password"));

            dataSource = new HikariDataSource(config);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getInstance() {
        if (instance == null){
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
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

}
