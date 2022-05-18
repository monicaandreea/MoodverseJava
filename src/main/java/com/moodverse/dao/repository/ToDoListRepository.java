package com.moodverse.dao.repository;

import com.moodverse.appResource.ToDoList;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListRepository implements RowMapper<ToDoList> {
    private static ToDoListRepository toDoListRepository;
    private ToDoListRepository() {}

    public static ToDoListRepository getToDoListRepository(){
        if (toDoListRepository == null){
            toDoListRepository = new ToDoListRepository();
        }
        return toDoListRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS toDoLists" +
                "(toDoListId int PRIMARY KEY AUTO_INCREMENT, title varchar(150), progress double(5,2))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ToDoList> select() {
        String selectSql = "SELECT * FROM toDoLists";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<ToDoList> toDoLists = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                ToDoList toDoList = mapRow(resultSet);
                toDoLists.add(toDoList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toDoLists;
    }

    public ToDoList getToDoListById(int id) {
        String selectSql = "SELECT * FROM toDoLists WHERE toDoListId=?";

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

    public void insert(int toDoListId, String title, Double progress) {
        String insertSql = "INSERT INTO toDoLists(toDoListId, title, progress) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, toDoListId);
            preparedStatement.setString(2, title);
            preparedStatement.setDouble(3, progress);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM toDoLists WHERE toDoListId=?";

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
    public ToDoList mapRow(ResultSet resultSet) throws SQLException {
        int toDoListId = resultSet.getInt("toDoListId");
        String title = resultSet.getString("title");
        double progress = resultSet.getDouble("progress");

        return new ToDoList(toDoListId, title, progress);
    }

}
