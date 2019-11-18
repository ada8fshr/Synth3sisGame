package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Prefs;

public class SplashActivity extends AppCompatActivity {

    int timer = 2000;
    Thread th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Prefs.putString(this, Prefs.SEQUANTIAL_MIN, "");
        Prefs.putString(this, Prefs.SEQUANTIAL_HOUR, "");
        Prefs.putString(this, Prefs.RANDOM_TIME, "");

        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timer);
                    startActivity(new Intent(SplashActivity.this, Dashboard.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();
    }
}
