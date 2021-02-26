package com.example.jiangweihao.sport.coding.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
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


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class PublishFragment extends Fragment {
   // Context mBase;
    EditText mtitle,mprice,description,phoneNum,num;
    ImageView mImageViewSelect;
    TextView classify, user_message;
    EditText tele, e_mail, user_name;
    TextView user_mess;

    byte[] mImageBytes = null;
    Handler mHandler = new Handler();

    public PublishFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_publish, container, false);
        //classify = (TextView) view.findViewById(R.id.classify);
        mtitle = (EditText) view.findViewById(R.id.etpoduct_name);
        mprice = (EditText) view.findViewById(R.id.time);
        description = (EditText) view.findViewById(R.id.address);
        phoneNum = (EditText)view.findViewById(R.id.phone_num);
//        user_message = (TextView) view.findViewById(R.id.fill);
        mImageViewSelect = (ImageView) view.findViewById(R.id.imageview_select_publish);
//        user_mess= (TextView) view.findViewById(R.id.user_mess);
        num = view.findViewById(R.id.button_sub_num);

        Button mButtonSelect = (Button) view.findViewById(R.id.button_select_picture);
        mButtonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 42);
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 42 && resultCode == -1) {
            try {
                mImageViewSelect.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), data.getData()));
                mImageBytes = getBytes(this.getActivity().getContentResolver().openInputStream(data.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    }

}