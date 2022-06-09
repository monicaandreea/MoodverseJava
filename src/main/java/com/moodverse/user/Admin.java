package com.moodverse.user;


public class Admin extends User {
    private static Admin admin;
    private String username;
    private String password;

    private Admin() {
        super(0, 1, 1, 1, 1);
        this.username = "admin";
        this.password = "admin";
    }

    public static Admin getAdmin(){
        if(admin == null){
            admin = new Admin();
        }
        return admin;
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
                ", currentBackgroundId=" + currentBackgroundId +
                ", timerId=" + timerId +
                ", magic8BallId=" + magic8BallId +
                ", ambianceId=" + ambianceId +
                '}';
    }
}
