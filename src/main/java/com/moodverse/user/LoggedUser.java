package com.moodverse.user;

import com.moodverse.appResource.*;

public class LoggedUser extends User {
    private static int loggedUserNumber = 2; // Admin has id = 1

    private String username;
    private String password;
    private String emailAddress;
    private DailyQuote quote;
    private ToDoList toDoList;
    private Streak streak;

    public LoggedUser(Background currentBackground, Timer timer, Magic8Ball magic8Ball, Ambience ambiance, String username, String password, String emailAddress, DailyQuote quote, ToDoList toDoList, Streak streak) {
        super(loggedUserNumber, currentBackground, timer, magic8Ball, ambiance);
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.quote = quote;
        this.toDoList = toDoList;
        this.streak = streak;
        loggedUserNumber++;
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

    public DailyQuote getQuote() {
        return quote;
    }

    public void setQuote(DailyQuote quote) {
        this.quote = quote;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public Streak getStreak() {
        return streak;
    }

    public void setStreak(Streak streak) {
        this.streak = streak;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", quote=" + quote +
                ", toDoList=" + toDoList +
                ", streak=" + streak +
                ", userId=" + userId +
                ", currentBackground=" + currentBackground +
                ", timer=" + timer +
                ", magic8Ball=" + magic8Ball +
                ", ambiance=" + ambiance +
                '}';
    }
}