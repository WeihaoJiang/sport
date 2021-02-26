package com.example.jiangweihao.sport.coding.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.AppointActivity;
import com.example.jiangweihao.sport.coding.activity.ReserveActivity;
import com.example.jiangweihao.sport.coding.utils.SPUtils;
import com.wuba.guchejia.kt.utils.ToastUtils;


/**
 * Created by jiangweihao on 2018/10/13.
 */

public class AboutMeFragment extends BaseFragment implements View.OnClickListener {



    RelativeLayout rl_my_setting, rl_my_about_us,rlCompany,rl_feedback;
    TextView tv_my_login_status,tv_title;
    private String status;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_me;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        tv_my_login_status = view.findViewById(R.id.tv_my_login_status);
        rl_my_setting = view.findViewById(R.id.rl_my_setting);
        rl_my_about_us = view.findViewById(R.id.rl_my_about_us);
        tv_my_login_status.setText(SPUtils.INSTANCE.getString("user"));
        rl_feedback = view.findViewById(R.id.rl_my_feedback);
        rl_feedback.setOnClickListener(this);
        rl_my_setting.setOnClickListener(this);
        rl_my_about_us.setOnClickListener(this);
        status = (String) getArguments().get("status");
        if (status.indexOf("@") == -1){
            rl_feedback.setVisibility(View.VISIBLE);
            rl_my_setting.setVisibility(View.GONE);
        } else {
            rl_feedback.setVisibility(View.GONE);
            rl_my_setting.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_my_feedback:
                Intent intent = new Intent(getActivity(), ReserveActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_my_about_us:
                ToastUtils.INSTANCE.showToast(getContext(),"黑大物联网");
                break;
            case R.id.rl_my_setting:
                startActivity(new Intent(getActivity(), AppointActivity.class));
                break;
        }
    }

}
