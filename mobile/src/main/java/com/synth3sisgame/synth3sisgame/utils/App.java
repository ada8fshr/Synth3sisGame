package com.synth3sisgame.synth3sisgame.utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by tariq on 9/9/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Caviar_Dreams_Bold.ttf");
    }
}