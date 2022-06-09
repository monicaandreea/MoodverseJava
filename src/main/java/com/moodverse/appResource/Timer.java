package com.moodverse.appResource;

public class Timer {
    private int timerId;
    private int hours;
    private int minutes;
    private int seconds;

    public Timer(int timerId, int hours, int minutes, int seconds) {
        this.timerId = timerId;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getTimerId() {
        return timerId;
    }

    public void setTimerId(int timerId) {
        this.timerId = timerId;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
