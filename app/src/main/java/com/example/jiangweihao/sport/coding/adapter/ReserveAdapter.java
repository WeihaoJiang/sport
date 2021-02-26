package com.example.jiangweihao.sport.coding.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.MainActivity;
import com.example.jiangweihao.sport.coding.view.NormalDialog;

import java.util.ArrayList;
import java.util.HashMap;

public class ReserveAdapter extends RecyclerView.Adapter<ReserveAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<AVObject> listReserve;
    private NormalDialog mNormalDialog;

    private HashMap<String, Boolean> hashMapCan = new HashMap<>();


    public ReserveAdapter(Context mContext, ArrayList<AVObject> listBook) {
        this.mContext = mContext;
        this.listReserve = listBook;
        mNormalDialog = new NormalDialog(this.mContext);

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reserve_list_item1, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        final AVObject avObjectfind = listReserve.get(i);
        myHolder.tvName.setText(listReserve.get(i).get("name").toString());
        myHolder.tvDescribe.setText(listReserve.get(i).get("location").toString());
        myHolder.tvSell.setText(listReserve.get(i).get("time").toString());
        myHolder.tvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNormalDialog == null) {
                    mNormalDialog = new NormalDialog(mContext);
                }
                mNormalDialog.setTv_submit("确定");
                mNormalDialog.setOnNatvieListener(new NormalDialog.OnNatvieListener() {
                    @Override
                    public void onNative(String s) {

                        AVQuery<AVObject> avQuery = new AVQuery<>("SportSpace");
                        avQuery.getInBackground((String) avObjectfind.get("ssid"), new GetCallback<AVObject>() {
                            @Override
                            public void done(AVObject avObject, AVException e) {
                                // AVObject product = new AVObject("SportSpace");
                                hashMapCan = (HashMap<String, Boolean>) avObject.get("timecan");
                                hashMapCan.put(avObjectfind.get("time").toString(), true);
                                avObject.put("timecan", hashMapCan);
                                avObject.saveInBackground();
                            }
                        });

                        AVQuery<AVObject> avQueryre = new AVQuery<>("reserve");
                        avQueryre.getInBackground(avObjectfind.getObjectId(), new GetCallback<AVObject>() {
                            @Override
                            public void done(AVObject avObject, AVException e) {
                                // AVObject product = new AVObject("SportSpace");
                                avObject.deleteInBackground();
                                Toast.makeText(mContext, "已取消，请重新预约", Toast.LENGTH_SHORT).show();
                                mContext.startActivity(new Intent(mContext, MainActivity.class));

                            }
                        });

                        mNormalDialog.dismiss();
                        String s1 = avObjectfind.getObjectId();
//                        AVQuery.doCloudQueryInBackground("delete from reserve where objectId="+s1+"", new CloudQueryCallback<AVCloudQueryResult>() {
//                            @Override
//                            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
//                                // 如果 e 为空，说明保存成功
//                                if (e == null){
//
//
//                                }else {
//                                    Toast.makeText(mContext, "操作失败，请稍后再试", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });


                    }
                });


                mNormalDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listReserve.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvWriter, tvDescribe, tvSell, tvPhoto;
        private RelativeLayout rlItem;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.list_item_title);
            tvDescribe = itemView.findViewById(R.id.list_item_miaoshu);
            tvSell = itemView.findViewById(R.id.car_list_item_price);
            tvPhoto = itemView.findViewById(R.id.list_item_img);
            rlItem = itemView.findViewById(R.id.rll);
        }
    }
}
