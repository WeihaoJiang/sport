package com.example.jiangweihao.sport.coding.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.jiangweihao.sport.R;


public class UserDialog extends NormalDialog {

    private TextView tv_content;
    private TextView tv_cancel;
    private TextView tv_submit;
    private OnNatvieListener mOnNatvieListener;
    private OnCancelListener mOnCancelListener;



    public interface OnNatvieListener {
        void onNative(String content);
    }

    public interface OnCancelListener {
        void onCancel();
    }

    public UserDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public UserDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init();
    }


    private void init() {
        setContentView(View.inflate(getContext(), R.layout.dialog_normal, null));
        tv_content = (TextView) findViewById(R.id.tv_msg);
        tv_cancel = (TextView) findViewById(R.id.btn_left);
        tv_submit = (TextView) findViewById(R.id.btn_right);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(true);
        setCanceledOnTouchOutside(false);

        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnNatvieListener != null) {
                    mOnNatvieListener.onNative(tv_content.getText().toString());
                }
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnCancelListener != null) {
                    mOnCancelListener.onCancel();
                } else {
                    dismiss();
                }
            }
        });
    }

    public void setTv_content(String content) {
        tv_content.setText(content);
    }

    public void setTv_cancel(String cancel) {
        tv_cancel.setText(cancel);
    }

    public void setTv_submit(String ok) {
        tv_submit.setText(ok);
    }

    public void setTv_submitColor(int color) {
        tv_submit.setTextColor(color);
    }

    public void setOnNatvieListener(OnNatvieListener onNatvieListener) {
        mOnNatvieListener = onNatvieListener;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        mOnCancelListener = onCancelListener;
    }
}
