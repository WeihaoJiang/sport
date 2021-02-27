package com.example.jiangweihao.sport.coding.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVObject;
import com.bin.david.form.core.SmartTable;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;
import com.example.jiangweihao.sport.coding.bean.UserInfo1;
import com.example.jiangweihao.sport.talking.ServerService;
import com.example.jiangweihao.sport.talking.activity.ChatActivity;
import com.example.jiangweihao.sport.talking.util.CostomUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DetailActivity1 extends BaseActivity implements View.OnClickListener {

    private String ID;
    private ImageView ivDetail, ivBack;
    private TextView tvDetailLocation, tvDetailName, tvDetailTime, tvPhone;
    private Button tvSubmit;
    private String phone;
    private static Context mContext;
    private HashMap<String, Boolean> hashMapNot = new HashMap<>();
    private SmartTable<UserInfo1> table;
    private List<UserInfo1> list = new ArrayList<>();
    private List<AVObject> mList = new ArrayList<>();


    public static void intentTo(Activityinfo1 activityinfo1, Context context) {

        mContext = context;
        Intent intent = new Intent(context, DetailActivity1.class);
        intent.putExtra("id", activityinfo1);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail1;
    }

    @Override
    protected void initView() {
        super.initView();
        ivBack = findViewById(R.id.iv_back);
        tvSubmit = findViewById(R.id.tv_sign_up);
        ivBack.setOnClickListener(this);
        tvSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_sign_up:
                    if (CostomUtil.isWiFiConnected(mContext)) {
                        startServer();
                        joinChat("牛气冲天" + " 的聊天室",CostomUtil.getIPAddress(mContext));
                    } else {
                        Toast.makeText(mContext, "加入失败，请稍后再试",
                                Toast.LENGTH_SHORT).show();
                    }
//                Toast.makeText(this,"欢迎加入兴趣团",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void startServer(){
        Intent intent = new Intent(mContext, ServerService.class);
        intent.putExtra("userName","牛气冲天");
        intent.putExtra("serverIp",CostomUtil.getIPAddress(mContext));
        mContext.startService(intent);
    }

    private void joinChat(String roomName, String roomIp){
        Intent intent = new Intent(mContext, ChatActivity.class);
        intent.putExtra("roomName",roomName);
        intent.putExtra("roomIp",roomIp);
        intent.putExtra("userName", "牛气冲天");
        mContext.startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        //for (int i = 0; i < DateUtils.get7date().size(); i++) {
        //}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        list.clear();

    }
}
