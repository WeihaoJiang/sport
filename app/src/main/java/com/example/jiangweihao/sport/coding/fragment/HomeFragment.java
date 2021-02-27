package com.example.jiangweihao.sport.coding.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.GroupDetailActivity;
import com.example.jiangweihao.sport.coding.activity.MainActivity;
import com.example.jiangweihao.sport.coding.activity.NearByActivity;
import com.example.jiangweihao.sport.coding.adapter.HomeAdapter;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;
import com.example.jiangweihao.sport.coding.utils.DateUtils;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by jiangweihao on 2018/10/13.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    public HomeAdapter mSwimmingAdapter;
    private SearchView sv;
    private ImageView mSwimmingBack,mClimbBack,mBadmintonBack;
    private Button tv_map;
    private RecyclerView mSwimmingRecyclerView,mClimbRecyclerView,mBadmintonRecyclerView;
    private List<Activityinfo1> mSwimmingList = new ArrayList<Activityinfo1>();
    private List<Activityinfo1> mClimbList = new ArrayList<Activityinfo1>();
    private List<Activityinfo1> mBadmintonList = new ArrayList<Activityinfo1>();
    private String status;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_home;
    }

    @Override
    public void initView(View view) {
        status = (String) getArguments().get("status");
        mSwimmingRecyclerView = view.findViewById(R.id.rv_swimming_list);
        mClimbRecyclerView = view.findViewById(R.id.rv_climb_list);
        mBadmintonRecyclerView = view.findViewById(R.id.rv_badminton_list);
        tv_map = view.findViewById(R.id.tv_map);
        mSwimmingBack = view.findViewById(R.id.iv_swimming_back);
        mClimbBack = view.findViewById(R.id.iv_climb_back);
        mBadmintonBack = view.findViewById(R.id.iv_badminton_back);
        mSwimmingBack.setOnClickListener(this);
        mClimbBack.setOnClickListener(this);
        mBadmintonBack.setOnClickListener(this);
        tv_map.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), GroupDetailActivity.class);
        switch (v.getId()) {
            case R.id.tv_map:
//                Toast.makeText(getContext(),"搜索附近活动团",Toast.LENGTH_LONG).show();
                if (getActivity() != null) {
                    getActivity().startActivity(new Intent(getActivity(), NearByActivity.class));
                }
                break;
            case R.id.iv_swimming_back:
                intent.putExtra("name","游泳队");
                break;
            case R.id.iv_climb_back:
                intent.putExtra("name","攀岩队");
//                bundle.putSerializable("activity",(Serializable)mClimbList);
                break;
            case R.id.iv_badminton_back:
                intent.putExtra("name","羽毛球队");
                break;
        }
        getContext().startActivity(intent);
    }

    private void setAdapter() {
        mSwimmingAdapter = new HomeAdapter(this.getActivity(), mSwimmingList, status);
        mSwimmingRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        mSwimmingRecyclerView.addItemDecoration(new RecycleViewDivider(this.getActivity(), LinearLayoutManager.VERTICAL));
        mSwimmingRecyclerView.setAdapter(mSwimmingAdapter);

        HomeAdapter mClimbAdapter = new HomeAdapter(this.getActivity(), mClimbList, status);
        mClimbRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        mClimbRecyclerView.addItemDecoration(new RecycleViewDivider(this.getActivity(), LinearLayoutManager.VERTICAL));
        mClimbRecyclerView.setAdapter(mClimbAdapter);

        HomeAdapter mBadmintonAdapter = new HomeAdapter(this.getActivity(), mBadmintonList, status);
        mBadmintonRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        mBadmintonRecyclerView.addItemDecoration(new RecycleViewDivider(this.getActivity(), LinearLayoutManager.VERTICAL));
        mBadmintonRecyclerView.setAdapter(mBadmintonAdapter);
    }


    private byte[] Bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
    private void initData() {
        mSwimmingList.clear();
        Activityinfo1 activityinfo1 = new Activityinfo1("火爆的游泳团",10 ,DateUtils.getDateString(9),"北京市朝阳区天辰东路11号");
        activityinfo1.setNum(3);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.panyan);
        activityinfo1.setImage(Bitmap2Bytes(bitmap));
        Activityinfo1 activityinfo2= new Activityinfo1("地表最强游泳团",10 ,DateUtils.getDateString(7),"北京市丰台区丰体北路与西四环南路交叉路口往西南约200米(丰台体育中心)");
        activityinfo2.setNum(4);
        Activityinfo1 activityinfo3= new Activityinfo1("5连冠游泳团",10 ,DateUtils.getDateString(4),"北京市海淀区复兴路40号院75号(地铁玉泉路站)");
        activityinfo3.setNum(1);
        mSwimmingList.add(activityinfo1);
        mSwimmingList.add(activityinfo2);
        mSwimmingList.add(activityinfo3);

        mClimbList.clear();
        Activityinfo1 activityinfo4= new Activityinfo1("不服输攀岩",10 ,DateUtils.getDateString(3),"北京市朝阳区西坝河南路4号");
        activityinfo4.setNum(0);
        Activityinfo1 activityinfo5 = new Activityinfo1("打破极限攀岩",15 ,DateUtils.getDateString(0),"北清路68号院用友软件园北区16号楼D座-1层");
        activityinfo5.setNum(1);
        mClimbList.add(activityinfo4);
        mClimbList.add(activityinfo5);
//        mClimbList.add(activityinfo6);

        mBadmintonList.clear();
        Activityinfo1 activityinfo7 = new Activityinfo1("望京羽毛球团",18 ,DateUtils.getDateString(3),"丰台区顺发路玉泉营博锐体育园内");
        activityinfo7.setNum(8);
        Activityinfo1 activityinfo6= new Activityinfo1("羽毛团",50 ,DateUtils.getDateString(6),"农展南路1号朝阳公园");
        activityinfo6.setNum(32);
        mBadmintonList.add(activityinfo6);
        mBadmintonList.add(activityinfo7);
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
