package com.example.jiangweihao.sport.coding.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

/**
 * Created by jiangweihao on 2018/10/13.
 */

public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {


    private ArrayList<Fragment> mList = new ArrayList<>();
    private Context context;
    private String mUrl;
    public static int currentIndex;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, ArrayList list) {
        super(fm);
        this.context = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = mList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("index",currentIndex);
        fragment.setArguments(bundle);
        return fragment;

    }


}
