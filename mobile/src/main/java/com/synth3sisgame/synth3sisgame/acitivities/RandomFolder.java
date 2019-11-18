package com.synth3sisgame.synth3sisgame.acitivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.GridItemActivity;
import com.synth3sisgame.synth3sisgame.R;

import androidx.appcompat.app.AppCompatActivity;

public class RandomFolder extends AppCompatActivity {
    GridView gridView;

    String[] fruitNames = {"Apple","Orange","strawberry","Melon","Kiwi","Banana", "Apple","Orange","strawberry","Melon","Kiwi","Banana"};
    int[] fruitImages = {R.drawable.apple,R.drawable.oranges,R.drawable.strawberry,R.drawable.watermelon,R.drawable.kiwi,R.drawable.banana,
            R.drawable.apple,R.drawable.oranges,R.drawable.strawberry,R.drawable.watermelon,R.drawable.kiwi,R.drawable.banana};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name",fruitNames[i]);
                intent.putExtra("image",fruitImages[i]);
                startActivity(intent);

            }
        });


    }

    public void freequanccyClicked(View view) {
        startActivity(new Intent(this, FrequancyActivity.class));
    }

    public void labelBlockClicked(View view) {
        startActivity(new Intent(this, RandomLabelActivity.class));
    }

    public void addNewRandomBlock(View view) {
        startActivity(new Intent(this, AddBlock.class));
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
//            image.setImageResource(fruitImages[i]);
            return view1;



        }
    }
}
