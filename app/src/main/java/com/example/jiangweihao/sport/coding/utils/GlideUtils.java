package com.example.jiangweihao.sport.coding.utils;

import android.content.Context;
import android.graphics.Bitmap;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jiangweihao.sport.R;


public class GlideUtils {


    /**
     * 加载图片
     *
     * @param mContext
     * @param url
     * @param imageView
     * @param glideEnum
     */
    public static void loadImage(final Context mContext, String url, final ImageView imageView, GlideEnum glideEnum) {

        Glide.with(mContext)
                .load(url)
                .apply(new RequestOptions().error(glideEnum.getDefResID()))
                //.placeholder(glideEnum.getDefResID())
                //.error(glideEnum.getDefResID())
                .into(imageView);


    }




    public interface ImageLoadListener {
        void imageSuccess(Bitmap bitmap);
    }

    public enum GlideEnum {

        LaunchImg {
            @Override
            public int getDefResID() {
                return R.drawable.bg_normal;
            }
        },;


        public abstract int getDefResID();
    }


}
