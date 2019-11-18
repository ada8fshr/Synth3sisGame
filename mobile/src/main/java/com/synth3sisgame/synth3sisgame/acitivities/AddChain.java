package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.adopters.AdapterAddFolder;
import com.synth3sisgame.synth3sisgame.models.Item;
import com.synth3sisgame.synth3sisgame.utils.Prefs;

import java.util.ArrayList;
import java.util.List;

import static android.widget.CompoundButton.*;

public class AddChain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Item> myList;
    AdapterAddFolder mAdapter;
    CheckBox seqCb, randomCb;
    boolean isSequantial = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chain);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Item item = new Item();
            item.fullName = "Sample " + i;
            myList.add(item);
        }

        mAdapter = new AdapterAddFolder(AddChain.this, myList, AddChain.this);
        recyclerView.setAdapter(mAdapter);


    }

    public void lableClicked(View view) {
        View rootView = View.inflate(AddChain.this, R.layout.custom_dialog_seq_random, null);
        seqCb = rootView.findViewById(R.id.seqCb);
        randomCb = rootView.findViewById(R.id.randomCb);
        randomCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    seqCb.setChecked(false);
                    isSequantial = false;
                }
            }
        });

        seqCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    randomCb.setChecked(false);
                    isSequantial = true;
                }
            }
        });
        new MaterialStyledDialog.Builder(AddChain.this)
                .setTitle("Add folder name")
                .setHeaderColor(R.color.colorAccent)
                .setPositiveText("Ok")
                .setNegativeText("cancel")
                .withDialogAnimation(false)
                .setIcon(R.drawable.log3)
                .setCustomView(rootView, 20, 20, 20, 0) // Old standard padding: .setCustomView(your_custom_view, 20, 20, 20, 0)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if(isSequantial){
                            Prefs.putString(AddChain.this, Prefs.DES_BTW_SCHEDULE_RANDOM, "0");
                            startActivity(new Intent(AddChain.this, TimeNameOfChainActivity.class));
                        }else{
                            Prefs.putString(AddChain.this, Prefs.DES_BTW_SCHEDULE_RANDOM, "1");
                            startActivity(new Intent(AddChain.this, TimeNameOfChainActivity.class));
                        }
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
