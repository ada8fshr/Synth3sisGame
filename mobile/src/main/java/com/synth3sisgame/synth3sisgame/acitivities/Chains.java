package com.synth3sisgame.synth3sisgame.acitivities;

import android.os.Bundle;
import android.widget.ImageView;

import com.synth3sisgame.synth3sisgame.R;
import com.synth3sisgame.synth3sisgame.bean.Dir;
import com.synth3sisgame.synth3sisgame.viewbinder.DirectoryNodeBinder;
import com.synth3sisgame.synth3sisgame.viewbinder.FileNodeBinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewAdapter;

public class Chains extends AppCompatActivity {

    private RecyclerView rv;
    private TreeViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain);
        rv = (RecyclerView) findViewById(R.id.rv);
        initData();
    }

    private void initData() {
        List<TreeNode> nodes = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            TreeNode<Dir> app = new TreeNode<>(new Dir("app", "http://i.imgur.com/DvpvklR.png"));
            nodes.add(app);
            app.addChild(
                    new TreeNode<>(new Dir("manifests", "http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png"))
                            .addChild(new TreeNode<>(new Dir("AndroidManifest.xml", "http://i.imgur.com/DvpvklR.png")))
                            .addChild(new TreeNode<>(new Dir("AndroidManifest.xml", "http://i.imgur.com/DvpvklR.png")))
                            .addChild(new TreeNode<>(new Dir("AndroidManifest.xml", "http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png")))
            );
        }



        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TreeViewAdapter(nodes, Arrays.asList(new FileNodeBinder(), new DirectoryNodeBinder()));
        adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
            @Override
            public boolean onClick(TreeNode node, RecyclerView.ViewHolder holder) {
                if (!node.isLeaf()) {}
                return false;
            }

            @Override
            public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                DirectoryNodeBinder.ViewHolder dirViewHolder = (DirectoryNodeBinder.ViewHolder) holder;
                final ImageView ivArrow = dirViewHolder.getIvArrow();
                int rotateDegree = isExpand ? 90 : -90;
                ivArrow.animate().rotationBy(rotateDegree)
                        .start();
            }
        });
        rv.setAdapter(adapter);
    }

}
