package com.synth3sisgame.synth3sisgame.utils;

import android.app.Application;

/**
 * Created by tariq on 9/9/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Caviar_Dreams_Bold.ttf");
    }
}