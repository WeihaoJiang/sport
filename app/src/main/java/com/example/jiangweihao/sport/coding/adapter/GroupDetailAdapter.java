package com.example.jiangweihao.sport.coding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.view.UserDialog;

import java.util.ArrayList;

public class GroupDetailAdapter extends RecyclerView.Adapter<GroupDetailAdapter.Holder>  {
    private Context mContext;
    private ArrayList<AVObject> list;
    private UserDialog mNormalDialog;

    public GroupDetailAdapter(Context mContext, ArrayList<AVObject> mlist) {
        this.mContext = mContext;
        this.list = mlist;
        mNormalDialog = new UserDialog(this.mContext);
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list,viewGroup,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        final AVObject avObject = list.get(i);
        holder.list_item_title.setText(avObject.get("username").toString());
        holder.list_item_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mNormalDialog == null) {
                    mNormalDialog = new UserDialog(mContext);
                }
                mNormalDialog.setTv_submit("确定");
                mNormalDialog.setOnNatvieListener(new UserDialog.OnNatvieListener() {
                    @Override
                    public void onNative(String s) {

//                        AVQuery<AVObject> avQueryre = new AVQuery<>("_User");
//                        avQueryre.getInBackground(avObject.getObjectId(), new GetCallback<AVObject>() {
//                            @Override
//                            public void done(AVObject avObject, AVException e) {
//                               avObject.put("email","198518072@qq.com");
//                               avObject.saveInBackground();
//                            }
//                        });
                        // 第一参数是 className,第二个参数是 objectId
                        AVObject todo = AVObject.createWithoutData("_User", list.get(i).getObjectId());

                        // 修改 content
                        todo.put("email",String.valueOf((int)(2+Math.random()*(10-1+1))));
                        // 保存到云端
                        todo.saveInBackground();

                        AVQuery<AVUser> userQuery = new AVQuery<>("_User");

                        Log.e("userQuery",userQuery.toString());
//                        AVQuery.doCloudQueryInBackground("update _User set email='198518072@qq.com' where objectId='"+list.get(i).getObjectId()+"'", new CloudQueryCallback<AVCloudQueryResult>() {
//                            @Override
//                            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
//                                // 如果 e 为空，说明保存成功
//                                if (e == null){
//                                    ToastUtils.INSTANCE.showToast(mContext,"设置成功");
//                                }
//                            }
//                        });
                        mNormalDialog.dismiss();
                    }
                });
                mNormalDialog.show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        public TextView list_item_title;
        public Holder(@NonNull View itemView) {
            super(itemView);
            list_item_title = itemView.findViewById(R.id.list_item_title);
        }
    }
}
