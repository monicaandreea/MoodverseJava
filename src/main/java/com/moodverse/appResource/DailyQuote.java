package com.moodverse.appResource;

public class DailyQuote {
    private int dailyQuoteId;
    private String author;
    private String message;

    public DailyQuote(int dailyQuoteId, String author, String message) {
        this.dailyQuoteId = dailyQuoteId;
        this.author = author;
        this.message = message;
    }

    public int getDailyQuoteId() {
        return dailyQuoteId;
    }

    public void setDailyQuoteId(int dailyQuoteId) {
        this.dailyQuoteId = dailyQuoteId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DailyQuote{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
