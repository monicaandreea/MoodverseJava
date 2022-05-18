package com.moodverse.dao.repository;

import com.moodverse.appResource.Timer;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimerRepository implements RowMapper<Timer> {
    private static TimerRepository timerRepository;
    private TimerRepository() {}

    public static TimerRepository getTimerRepository(){
        if (timerRepository == null){
            timerRepository = new TimerRepository();
        }
        return timerRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS timers" +
                "(timerId int PRIMARY KEY AUTO_INCREMENT, hours int, minutes int, seconds int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Timer> select() {
        String selectSql = "SELECT * FROM timers";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Timer> timers= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Timer timer = mapRow(resultSet);
                timers.add(timer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return timers;
    }

    public Timer getTimerById(int id) {
        String selectSql = "SELECT * FROM timers WHERE timerId=?";

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

    public void insert(int timerId, int hours, int minutes, int seconds) {
        String insertSql = "INSERT INTO timers(timerId, hours, minutes, seconds) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, timerId);
            preparedStatement.setInt(2, hours);
            preparedStatement.setInt(3, minutes);
            preparedStatement.setInt(4, seconds);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String deleteSql = "DELETE FROM timers WHERE timerId=?";

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
    public Timer mapRow(ResultSet resultSet) throws SQLException {
        int timerId = resultSet.getInt("timerId");
        int hours = resultSet.getInt("hours");
        int minutes = resultSet.getInt("minutes");
        int seconds = resultSet.getInt("seconds");

        return new Timer(timerId, hours, minutes, seconds);
    }
}
