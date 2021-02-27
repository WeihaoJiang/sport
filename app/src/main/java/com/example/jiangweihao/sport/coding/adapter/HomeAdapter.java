package com.example.jiangweihao.sport.coding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.DetailActivity1;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;
import com.example.jiangweihao.sport.coding.view.NormalDialog;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<Activityinfo1> activityInfoList;
    private String status;
    private NormalDialog mNormalDialog;

    public HomeAdapter(Context mContext, ArrayList<Activityinfo1> activityInfoList, String s) {
        this.mContext = mContext;
        this.activityInfoList = activityInfoList;
        this.status = s;
//        mNormalDialog = new NormalDialog(this.mContext);

    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_list_item_newdefault, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyHolder viewHolder, int i) {
        final Activityinfo1 activityinfo = activityInfoList.get(i);
        viewHolder.tvName.setText(activityInfoList.get(i).getName());
        viewHolder.btJion.setText(activityInfoList.get(i).getSuccess()? "已成团":"未成团");
        if (i == 3 || i ==0 ){
            viewHolder.btJion.setText("未成团");
        }
        viewHolder.btJion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"欢迎加入本团",Toast.LENGTH_LONG).show();
                DetailActivity1.intentTo(activityinfo,mContext);

            }

        });

    }

    @Override
    public int getItemCount() {
        return activityInfoList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvWriter, tvDescribe, tvSell;
        private Button btJion;
        private ImageView ivPhoto;
        private RelativeLayout rlItem;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_title);
            btJion = itemView.findViewById(R.id.bt_join);

        }
    }
}
