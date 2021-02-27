package com.example.jiangweihao.sport.coding.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.adapter.ReserveAdapter1;
import com.example.jiangweihao.sport.coding.bean.UserInfo1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by jiangweihao on 2018/10/13.
 */

public class XiaoXiFragment extends BaseFragment implements View.OnClickListener {

    public ReserveAdapter1 mUserInfoAdapter;
    private SearchView sv;

    private RecyclerView mRecyclerView;
    private ArrayList<UserInfo1> mUserInfoList = new ArrayList<UserInfo1>();
    private String status;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_xiaoxi_list;
    }

    @Override
    public void initView(View view) {


//        status = (String) getArguments().get("status");
        mRecyclerView = view.findViewById(R.id.rv_xiaoxi_list);


    }

    @Override
    protected void loadData() {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.tv_map:
//                Toast.makeText(getContext(),"搜索附近活动团",Toast.LENGTH_LONG).show();
//                break;
        }
    }

    private void setAdapter() {
        mUserInfoAdapter = new ReserveAdapter1(this.getActivity(), mUserInfoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this.getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mUserInfoAdapter);
    }

    private void initData() {
        mUserInfoList.clear();
        SimpleDateFormat   formatter   =   new SimpleDateFormat("HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());

        UserInfo1 userInfo1 = new UserInfo1("游泳冠军群", formatter.format(curDate),"有人要去恭王府游泳吗？");
        UserInfo1 userInfo2 = new UserInfo1("go go go 攀岩群", formatter.format(curDate),"昨天的攀岩真的是太棒了？");
        UserInfo1 userInfo3 = new UserInfo1("羽毛球群", formatter.format(curDate),"谁有多余的羽毛球呀，亲？");
        mUserInfoList.add(userInfo1);
        mUserInfoList.add(userInfo2);
        mUserInfoList.add(userInfo3);
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
