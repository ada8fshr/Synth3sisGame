package com.synth3sisgame.synth3sisgame.adopters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.models.Item;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by tariq on 12/22/2017.
 */

public class AdapterDriverList extends RecyclerView.Adapter<AdapterDriverList.MyViewHolder> {
    private List<Item> leaders;
    Context context;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_title;

        public MyViewHolder(View view) {
            super(view);
            user_title = view.findViewById(R.id.userName);
        }
    }

    public AdapterDriverList(Context context, List<Item> l, Activity activity) {
        this.context = context;
        this.leaders = l;
        this.activity = activity;
    }

    @Override
    public AdapterDriverList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new AdapterDriverList.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterDriverList.MyViewHolder holder, int position) {
        final Item listItem = leaders.get(position);
        holder.user_title.setText(listItem.fullName);
    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }

}
