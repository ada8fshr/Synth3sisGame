package com.synth3sisgame.synth3sisgame.adaptors;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.model.FolderModel;

import java.util.ArrayList;

public class FolderAdaptorAdapter extends WearableListView.Adapter{

    private ArrayList<FolderModel> elements = null;
    private Context context = null;
    private final LayoutInflater layoutInflater;

    public FolderAdaptorAdapter(Context context, ArrayList<FolderModel> elements){
        this.elements = elements;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);

    }

    public static class ItemViewHolder extends WearableListView.ViewHolder{

        private TextView textView;
        private ImageView checkBox;
        private LinearLayout base_layout;
        public ItemViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.subjects);
            checkBox = itemView.findViewById(R.id.circle);
            base_layout = itemView.findViewById(R.id.base_layout);
        }

    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, final int i) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        TextView textView = itemViewHolder.textView;
        final ImageView imageView = itemViewHolder.checkBox;
        LinearLayout base_layout = itemViewHolder.base_layout;
        textView.setText(elements.get(i).folderName);
        if(elements.get(i).isTick){
            imageView.setBackgroundResource(R.drawable.tick);
        }else{
            imageView.setBackgroundResource(R.drawable.cross1);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(elements.get(i).isTick){
                    elements.get(i).isTick = false;
                    imageView.setBackgroundResource(R.drawable.cross1);
                }else{
                    elements.get(i).isTick = true;
                    imageView.setBackgroundResource(R.drawable.tick);
                }
            }
        });

        base_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "asd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        return new ItemViewHolder(layoutInflater.inflate(R.layout.listitem,null));
    }
}

