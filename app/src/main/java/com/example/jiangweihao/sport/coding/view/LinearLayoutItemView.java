package com.example.jiangweihao.sport.coding.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;
import com.example.jiangweihao.sport.coding.utils.DisplayUtil;


/**
 * Created by Administrator on 2016/1/8.
 */
public class LinearLayoutItemView extends LinearLayout {
    public TextView tv_left;
    public TextView tv_context;
    public TextView tv_right;
    public ImageView iv_left;
    public ImageView iv_right;

    public CharSequence left_text;
    public CharSequence content_text;
    public CharSequence content_hint_text;
    public CharSequence right_text;
    public int left_img;
    public int right_img;
    public int right_text_color;
    public int content_text_color;
    public int content_text_error_color;
//    public LinearLayout ll_horizontal;

    public float leftTextSize;
    public boolean isShowBottomLine;
//    public View line_bottom;

    public LinearLayoutItemView(Context context) {
        this(context, null);
    }

    public LinearLayoutItemView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LinearLayoutItemView);
        left_text = a.getText(R.styleable.LinearLayoutItemView_leftText);
        content_text = a.getText(R.styleable.LinearLayoutItemView_contentText);
        content_hint_text = a.getText(R.styleable.LinearLayoutItemView_contentHintText);
        right_text = a.getText(R.styleable.LinearLayoutItemView_rightText);
        left_img = a.getResourceId(R.styleable.LinearLayoutItemView_leftIcon, 0);
        right_img = a.getResourceId(R.styleable.LinearLayoutItemView_rightIcon, 0);
        right_text_color = a.getColor(R.styleable.LinearLayoutItemView_rightTextColor, getResources().getColor(R.color.color_33));
        content_text_color = a.getColor(R.styleable.LinearLayoutItemView_contentTextColor, getResources().getColor(R.color.color_33));
        content_text_error_color = a.getColor(R.styleable.LinearLayoutItemView_contentErrorColor, getResources().getColor(R.color.red));
        leftTextSize = a.getDimension(R.styleable.LinearLayoutItemView_leftTextSize, DisplayUtil.sp2px(getContext(), 18));
        isShowBottomLine = a.getBoolean(R.styleable.LinearLayoutItemView_isShowBottomLine, true);
        a.recycle();
        initView();
        initText();

    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.linear_layout_item_normal, this);
//        ll_horizontal = (LinearLayout) findViewById(R.id.ll_horizontal);
//        ll_horizontal.setVisibility(View.VISIBLE);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_context = (TextView) findViewById(R.id.tv_content);
        tv_right = (TextView) findViewById(R.id.tv_right);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
//        line_bottom = findViewById(R.id.line_bottom);
    }

    public void initText() {
        setLeftText(left_text);
        setContentText(content_text);
        setRightText(right_text);
        if (leftTextSize != 0) {
            tv_left.getPaint().setTextSize(leftTextSize);
        }
        if (!TextUtils.isEmpty(content_hint_text)) {
            tv_context.setHint(content_hint_text);
        }
        if (left_img == 0) {
            iv_left.setVisibility(View.GONE);
        } else {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(left_img);
        }

//        line_bottom.setVisibility(isShowBottomLine ? VISIBLE : GONE);
        setRightIcon(right_img);
    }

    /**
     * 设置内容
     * @param text
     */
    public void setContentText(CharSequence text) {
        tv_context.setVisibility(View.VISIBLE);
        tv_context.setHintTextColor(getResources().getColor(R.color.colorHintText));
        if (!TextUtils.isEmpty(text)) {
            tv_context.setText(text);
        } else {
            tv_context.setText("");
        }
    }

    /**
     * 设置left的图标
     */
    public void setLeftImage(int image) {
        if (image == 0) {
            iv_left.setVisibility(View.GONE);
        } else {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(image);
        }
    }

    public void setContentHintText() {
        tv_context.setVisibility(View.VISIBLE);
        tv_context.setHintTextColor(getResources().getColor(R.color.colorHintText));
        tv_context.setText("");
    }

    public void setContentHintErrorColor() {
        tv_context.setText("");
        tv_context.setHintTextColor(content_text_error_color);
    }

    /**
     * 获取内容 textview
     * @return
     */
    public TextView getContentTextView() {
        return tv_context;
    }

    /**
     * 设置左边的文字
     *
     * @param text
     */
    public void setLeftText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            tv_left.setVisibility(View.GONE);
        } else {
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText(text);
        }
    }

    /**
     * 设置右边的文字
     *
     * @param text
     */
    public void setRightText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            tv_right.setVisibility(View.GONE);
        } else {
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText(text);
            tv_right.setTextColor(right_text_color);
        }
    }


    public TextView getRightTextView() {
        return tv_right;
    }

    /**
     * 设置右边的icon
     *
     * @param resId
     */
    public void setRightIcon(int resId) {
        if (resId == 0) {
            iv_right.setVisibility(View.GONE);
        } else {
            iv_right.setVisibility(View.VISIBLE);
            iv_right.setImageResource(resId);
        }
    }

    /**
     * 给右边的文字加点击事件
     *
     * @param listener
     */
    public void setRightTextClickListener(OnClickListener listener) {
        tv_right.setOnClickListener(listener);
    }

    /**
     * 设置 右边文字颜色
     */
    public void setRightTextColor(int color) {
        tv_right.setTextColor(color);
    }


}
