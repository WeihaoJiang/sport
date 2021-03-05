package com.example.jiangweihao.sport.coding.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.activity.MainActivity;
import com.example.jiangweihao.sport.coding.bean.Activityinfo1;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class PublishFragment extends Fragment {
   // Context mBase;
   TextView mtitle,mprice,description,phoneNum,num;
    ImageView mImageViewSelect;
    TextView classify, user_message;
    EditText tele, e_mail, user_name;
    TextView user_mess;

    Activityinfo1 activityinfo;
    byte[] mImageBytes = null;
    Handler mHandler = new Handler();

    public PublishFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getActivity().getIntent();
        activityinfo = (Activityinfo1) intent.getSerializableExtra("id");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_publish, container, false);
        //classify = (TextView) view.findViewById(R.id.classify);
        mtitle = (TextView) view.findViewById(R.id.etpoduct_name);
        mprice = (TextView) view.findViewById(R.id.time);
        description = (TextView) view.findViewById(R.id.address);
        phoneNum = (TextView)view.findViewById(R.id.phone_num);
        mImageViewSelect = (ImageView) view.findViewById(R.id.imageview_select_publish);
        num = view.findViewById(R.id.button_sub_num);
        return view;
    }
    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void onPause() {
        super.onPause();

    }
    private void setAdapter(){

    }
    @Override
    public void onResume() {
        super.onResume();
        initDate();
    }
    private void initDate(){
//        mtitle.setText(activityinfo.getName());
//        mprice.setText(activityinfo.getTime());
//        description.setText(activityinfo.getActivityAddress());
//        phoneNum.setText(String.valueOf(activityinfo.getTotalNum()));
//        num.setText(String.valueOf(activityinfo.getNum()));
//        if (activityinfo.getImage() != null){
//           Bitmap bitmap = BitmapFactory.decodeByteArray(activityinfo.getImage(), 0, activityinfo.getImage().length);
//            BitmapDrawable mBitmapDrawable = new BitmapDrawable(bitmap);
//            mImageViewSelect.setBackgroundDrawable(mBitmapDrawable);
//        }
    }
}