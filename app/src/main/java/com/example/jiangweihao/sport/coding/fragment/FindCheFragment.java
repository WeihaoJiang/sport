package com.example.jiangweihao.sport.coding.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.message.MessageGPSEvent;
import com.example.jiangweihao.sport.coding.message.MessageSizeEvent;
import com.example.jiangweihao.sport.coding.message.MessageTimeEvent;
import com.example.jiangweihao.sport.coding.testwheelview.WheelViewActivity;
import com.example.jiangweihao.sport.coding.view.LinearLayoutItemView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangweihao on 2018/10/13.
 */

public class FindCheFragment extends BaseFragment implements View.OnClickListener {


    private List<String> truckTypeList = new ArrayList<>();
    private List<String> truckBrandList = new ArrayList<>();
    private EditText et_nane;
    private String find_one = "";
    private String find_two = "";

    private LinearLayout ll_edit;
    private Button btnSure;
    private TextView tvSure,tvReset;
    private LinearLayoutItemView ll_appraise_truck_type_select;
    private LinearLayoutItemView ll_appraise_brand_new;
    private LinearLayoutItemView ll_first_time;
    private LinearLayoutItemView ll_mileage;

    @Override
    public int getLayoutResId() {
        return R.layout.guche_home_b_start_appraise_area_layout;
    }

    @Override
    public void initView(View view) {
        ll_appraise_truck_type_select = (LinearLayoutItemView) view.findViewById(R.id.ll_appraise_truck_type_select);
        ll_appraise_brand_new = (LinearLayoutItemView) view.findViewById(R.id.ll_appraise_brand_new);
        ll_first_time = view.findViewById(R.id.ll_first_time);
        //ll_mileage = view.findViewById(R.id.ll_mileage);
        et_nane = view.findViewById(R.id.et_nane);
        btnSure = view.findViewById(R.id.btn_sure);
        tvSure = view.findViewById(R.id.tv_appraise_buy_car);
        tvReset = view.findViewById(R.id.car_apprise_reset);
        //ll_edit = view.findViewById(R.id.ll_edit);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void loadData() {

        ll_appraise_truck_type_select.setOnClickListener(this);
        ll_appraise_brand_new.setOnClickListener(this);
        ll_first_time.setOnClickListener(this);
        //ll_mileage.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        tvSure.setOnClickListener(this);
        tvReset.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ll_appraise_truck_type_select:
                Intent intentGPS = new Intent(getActivity(), WheelViewActivity.class);
                intentGPS.putExtra("data", "GPS");
                startActivity(intentGPS);
                break;
            case R.id.ll_appraise_brand_new:
                Intent intentSize = new Intent(getActivity(), WheelViewActivity.class);
                intentSize.putExtra("data", "size");
                startActivity(intentSize);
                break;
            case R.id.ll_first_time:
                Intent intentTime = new Intent(getActivity(), WheelViewActivity.class);
                intentTime.putExtra("data", "time");
                startActivity(intentTime);
                break;
            case R.id.tv_appraise_buy_car:
                AVQuery<AVObject> query = new AVQuery<>("SportSpace");
                query.whereContains("name", find_one+find_two);
                query.findInBackground(new FindCallback<AVObject>() {
                    @Override
                    public void done(List<AVObject> avObjects, AVException avException) {
                        if (avObjects.size() != 0) {
//                            DetailActivity.intentTo((String) avObjects.get(0).getObjectId(), getActivity());

                        } else {
                            Toast.makeText(FindCheFragment.this.getActivity(), "您要的场地不存在，请重新查找", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;

            case R.id.car_apprise_reset:
                AVObject product = new AVObject("SportSpace");
                product.put("name", find_one+find_two);


                product.put("image", new AVFile("imagePic", null));
                product.put("phone", "");
                product.put("location", "");
                product.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            Toast.makeText(getActivity(), "发布成功", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getActivity(), "发布失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                break;
//            case R.id.ll_mileage:
//                ll_edit.setVisibility(View.VISIBLE);

               // break;
            //case R.id.btn_sure:
//                if (et_nane.getText().toString().length() > 1){
//                    ll_mileage.setContentText(et_nane.getText().toString());
//                    ll_edit.setVisibility(View.GONE);
//                }else {
//                    ToastUtils.INSTANCE.showToast(getActivity(),"您还没有输入内容");
//                }

              //  break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMootGPAEvent(MessageGPSEvent messageGPSEvent){
        ll_appraise_truck_type_select.setContentText(messageGPSEvent.getMessage());
        find_one = messageGPSEvent.getMessage();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMootSizeEvent(MessageSizeEvent messageSizeEvent){
        ll_appraise_brand_new.setContentText(messageSizeEvent.getMessage());
        find_two = messageSizeEvent.getMessage();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMootTimeEvent(MessageTimeEvent messageTimeEvent){
        ll_first_time.setContentText(messageTimeEvent.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
