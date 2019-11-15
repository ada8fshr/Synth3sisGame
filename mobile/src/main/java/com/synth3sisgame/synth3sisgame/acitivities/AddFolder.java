package com.synth3sisgame.synth3sisgame.acitivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.adopters.AdapterAddFolder;
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AddFolder extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Item> myList;
    AdapterAddFolder mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_folder);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Item item = new Item();
            item.fullName = "tariq "+i;
            myList.add(item);
        }

        mAdapter = new AdapterAddFolder(AddFolder.this, myList, AddFolder.this);
        recyclerView.setAdapter(mAdapter);
    }

    public void addClicked(View view) {
        View rootView = View.inflate(AddFolder.this, R.layout.custom_edittext_dialog, null);
        new MaterialStyledDialog.Builder(AddFolder.this)
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
                        EditText editText = (EditText) dialog.findViewById(R.id.commts);
                        Log.v("qwe", "===== " + editText.getText().toString());
                        if (editText.getText().toString().length() > 0) {
                            Item item = new Item();
                            item.fullName = editText.getText().toString();
                            myList.add(item);
                            mAdapter = new AdapterAddFolder(AddFolder.this, myList, AddFolder.this);
                            recyclerView.setAdapter(mAdapter);
                        }
                        hideKeyboard(AddFolder.this, editText);
                        dialog.dismiss();
                        Log.v("qwe", editText.getText().toString());
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }

    public static void hideKeyboard(Activity activity, EditText mEd) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEd.getWindowToken(), 0);
    }
}
