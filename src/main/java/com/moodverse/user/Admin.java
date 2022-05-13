package com.moodverse.user;


import com.moodverse.appResource.Ambience;
import com.moodverse.appResource.Background;
import com.moodverse.appResource.Magic8Ball;
import com.moodverse.appResource.Timer;

public class Admin extends User {
    // TODO Singleton
    private String username;
    private String password;

    public Admin(Background currentBackground, Timer timer, Magic8Ball magic8Ball, Ambience ambiance, String username, String password) {
        super(1, currentBackground, timer, magic8Ball, ambiance);
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", currentBackground=" + currentBackground +
                ", timer=" + timer +
                ", magic8Ball=" + magic8Ball +
                ", ambiance=" + ambiance +
                '}';
    }
}
