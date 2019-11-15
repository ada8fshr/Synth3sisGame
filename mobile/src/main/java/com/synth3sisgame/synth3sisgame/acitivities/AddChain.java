package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.adopters.AdapterAddFolder;
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AddChain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Item> myList;
    AdapterAddFolder mAdapter;

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

        mAdapter = new AdapterAddFolder(AddChain.this, myList, AddChain.this);
        recyclerView.setAdapter(mAdapter);
    }

    public void lableClicked(View view) {
        View rootView = View.inflate(AddChain.this, R.layout.custom_dialog_seq_random, null);
        new MaterialStyledDialog.Builder(AddChain.this)
                .setTitle("Add folder name")
                .setHeaderColor(R.color.colorAccent)
                .setPositiveText("Ok")
                .setNegativeText("cancel")
                .withDialogAnimation(true)
                .setIcon(R.drawable.log3)
                .setCustomView(rootView, 20, 20, 20, 0) // Old standard padding: .setCustomView(your_custom_view, 20, 20, 20, 0)
                //.setCustomView(your_custom_view, 10, 20, 10, 20) // int left, int top, int right, int bottom
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                        EditText editText = (EditText) dialog.findViewById(R.id.commts);
//                        if (editText.getText().toString().length() > 0) {
//                            Item item = new Item();
//                            item.fullName = editText.getText().toString();
//                            myList.add(item);
//                            mAdapter = new AdapterAddFolder(AddChain.this, myList, AddChain.this);
//                            recyclerView.setAdapter(mAdapter);
//                        }
//                        dialog.dismiss();
//                        Log.v("qwe", editText.getText().toString());
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }

    public void addChainClicked(View view) {
        startActivity(new Intent(this, AddBlock.class));
    }
}
