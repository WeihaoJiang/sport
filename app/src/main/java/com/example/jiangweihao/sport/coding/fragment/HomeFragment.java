package com.example.jiangweihao.sport.coding.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.jiangweihao.sport.BuildConfig;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.NearByActivity;
import com.example.jiangweihao.sport.coding.adapter.HomeAdapter;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by jiangweihao on 2018/10/13.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    public HomeAdapter homeAdapter;
    private SearchView sv;

    private Button tv_map;
    private RecyclerView mRecyclerView;
    private ArrayList<Activityinfo1> mList = new ArrayList<Activityinfo1>();
    private String status;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_home;
    }

    @Override
    public void initView(View view) {


        status = (String) getArguments().get("status");
        mRecyclerView = view.findViewById(R.id.rv_home_list);
        tv_map = view.findViewById(R.id.tv_map);
        tv_map.setOnClickListener(this);
    }

    @Override
    protected void loadData() {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_map:
//                Toast.makeText(getContext(),"搜索附近活动团",Toast.LENGTH_LONG).show();
                if (getActivity() != null) {
                    getActivity().startActivity(new Intent(getActivity(), NearByActivity.class));
                }
                break;
        }
    }

    private void setAdapter() {
        homeAdapter = new HomeAdapter(this.getActivity(), mList, status);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this.getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mList.clear();
        SimpleDateFormat   formatter   =   new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        for (int i = 0; i<=4;i++){
            Date curDate =  new Date(System.currentTimeMillis());
            Activityinfo1 activityinfo = new Activityinfo1("火爆的游泳团",10+i ,formatter.format(curDate),"望京东");
            mList.add(activityinfo);
        }
    }


    private void loadSearchData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        setAdapter();
    }
}
