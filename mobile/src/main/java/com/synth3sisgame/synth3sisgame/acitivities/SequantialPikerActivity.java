package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;
import top.defaults.view.PickerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Item;
import com.synth3sisgame.synth3sisgame.utils.Prefs;

public class SequantialPikerActivity extends AppCompatActivity {
    PickerView pickerView, pickerView1;
    TextView textView, textView1;
    String timeOne, timeTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequantial_piker);

        pickerView = findViewById(R.id.pickerView);
        textView = findViewById(R.id.textView);

        pickerView1 = findViewById(R.id.pickerView1);
        textView1 = findViewById(R.id.textView1);

        pickerView.setItems(Item.timing(), new PickerView.OnItemSelectedListener<Item>() {
            @Override
            public void onItemSelected(Item item) {
                textView.setText(item.getText() + " hours");
                timeOne = item.getText();
            }
        });
        pickerView.setSelectedItemPosition(4);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Caviar_Dreams_Bold.ttf");
        pickerView.setTypeface(typeface);

        pickerView1.setItems(Item.mins(), new PickerView.OnItemSelectedListener<Item>() {
            @Override
            public void onItemSelected(Item item) {
                textView1.setText(item.getText() + " mins");
                timeTwo = item.getText();
            }
        });
        pickerView1.setSelectedItemPosition(4);
        pickerView1.setTypeface(typeface);
    }

    public void saveClicked(View view) {
//        Prefs.putString(this, Prefs.SEQUANTIAL_HOUR, timeOne);
//        Prefs.putString(this, Prefs.SEQUANTIAL_MIN, timeTwo);
        finish();
    }
}
