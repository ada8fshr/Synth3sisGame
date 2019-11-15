package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;
import top.defaults.view.PickerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.utils.Item;

public class RandomPickerActivity extends AppCompatActivity {

    PickerView pickerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_picker);
        pickerView = findViewById(R.id.pickerView);
        textView = findViewById(R.id.textView);

        pickerView.setItems(Item.sampleItems(), new PickerView.OnItemSelectedListener<Item>() {
            @Override
            public void onItemSelected(Item item) {
                textView.setText(item.getText());
            }
        });
        pickerView.setSelectedItemPosition(4);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Caviar_Dreams_Bold.ttf");
        pickerView.setTypeface(typeface);
    }
}
