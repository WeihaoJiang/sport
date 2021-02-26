package com.example.jiangweihao.sport.coding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.bean.UserInfo1;
import com.example.jiangweihao.sport.coding.view.NormalDialog;

import java.util.ArrayList;
import java.util.HashMap;

public class ReserveAdapter1 extends RecyclerView.Adapter<ReserveAdapter1.MyHolder> {

    private Context mContext;
    private ArrayList<UserInfo1> listReserve;
    private NormalDialog mNormalDialog;

    private HashMap<String, Boolean> hashMapCan = new HashMap<>();


    public ReserveAdapter1(Context mContext, ArrayList<UserInfo1> userInfoList) {
        this.mContext = mContext;
        this.listReserve = userInfoList;
        mNormalDialog = new NormalDialog(this.mContext);

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reserve_list_item1, viewGroup, false);
        ReserveAdapter1.MyHolder myHolder = new ReserveAdapter1.MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        final UserInfo1 userInfo = listReserve.get(i);
        myHolder.tvName.setText(listReserve.get(i).getName());
        myHolder.tvContent.setText(listReserve.get(i).getContent());
        myHolder.tvContentTime.setText(listReserve.get(i).getTime());
        myHolder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"进入聊天界面",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listReserve.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvWriter, tvContent, tvContentTime, tvPhoto;
        private RelativeLayout rlItem;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.list_item_title);
            tvContent = itemView.findViewById(R.id.list_item_xiao_xi);
            tvContentTime = itemView.findViewById(R.id.list_item_time);
            rlItem = itemView.findViewById(R.id.img_layout);
        }
    }
}
