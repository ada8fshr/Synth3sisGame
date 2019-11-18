package com.synth3sisgame.synth3sisgame.adopters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.acitivities.AddChain;
import com.synth3sisgame.synth3sisgame.acitivities.RandomFolder;
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RandomAddFolderAdopter extends RecyclerView.Adapter<RandomAddFolderAdopter.MyViewHolder> {
    private List<Item> leaders;
    Context context;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_title;
        public RelativeLayout itemAddFolder;

        public MyViewHolder(View view) {
            super(view);
            user_title = view.findViewById(R.id.userName);
            itemAddFolder = view.findViewById(R.id.itemAddFolder);
        }
    }

    public RandomAddFolderAdopter(Context context, List<Item> l, Activity activity) {
        this.context = context;
        this.leaders = l;
        this.activity = activity;
    }

    @Override
    public RandomAddFolderAdopter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new RandomAddFolderAdopter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RandomAddFolderAdopter.MyViewHolder holder, int position) {
        final Item listItem = leaders.get(position);
        holder.user_title.setText(listItem.fullName);
        holder.itemAddFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, RandomFolder.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }

}
