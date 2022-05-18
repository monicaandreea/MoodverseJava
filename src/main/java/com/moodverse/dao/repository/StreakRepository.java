package com.moodverse.dao.repository;

import com.moodverse.appResource.Streak;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreakRepository implements RowMapper<Streak> {
    private static StreakRepository streakRepository;
    private StreakRepository() {}

    public static StreakRepository getStreakRepository(){
        if (streakRepository == null){
            streakRepository = new StreakRepository();
        }
        return streakRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS streaks" +
                "(streakId int PRIMARY KEY AUTO_INCREMENT, numberOfDays int, date varchar(50))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Streak> select() {
        String selectSql = "SELECT * FROM streaks";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Streak> streaks= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
               Streak streak = mapRow(resultSet);
                streaks.add(streak);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return streaks;
    }

    public Streak getStreakById(int id) {
        String selectSql = "SELECT * FROM streaks WHERE streakId=?";

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

    public void insert(int streakId) {
        String insertSql = "INSERT INTO streaks(streakId) VALUES(?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, streakId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String deleteSql = "DELETE FROM streaks WHERE streakId=?";

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
    public Streak mapRow(ResultSet resultSet) throws SQLException {
        int streakId = resultSet.getInt("streakId");
        return new Streak(streakId);
    }
}
