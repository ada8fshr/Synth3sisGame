package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Prefs;

public class TimeNameOfChainActivity extends AppCompatActivity {

    Button fTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_name_of_chain);
        fTime = findViewById(R.id.fTime);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!Prefs.getString(this, Prefs.RANDOM_TIME).equals("")){
            fTime.setText(Prefs.getString(this, Prefs.RANDOM_TIME)+"Random bell per hour");
        }else if(!Prefs.getString(this, Prefs.SEQUANTIAL_MIN).equals("")){
            fTime.setText("Ring every " + Prefs.getString(this, Prefs.SEQUANTIAL_MIN)+" min");
        }else{
            fTime.setText("Not Set");
        }
    }

    public void timeFrameClicked(View view) {
        if(Prefs.getString(this, Prefs.DES_BTW_SCHEDULE_RANDOM).equals("0")){
            startActivity(new Intent(this, SequantialPikerActivity.class));
        }else{
            startActivity(new Intent(this, RandomPickerActivity.class));
        }
    }

    public void saveClicked(View view) {
        finish();
    }
}
