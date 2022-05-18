package com.moodverse.dao.repository;

import com.moodverse.appResource.TaskPair;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements RowMapper<TaskPair> {
    private static TaskRepository taskRepository;
    private TaskRepository() {}

    public static TaskRepository getTaskRepository(){
        if (taskRepository == null){
            taskRepository = new TaskRepository();
        }
        return taskRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS tasks" +
                "(taskId int PRIMARY KEY AUTO_INCREMENT, toDoListId int, done boolean, task varchar(500))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TaskPair> select() {
        String selectSql = "SELECT * FROM tasks";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<TaskPair> tasks= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                TaskPair task = mapRow(resultSet);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public TaskPair getTaskById(int id) {
        String selectSql = "SELECT * FROM tasks WHERE taskId=?";

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

    public void insert(int taskPairId, int toDoListId, boolean done, String task) {
        String insertSql = "INSERT INTO tasks(taskPairId, toDoListId, done, task) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, taskPairId);
            preparedStatement.setInt(2, toDoListId);
            preparedStatement.setBoolean(3, done);
            preparedStatement.setString(4, task);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void delete(int id) {
        String deleteSql = "DELETE FROM tasks WHERE taskId=?";

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
    public TaskPair mapRow(ResultSet resultSet) throws SQLException {
        int taskPairId = resultSet.getInt("taskPairId");
        int toDoListId = resultSet.getInt("toDoListId");
        boolean done = resultSet.getBoolean("done");
        String task = resultSet.getString("task");

        return new TaskPair(taskPairId, toDoListId, task, done);
    }
}
