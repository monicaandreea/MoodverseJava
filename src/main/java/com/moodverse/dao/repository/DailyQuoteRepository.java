package com.moodverse.dao.repository;

import com.moodverse.appResource.DailyQuote;
import com.moodverse.dao.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DailyQuoteRepository implements RowMapper<DailyQuote> {
    private static DailyQuoteRepository dailyQuoteRepository;
    private DailyQuoteRepository() {}

    public static DailyQuoteRepository getDailyQuoteRepository(){
        if (dailyQuoteRepository == null){
            dailyQuoteRepository = new DailyQuoteRepository();
        }
        return dailyQuoteRepository;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS quotes" +
                "(dailyQuoteId int PRIMARY KEY AUTO_INCREMENT, author varchar(100), message varchar(500))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DailyQuote> select() {
        String selectSql = "SELECT * FROM quotes";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<DailyQuote> quotes= new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                DailyQuote dailyQuote = mapRow(resultSet);
                quotes.add(dailyQuote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quotes;
    }

    public DailyQuote getDailyQuoteById(int id) {
        String selectSql = "SELECT * FROM quotes WHERE quoteId=?";

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

    public void insert(int dailyQuoteId, String author, String message) {
        String insertSql = "INSERT INTO quotes(dailyQuoteId, author, message) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, dailyQuoteId);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, message);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String deleteSql = "DELETE FROM quotes WHERE quoteId=?";

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
    public DailyQuote mapRow(ResultSet resultSet) throws SQLException {
        int dailyQuoteId = resultSet.getInt("dailyQuoteId");
        String author = resultSet.getString("author");
        String message = resultSet.getString("message");

        return new DailyQuote(dailyQuoteId, author, message);
    }
}
