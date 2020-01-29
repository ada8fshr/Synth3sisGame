package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Prefs;

public class TimeNameOfChainActivity extends AppCompatActivity {

    Button fTime;
    public static Activity timeNameOfChainActivity;
    EditText titlechain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_name_of_chain);
        timeNameOfChainActivity = TimeNameOfChainActivity.this;
        fTime = findViewById(R.id.fTime);
        titlechain = findViewById(R.id.titlechain);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!Prefs.getString(this, Prefs.RANDOM_TIME).equals("")){
            fTime.setText(Prefs.getString(this, Prefs.RANDOM_TIME)+"Random bell per hour");
        }else if(!Prefs.getString(this, Prefs.SEQUANTIAL_MIN).equals("")){
            fTime.setText("Ring every " + Prefs.getString(this, Prefs.SEQUANTIAL_HOUR)
                    +" "+ Prefs.getString(this, Prefs.SEQUANTIAL_MIN));
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

    public void addChainInLableClicked(View view) {
        Prefs.putString(this, Prefs.CHAIN_TITLE, titlechain.getText().toString());
        startActivity(new Intent(this, AddBlock.class));
    }
}
