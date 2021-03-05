package com.example.jiangweihao.sport.coding.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.adapter.GroupDetailAdapter;
import com.example.jiangweihao.sport.coding.adapter.HomeAdapter;
import com.example.jiangweihao.sport.coding.adapter.RecycleViewDivider;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;
import com.example.jiangweihao.sport.coding.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GroupDetailActivity extends AppCompatActivity implements View.OnClickListener {
    public HomeAdapter homeAdapter;
    public GroupDetailAdapter detailAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Activityinfo1> mList = new ArrayList<Activityinfo1>();
    private String status;
    private TextView mTitleName,mDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        mTitleName = findViewById(R.id.group_name);
        mDescription = findViewById(R.id.description);
        initData();
        mRecyclerView = findViewById(R.id.item_list);
        detailAdapter = new GroupDetailAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(detailAdapter);
        findViewById(R.id.join_group).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
    }

    private void initData() {
        mList.clear();
        String name = getIntent().getStringExtra("name");
        mTitleName.setText(name);

        if (name.equals("游泳队")){
            mDescription.setText("我们都是水中的鱼儿，游啊游，游着游着我们就拥有了美人鱼般优美的身体曲线。");
            Activityinfo1 activityinfo1 = new Activityinfo1("火爆的游泳团",10 , DateUtils.getDateString(9),"北京市朝阳区天辰东路11号");
            activityinfo1.setNum(3);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.panyan);
            Activityinfo1 activityinfo2= new Activityinfo1("地表最强游泳团",10 ,DateUtils.getDateString(7),"北京市丰台区丰体北路与西四环南路交叉路口往西南约200米(丰台体育中心)");
            activityinfo2.setNum(7);
            Activityinfo1 activityinfo3= new Activityinfo1("5连冠游泳团",10 ,DateUtils.getDateString(4),"北京市海淀区复兴路40号院75号(地铁玉泉路站)");
            activityinfo3.setNum(1);
            Activityinfo1 activityinfo4 = new Activityinfo1("朝阳区游泳团",10 ,DateUtils.getDateString(9),"北京市朝阳区");
            activityinfo1.setNum(0);
            Activityinfo1 activityinfo5= new Activityinfo1("小小游泳团",10 ,DateUtils.getDateString(7),"北京市丰台区丰体北路与西四环南路交叉路口往西南约200米(丰台体育中心)");
            activityinfo2.setNum(4);
            Activityinfo1 activityinfo6= new Activityinfo1("西三旗游泳团",10 ,DateUtils.getDateString(4),"北京市海淀区复兴路40号院75号(地铁玉泉路站)");
            activityinfo3.setNum(1);
            mList.add(activityinfo1);
            mList.add(activityinfo2);
            mList.add(activityinfo3);
            mList.add(activityinfo4);
            mList.add(activityinfo5);
            mList.add(activityinfo6);


        } else if (name.equals("攀岩队")){
            mDescription.setText("日复一日的工作是否让你感觉生活过于平淡，对生活没有一丝激情，攀岩让你调动你的所有神经，释放你的肾上腺素体验攀登带给你的精彩体验。");
            Activityinfo1 activityinfo4= new Activityinfo1("不服输攀岩",10 ,DateUtils.getDateString(3),"北京市朝阳区西坝河南路4号");
            activityinfo4.setNum(0);
            Activityinfo1 activityinfo5 = new Activityinfo1("打破极限攀岩",15 ,DateUtils.getDateString(0),"北清路68号院用友软件园北区16号楼D座-1层");
            activityinfo5.setNum(1);
            Activityinfo1 activityinfo6 = new Activityinfo1("攀岩小战士",15 ,DateUtils.getDateString(0),"北清路68号院用友软件园北区16号楼D座-1层");
            mList.add(activityinfo4);
            mList.add(activityinfo5);
            mList.add(activityinfo6);
        } else if (name.equals("羽毛球队")) {
            mDescription.setText("羽毛球是所有运动中最可以让全身机能得到最大锻炼的一项运动，加入我们，一起为荷尔蒙窒息。");
            Activityinfo1 activityinfo7 = new Activityinfo1("望京羽毛球团",18 ,DateUtils.getDateString(3),"丰台区顺发路玉泉营博锐体育园内");
            activityinfo7.setNum(8);
            Activityinfo1 activityinfo6= new Activityinfo1("羽毛团",50 ,DateUtils.getDateString(6),"农展南路1号朝阳公园");
            activityinfo6.setNum(32);
            Activityinfo1 activityinfo8 = new Activityinfo1("小小望京羽毛球团",18 ,DateUtils.getDateString(3),"丰台区顺发路玉泉营博锐体育园内");
            activityinfo7.setNum(8);
            Activityinfo1 activityinfo9= new Activityinfo1("大家羽毛团",50 ,DateUtils.getDateString(6),"农展南路1号朝阳公园");
            mList.add(activityinfo6);
            mList.add(activityinfo7);
            mList.add(activityinfo8);
            mList.add(activityinfo9);
        }


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.join_group:
            case R.id.back:
                finish();
                break;
        }
    }
}