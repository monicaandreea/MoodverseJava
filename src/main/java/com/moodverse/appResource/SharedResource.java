package com.moodverse.appResource;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Background> backgrounds;
    private List<Ambience> ambiences;

    private static SharedResource sharedResource;

    private SharedResource() {
        backgrounds = new ArrayList<>();
        ambiences = new ArrayList<>();
    }

    public SharedResource getSharedResources() {
        if (sharedResource == null )
            sharedResource = new SharedResource();
        return sharedResource;
    }

    public List<Background> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(List<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public List<Ambience> getAmbiences() {
        return ambiences;
    }

    public void setAmbiences(List<Ambience> ambiences) {
        this.ambiences = ambiences;
    }

    @Override
    public String toString() {
        return "backgrounds " + backgrounds +
                ", ambiences " + ambiences;
    }
}
