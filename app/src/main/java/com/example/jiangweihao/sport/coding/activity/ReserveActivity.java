package com.example.jiangweihao.sport.coding.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.adapter.ReserveAdapter;
import com.example.jiangweihao.sport.coding.adapter.ReserveAdapter1;
import com.example.jiangweihao.sport.coding.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class ReserveActivity extends BaseActivity {

    public ReserveAdapter homeAdapter;
    private SearchView sv;
    private ImageView ivBack;
    private RecyclerView mRecyclerView;
    private ArrayList<AVObject> mList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.layout_home_list;
    }


    private void setAdapter() {
        homeAdapter = new ReserveAdapter(this, mList);

//        LinearLayoutManager rvLayoutManager = new LinearLayoutManager(this);
//        rvLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(homeAdapter);
    }



    @Override
    protected void initView() {
        super.initView();
        ivBack = findViewById(R.id.iv_back);

        mRecyclerView = findViewById(R.id.rv_home_list);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mList.clear();
        AVQuery<AVObject> query = new AVQuery<>("reserve");
        query.whereContains("user", SPUtils.INSTANCE.getString("user"));
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> avObjects, AVException avException) {
                if (avObjects.size() != 0) {
                    mList.addAll(avObjects);
                    homeAdapter.notifyDataSetChanged();
                } else {
                    return;
                    //Toast.makeText(getApplication(), "您要的商品不存在，请重新查找", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        mList.clear();
//        AVQuery<AVObject> avQuery = new AVQuery<>("reserve");
//        avQuery.orderByDescending("createdAt");
//        avQuery.include("user");
//        avQuery.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                if (e == null) {
//                    mList.addAll(list);
//                    homeAdapter.notifyDataSetChanged();
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });

        setAdapter();

    }

}
