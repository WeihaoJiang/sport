package com.example.jiangweihao.sport.coding.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;

import java.util.ArrayList;

public class NearByActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private ArrayList<String> itemNameList = new ArrayList<>();
    TextView createView;

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mDescription;
        Button detail;
        ItemViewHolder(View itemView) {
            super(itemView);
            mDescription = itemView.findViewById(R.id.item_name);
            detail = itemView.findViewById(R.id.item_detail);
        }
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        private ArrayList<String> list;

        public ItemAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_item, viewGroup, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
            final String groupName = list.get(i);
            itemViewHolder.mDescription.setText(groupName);
            itemViewHolder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GroupDetailActivity.class);
                    intent.putExtra("name", groupName);
                    v.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        initView();
    }

    private void initView() {
        createView = (TextView) findViewById(R.id.createItem);
        createView.setOnClickListener(this);
        mRecyclerView = findViewById(R.id.item_list);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.location).setOnClickListener(this);
        itemNameList.add("游泳组");
        itemNameList.add("攀岩组");
        itemNameList.add("羽毛球组");

        ItemAdapter adapter = new ItemAdapter(itemNameList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back:
                finish();
                break;
            case R.id.location:
                createView.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.VISIBLE);
                break;
            case R.id.createItem:
                Intent intent = new Intent(this, CreateGroupItemActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}