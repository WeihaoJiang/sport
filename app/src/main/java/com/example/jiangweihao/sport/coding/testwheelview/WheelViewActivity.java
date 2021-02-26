package com.example.jiangweihao.sport.coding.testwheelview;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.message.MessageGPSEvent;
import com.example.jiangweihao.sport.coding.message.MessageSizeEvent;
import com.example.jiangweihao.sport.coding.message.MessageTimeEvent;
import com.example.jiangweihao.sport.coding.utils.DateUtils;
import com.example.jiangweihao.sport.coding.utils.GlideUtils;
import com.example.jiangweihao.sport.coding.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roshine
 * @date 2018/5/7 21:17
 * @blog http://www.roshine.xyz
 * @email roshines1016@gmail.com
 * @github https://github.com/Roben1016
 * @phone 136****1535
 * @desc
 */
public class WheelViewActivity extends Activity implements View.OnClickListener, OnWheelChangedListener, OnWheelScrollListener {

    private TextView tvCancel;
    private TextView btnSave;
    private TextView display;
    private WheelView mWheelView;
    //private String[] data;
    private ArrayList<String> date = new ArrayList<>();
    private HashMap<String, Boolean> hashMapCan = new HashMap<>();
    private HashMap<String, Boolean> hashMapNot = new HashMap<>();

    private ArrayWheelAdapter<String> mAdapter;
    private String mCurrentString;
    private String result;
    private String temp;
    private String ID;
    private Boolean frist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_wheel);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
        getWindow().setGravity(Gravity.BOTTOM);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        Intent intent = getIntent();
        temp = intent.getStringExtra("data");
        if (intent.getStringExtra("objectId") != null) {
            ID = intent.getStringExtra("objectId");
        }
        if (temp.equals("GPS")) {
            date.add("a区体育馆");
            date.add("b区体育馆");
            date.add("c区体育馆");
            date.add("林大体育馆");

        } else if (temp.equals("size")) {
            date.add("羽毛球馆");
            date.add("乒乓球馆");
            date.add("篮球馆");
            date.add("排球馆");

        } else if (temp.equals("time")) {
            for (int i = 0; i < DateUtils.get7date().size(); i++) {
                date.add(DateUtils.get7date().get(i) + DateUtils.get7week().get(i));
            }

        } else if (temp.equals("detail_time")) {

            //avObject.put("time",hashMap);
            for (int i = 0; i < DateUtils.get7date().size(); i++) {
                date.add(DateUtils.get7date().get(i));

            }
//frist = SPUtils.INSTANCE.getBoolean("frist");
            AVQuery<AVObject> avQuery = new AVQuery<>("SportSpace");
            avQuery.getInBackground(ID, new GetCallback<AVObject>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void done(AVObject avObject, AVException e) {
//                        for (int i = 0; i < DateUtils.get7date().size(); i++) {
//                            hashMapCan.put(DateUtils.get7date().get(i), true);
//                        }
                        hashMapNot = (HashMap<String, Boolean>) avObject.get("timenot");

                    if (avObject.get("timecan") == null){
                        for (int i = 0; i < DateUtils.get7date().size(); i++) {
                            hashMapCan.put(DateUtils.get7date().get(i)+"-9:00-10:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-10:00-11:00", true);                            hashMapCan.put(DateUtils.get7date().get(i)+"-10:00-11:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-11:00-12:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-12:00-13:00", true);

                            hashMapCan.put(DateUtils.get7date().get(i)+"-13:00-14:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-14:00-15:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-15:00-16:00", true);                            hashMapCan.put(DateUtils.get7date().get(i)+"-10:00-11:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-16:00-17:00", true);

                            hashMapCan.put(DateUtils.get7date().get(i)+"-17:00-18:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-18:00-19:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-19:00-20:00", true);
                            hashMapCan.put(DateUtils.get7date().get(i)+"-20:00-21:00", true);
                        }
                    }else {
                        hashMapCan = (HashMap<String, Boolean>) avObject.get("timecan");
                    }

                    if (hashMapNot != null) {
                        for (String key : hashMapNot.keySet()) {
                            //if (hashMapCan.containsKey(key)){
                            hashMapCan.remove(key, hashMapCan.get(key));
                            date.remove(key);
                           // }
                        }
                    }

                    avObject.put("timecan", hashMapCan);

                    avObject.saveInBackground();

                }
            });
        }
        tvCancel = (TextView) findViewById(R.id.tv_job_intension_cancel);
        btnSave = (TextView) findViewById(R.id.tv_job_intension_sure);
        display = (TextView) findViewById(R.id.tv_job_intension_display_edit);
        mWheelView = (WheelView) findViewById(R.id.wv_job_intension_jobtypes);
        mWheelView.setWheelBackground(R.color.white);
        btnSave.setOnClickListener(this);
        tvCancel.setOnClickListener(this);

    }

    private void initListener() {
        mWheelView.addChangingListener(this);
        mWheelView.addScrollingListener(this);
    }

    private void initData() {

        mAdapter = new ArrayWheelAdapter<>(this, date);
        mWheelView.setViewAdapter(mAdapter);//添加适配器
        mWheelView.setVisibleItems(7);// 设置可见条目数量
//		mViewJobType.setWheelBackground(R.color.white_alphe1);
        mAdapter.setTextColor(getResources().getColor(R.color.black));//设置所有字体的颜色   配合WheelView中的SHADOWS_COLORS透明度就可以设置中间文字高亮
//		mAdapter.setTextSize(20);//设置所有文本打字体大小
        mWheelView.setCurrentItem(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_job_intension_cancel:
                finish();
                break;
            case R.id.tv_job_intension_sure:
                if (temp.equals("GPS")) {
                    EventBus.getDefault().post(new MessageGPSEvent(display.getText().toString()));

                } else if (temp.equals("size")) {
                    EventBus.getDefault().post(new MessageSizeEvent(display.getText().toString()));

                } else if (temp.equals("time")) {
                    EventBus.getDefault().post(new MessageTimeEvent(display.getText().toString()));

                } else if (temp.equals("detail_time")) {
                    EventBus.getDefault().post(new MessageTimeEvent(display.getText().toString()));
                }
                finish();

                break;
        }
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        mCurrentString = date.get(newValue);
    }


    @Override
    public void onScrollingStarted(WheelView wheel) {
        //滚动开始时的监听
        int i = mWheelView.getCurrentItem();
        result = date.get(i);
    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
//滚动结束时的监听
        int currentItem = mWheelView.getCurrentItem();
//		Log.d(TAG, "选中的条目："+currentItem+"---"+data[currentItem]);
        mCurrentString = date.get(currentItem);
        display.setText(mCurrentString);
    }


}
