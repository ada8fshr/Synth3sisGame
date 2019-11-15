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
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by tariq on 12/22/2017.
 */

public class AdapterAddFolder extends RecyclerView.Adapter<AdapterAddFolder.MyViewHolder> {
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

    public AdapterAddFolder(Context context, List<Item> l, Activity activity) {
        this.context = context;
        this.leaders = l;
        this.activity = activity;
    }

    @Override
    public AdapterAddFolder.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new AdapterAddFolder.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterAddFolder.MyViewHolder holder, int position) {
        final Item listItem = leaders.get(position);
        holder.user_title.setText(listItem.fullName);
        holder.itemAddFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               activity.startActivity(new Intent(activity, AddChain.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }

}
