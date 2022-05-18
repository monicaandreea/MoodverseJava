package com.moodverse.service;


import com.moodverse.dao.configuration.DatabaseConfiguration;
import com.moodverse.dao.repository.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static DatabaseService databaseService;
    private static Connection databaseConnection;

    private DatabaseService() {
        databaseConnection = DatabaseConfiguration.getDatabaseConnection();
    }

    public static DatabaseService getDatabaseService(){
        if(databaseService == null){
            databaseService = new DatabaseService();
        }
        return databaseService;
    }

    public static List<Object> readQuery(String sql, RowMapper rowMapper){
        Statement statement;
        List<Object> result = new ArrayList<>();
        try {
            statement = databaseConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));
            }

            resultSet.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void insertQuery(String sql){
        try {
            Statement statement = databaseConnection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateQuery(String sql){
        try {
            Statement statement = databaseConnection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
