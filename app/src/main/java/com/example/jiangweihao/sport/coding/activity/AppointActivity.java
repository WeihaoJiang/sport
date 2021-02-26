package com.example.jiangweihao.sport.coding.activity;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.adapter.AppointAdapter;
import com.example.jiangweihao.sport.coding.adapter.HomeAdapter;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

public class AppointActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<AVObject> mList = new ArrayList<>();
    private ImageView iv_back;

    private AppointAdapter appointAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.layout_home;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.rv_home_list);
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initUserData() {
        mList.clear();
        AVQuery<AVObject> avQuery = new AVQuery<>("_User");
        avQuery.orderByDescending("createdAt");
        avQuery.include("username");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++){
                        //if (list.get(i).get("email").toString().indexOf("@") == -1){
                            mList.add(list.get(i));
                        //}
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initUserData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        },500);


    }

    private void setAdapter() {
        appointAdapter = new AppointAdapter(this, mList);
//        LinearLayoutManager rvLayoutManager = new LinearLayoutManager(this);
//        rvLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(appointAdapter);
    }
}
