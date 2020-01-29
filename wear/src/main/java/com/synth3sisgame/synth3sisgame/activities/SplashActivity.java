package com.synth3sisgame.synth3sisgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import com.synth3sisgame.synth3sisgame.R;

public class SplashActivity extends WearableActivity {

    int timer = 2000;
    Thread th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timer);
                    startActivity(new Intent(SplashActivity.this, FolderActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();
        // Enables Always-on
        setAmbientEnabled();
    }
}
