package com.moodverse.dao.repository;

import com.moodverse.appResource.Background;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackgroundRepository implements RowMapper<Background> {
    private static BackgroundRepository backgroundRepository;
    private BackgroundRepository() {}

    public static BackgroundRepository getBackgroundRepository(){
        if (backgroundRepository == null){
            backgroundRepository = new BackgroundRepository();
        }
        return backgroundRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS backgrounds" +
                "(backgroundId int PRIMARY KEY AUTO_INCREMENT, image varchar(500), backgroundName varchar(100))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Background> select() {
        String selectSql = "SELECT * FROM backgrounds";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Background> backgrounds= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Background background = mapRow(resultSet);
                backgrounds.add(background);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return backgrounds;
    }

    public Background getBackgroundById(int id) {
        String selectSql = "SELECT * FROM backgrounds WHERE backgroundId=?";

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

    public void insert(int backgroundId, String image, String backgroundName) {
        String insertSql = "INSERT INTO backgrounds(backgroundId, image, backgroundName) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, backgroundId);
            preparedStatement.setString(2, image);
            preparedStatement.setString(3, backgroundName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM backgrounds WHERE backgroundId=?";

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
    public Background mapRow(ResultSet resultSet) throws SQLException {
        int backgroundId = resultSet.getInt("backgroundId");
        String image = resultSet.getString("image");
        String backgroundName = resultSet.getString("backgroundName");

        return new Background(backgroundId, image, backgroundName);
    }
}
