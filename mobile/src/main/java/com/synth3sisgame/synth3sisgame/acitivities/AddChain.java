package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.adopters.AdapterDriverList;
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AddChain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Item> myList;
    AdapterDriverList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chain);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Item item = new Item();
            item.fullName = "tariq "+i;
            myList.add(item);
        }

        mAdapter = new AdapterDriverList(AddChain.this, myList, AddChain.this);
        recyclerView.setAdapter(mAdapter);
    }
}
