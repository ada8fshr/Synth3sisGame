package com.synth3sisgame.synth3sisgame.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.Prefs;
import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.adaptors.FolderAdaptorAdapter;
import com.synth3sisgame.synth3sisgame.model.FolderModel;

import java.util.ArrayList;

public class FolderActivity extends Activity {

    private TextView subjects;
    String[] elements = { "Test Folder", "My Folder"};
    LinearLayout syncing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folderactivity);
        syncing = findViewById(R.id.syncing);
    }

    public void syncClicked(View view) {
        syncing.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Prefs.putString(FolderActivity.this, Prefs.f1name, "First Folder");
                Prefs.putString(FolderActivity.this, Prefs.f2name, "Testing");
                Prefs.putBool(FolderActivity.this, Prefs.f1b, true);
                Prefs.putBool(FolderActivity.this, Prefs.f1b, true);

                FolderModel f1 = new FolderModel();
                FolderModel f2 = new FolderModel();
                f1.folderName = Prefs.getString(FolderActivity.this, Prefs.f1name);
                f1.isTick = Prefs.getBool(FolderActivity.this, Prefs.f1b);
                f2.folderName = Prefs.getString(FolderActivity.this, Prefs.f2name);
                f2.isTick = Prefs.getBool(FolderActivity.this, Prefs.f2b);
                ArrayList<FolderModel> list = new ArrayList<>();
                list.add(f1);
                list.add(f2);
                WearableListView wearableListView = (WearableListView)findViewById(R.id.wearable_list);
                wearableListView.setAdapter(new FolderAdaptorAdapter(FolderActivity.this, list));
                syncing.setVisibility(View.GONE);
            }
        }, 15000);

    }
}
