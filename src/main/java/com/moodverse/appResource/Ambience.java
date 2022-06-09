package com.moodverse.appResource;

public class Ambience {
    private int ambienceId;
    private String sound;
    private String ambienceName;

    public Ambience(int ambienceId, String sound, String ambienceName) {
        this.ambienceId = ambienceId;
        this.sound = sound;
        this.ambienceName = ambienceName;
    }

    public int getAmbienceId() {
        return ambienceId;
    }

    public void setAmbienceId(int ambienceId) {
        this.ambienceId = ambienceId;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getAmbienceName() {
        return ambienceName;
    }

    public void setAmbienceName(String ambienceName) {
        this.ambienceName = ambienceName;
    }

    @Override
    public String toString() {
        return "ambienceId " + ambienceId +
                ", sound " + sound +
                ", ambienceName " + ambienceName;
    }
}
