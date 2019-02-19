package com.udacity.gradle.builditbigger;

public interface JokeCallbacks {

    void onJokeLoaded(String joke);

    void onJokeLoadError(Exception ex);
}