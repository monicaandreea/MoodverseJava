package com.moodverse.dao.repository;

import com.moodverse.dao.configuration.DatabaseConfiguration;
import com.moodverse.user.LoggedUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements RowMapper<LoggedUser> {
    private static UserRepository userRepository;

    private UserRepository() {}

    public static UserRepository getUserRepository(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS users" +
                "(userId int PRIMARY KEY AUTO_INCREMENT, username varchar(50), password varchar(50), emailAddress varchar(50), currentBackgroundId int, timerId int, magic8BallId int, ambianceId int, quoteId int, toDoListId int, streakId int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LoggedUser> select() {
        String selectSql = "SELECT * FROM users";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<LoggedUser> loggedUsers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                LoggedUser loggedUser = mapRow(resultSet);
                loggedUsers.add(loggedUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedUsers;
    }

    public LoggedUser getLoggedUserById(int id) {
        String selectSql = "SELECT * FROM users WHERE userId=?";

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

    public void insert(int userId, String username, String password, String emailAddress, int currentBackgroundId, int timerId, int magic8BallId, int ambianceId, int quoteId, int toDoListId, int streakId) {
        String insertSql = "INSERT INTO users(userId, username, password, emailAddress, currentBackgroundId, timerId, magic8BallId, ambianceId, quoteId, toDoListId, streakId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, emailAddress);
            preparedStatement.setInt(5, currentBackgroundId);
            preparedStatement.setInt(6, timerId);
            preparedStatement.setInt(7, magic8BallId);
            preparedStatement.setInt(8, ambianceId);
            preparedStatement.setInt(9, quoteId);
            preparedStatement.setInt(10, toDoListId);
            preparedStatement.setInt(11, streakId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM users WHERE userId=?";

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
    public LoggedUser mapRow(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("userId");
        int currentBackgroundId = resultSet.getInt("currentBackgroundId");
        int timerId = resultSet.getInt("timerId");
        int magic8BallId = resultSet.getInt("magic8BallId");
        int ambianceId = resultSet.getInt("ambianceId");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String emailAddress = resultSet.getString("emailAddress");
        int quoteId = resultSet.getInt("quoteId");
        int toDoListId =  resultSet.getInt("toDoListId");
        int streakId = resultSet.getInt("streakId");

        return new LoggedUser(userId, currentBackgroundId, timerId, magic8BallId, ambianceId, username, password, emailAddress, quoteId, toDoListId, streakId);
    }
}
