package com.synth3sisgame.synth3sisgame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;

public class BlockActivity extends WearableActivity {

    TextView msg;
    int x;
    String speech = "This code is sample This code is sample";
    String[] result = speech.split("\\s");
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        msg = findViewById(R.id.msg);
        setAmbientEnabled();
    }

    @Override
    protected void onResume() {
        super.onResume();
        x=0;
        while(x < result.length -1) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    msg.setText(result[x]);
                }
            }, 1000);
        }

//        if(count>result.length-1){
//            if(count==0){
//                msg.append(result[count]);
//            } else {
//                msg.append(" " + result[count]);
//            }
//            count++;
//        }
    }
}
