package com.moodverse.dao.repository;

import com.moodverse.appResource.Ambience;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmbienceRepository implements RowMapper<Ambience> {
    private static AmbienceRepository ambienceRepository;
    private AmbienceRepository() {}

    public static AmbienceRepository getAmbienceRepository(){
        if (ambienceRepository == null){
            ambienceRepository = new AmbienceRepository();
        }
        return ambienceRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS ambiences" +
                "(ambienceId int PRIMARY KEY AUTO_INCREMENT, sound varchar(500), ambienceName varchar(100))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ambience> select() {
        String selectSql = "SELECT * FROM ambiences";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Ambience> ambiences= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Ambience ambience = mapRow(resultSet);
                ambiences.add(ambience);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ambiences;
    }

    public Ambience getAmbienceById(int id) {
        String selectSql = "SELECT * FROM ambiences WHERE ambienceId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void insert(int ambienceId, String sound, String ambienceName) {
        String insertSql = "INSERT INTO ambiences(ambienceId, sound, ambienceName) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, ambienceId);
            preparedStatement.setString(2, sound);
            preparedStatement.setString(3, ambienceName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void delete(int id) {
        String deleteSql = "DELETE FROM ambiences WHERE ambienceId=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ambience mapRow(ResultSet resultSet) throws SQLException {
        int ambienceId = resultSet.getInt("ambienceId");
        String sound = resultSet.getString("sound");
        String ambienceName = resultSet.getString("ambienceName");

        return new Ambience(ambienceId, sound, ambienceName);
    }
}
