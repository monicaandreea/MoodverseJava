package com.moodverse.appResource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Streak {
    private int no_days;
    private Date last_date;

    public Streak() {
        this.no_days = 1;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.last_date = new Date();
    }

    public int getNo_days() {
        return no_days;
    }

    public void setNo_days() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date today = new Date();
        Date nextDayStreak = new Date(this.last_date.getTime() + (1000 * 60 * 60 * 24));

        if(formatter.format(today).equals(formatter.format(nextDayStreak))) this.no_days += 1;
        else this.no_days = 0;

        this.last_date = today;
    }

    public Date getLast_date() {
        return last_date;
    }

    @Override
    public String toString() {
        return "Streak{" +
                "no_days=" + no_days +
                ", last_date=" + last_date +
                '}';
    }
}

/* TEST
    public void setNo_days() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date today = new Date();
        Date nextDayStreak = new Date(this.last_date.getTime() + (1000 * 60 * 60 * 24));

        Date maine = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Date poimaine = new Date(maine.getTime() + (1000 * 60 * 60 * 24));
        System.out.println("poimaine este "+ poimaine);
        System.out.println("next day is "+ nextDayStreak);

        if(formatter.format(poimaine).equals(formatter.format(nextDayStreak))) this.no_days += 1;
        else this.no_days = 0;

        this.last_date = maine;
    }
 */
