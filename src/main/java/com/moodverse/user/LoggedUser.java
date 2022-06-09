package com.moodverse.user;


public class LoggedUser extends User {
    private String username;
    private String password;
    private String emailAddress;
    private int quoteId;
    private int toDoListId;
    private int streakId;

    public LoggedUser(int userId, int currentBackgroundId, int timerId, int magic8BallId, int ambianceId, String username, String password, String emailAddress, int quoteId, int toDoListId, int streakId) {
        super(userId, currentBackgroundId, timerId, magic8BallId, ambianceId);
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.quoteId = quoteId;
        this.toDoListId = toDoListId;
        this.streakId = streakId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public int getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(int toDoListId) {
        this.toDoListId = toDoListId;
    }

    public int getStreakId() {
        return streakId;
    }

    public void setStreakId(int streakId) {
        this.streakId = streakId;
    }
}