package com.moodverse.appResource;

public class Background {
    private int backgroundId;
    private String image;
    private String backgroundName;

    public Background(int backgroundId, String image, String backgroundName) {
        this.backgroundId = backgroundId;
        this.image = image;
        this.backgroundName = backgroundName;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    @Override
    public String toString() {
        return "backgroundId " + backgroundId +
                ", image " + image +
                ", backgroundName " + backgroundName;
    }
}
