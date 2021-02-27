package com.example.jiangweihao.sport.coding.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.adapter.HomeAdapter;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GroupDetailActivity extends AppCompatActivity implements View.OnClickListener {
    public HomeAdapter homeAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Activityinfo1> mList = new ArrayList<Activityinfo1>();
    private String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        initData();
        mRecyclerView = findViewById(R.id.item_list);
        homeAdapter = new HomeAdapter(this, mList, status);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(homeAdapter);
        findViewById(R.id.join_group).setOnClickListener(this);
    }

    private void initData() {
        mList.clear();
        SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        for (int i = 0; i<=4;i++){
            Date curDate =  new Date(System.currentTimeMillis());
            Activityinfo1 activityinfo = new Activityinfo1("火爆的游泳团",10+i ,formatter.format(curDate),"望京东");
            mList.add(activityinfo);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.join_group:
                finish();
                break;
        }
    }
}