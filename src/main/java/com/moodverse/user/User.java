package com.moodverse.user;

import com.moodverse.appResource.Ambience;
import com.moodverse.appResource.Background;
import com.moodverse.appResource.Magic8Ball;
import com.moodverse.appResource.Timer;

public class User {
    protected final int userId;
    protected Background currentBackground;
    protected Timer timer;
    protected Magic8Ball magic8Ball;
    protected Ambience ambiance;

    public User(int userId, Background currentBackground, Timer timer, Magic8Ball magic8Ball, Ambience ambiance) {
        this.userId = userId;
        this.currentBackground = currentBackground;
        this.timer = timer;
        this.magic8Ball = magic8Ball;
        this.ambiance = ambiance;
    }

    public int getUserId() {
        return userId;
    }

    public Background getCurrentBackground() {
        return currentBackground;
    }

    public void setCurrentBackground(Background currentBackground) {
        this.currentBackground = currentBackground;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Magic8Ball getMagic8Ball() {
        return magic8Ball;
    }

    public void setMagic8Ball(Magic8Ball magic8Ball) {
        this.magic8Ball = magic8Ball;
    }

    public Ambience getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(Ambience ambiance) {
        this.ambiance = ambiance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", currentBackground=" + currentBackground +
                ", timer=" + timer +
                ", magic8Ball=" + magic8Ball +
                ", ambiance=" + ambiance +
                '}';
    }
}
