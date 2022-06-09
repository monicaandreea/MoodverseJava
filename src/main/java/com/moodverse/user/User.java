package com.moodverse.user;

public class User {
    protected int userId;
    protected int currentBackgroundId;
    protected int timerId;
    protected int magic8BallId;
    protected int ambianceId;

    public User(int userId, int currentBackgroundId, int timerId, int magic8BallId, int ambianceId) {
        this.userId = userId;
        this.currentBackgroundId = currentBackgroundId;
        this.timerId = timerId;
        this.magic8BallId = magic8BallId;
        this.ambianceId = ambianceId;
    }
}
