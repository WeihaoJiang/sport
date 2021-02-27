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
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;
import com.example.jiangweihao.sport.coding.view.UserDialog;

import java.util.ArrayList;

public class GroupDetailAdapter extends RecyclerView.Adapter<GroupDetailAdapter.Holder>  {
    private Context mContext;
    private ArrayList<Activityinfo1> list;
    private UserDialog mNormalDialog;

    public GroupDetailAdapter(Context mContext, ArrayList<Activityinfo1> mlist) {
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
        final Activityinfo1 avObject = list.get(i);
        holder.list_item_title.setText(avObject.getName()+"       " + avObject.getTime() + " 举办 ");
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
