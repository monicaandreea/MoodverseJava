package com.moodverse.appResource;

public class DailyQuote {
    private String author;
    private String message;

    public DailyQuote(String author, String message) {
        this.author = author;
        this.message = message;
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
