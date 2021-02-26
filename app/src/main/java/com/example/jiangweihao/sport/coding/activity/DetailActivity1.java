package com.example.jiangweihao.sport.coding.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVObject;
import com.bin.david.form.core.SmartTable;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.bean.UserInfo1;

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


    public static void intentTo(String objectId, Context context) {

        mContext = context;
        Intent intent = new Intent(context, DetailActivity1.class);
        intent.putExtra("id", objectId);
        context.startActivity(intent);
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

                Toast.makeText(this,"欢迎加入兴趣团",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back:
                finish();
                break;
        }
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
