package com.synth3sisgame.synth3sisgame;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class SplashActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }
}
