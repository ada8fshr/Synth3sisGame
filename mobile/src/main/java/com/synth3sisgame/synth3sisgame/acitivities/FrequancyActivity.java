package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;
import top.defaults.view.PickerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Item;

public class FrequancyActivity extends AppCompatActivity {
    PickerView pickerView;
    TextView textView;
    String timeInCount = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequancy);
        pickerView = findViewById(R.id.pickerView);
        textView = findViewById(R.id.textView);
        pickerView.setItems(Item.freequancyItem(), new PickerView.OnItemSelectedListener<Item>() {
            @Override
            public void onItemSelected(Item item) {
                textView.setText(item.getFullText());
                timeInCount = item.getFullText();
            }
        });
        pickerView.setSelectedItemPosition(2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Caviar_Dreams_Bold.ttf");
        pickerView.setTypeface(typeface);
    }

    public void saveClicked(View view) {
//        Prefs.putString(this, Prefs.RANDOM_TIME, timeInCount);
    }
}
