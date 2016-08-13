package com.demo.zk.manxiang.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.zk.manxiang.R;


/**
 * Created by houg on 2015/10/7.
 */
//自定义按钮
public class CustomButton extends LinearLayout {

    private Context mContext = null;

    public boolean checked = false;

    private int resId;

    private int selectedResId;

    private String text;

    private ImageView mImageView;

    private TextView mTextView;

    public CustomButton(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomButton(Context context,AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parentView = inflater.inflate(R.layout.custom_button_layout, this, true);
        mImageView = (ImageView)findViewById(R.id.custom_img);
        mTextView = (TextView)findViewById(R.id.custom_txt);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    public void init(boolean checked,int resId,int selectedResId,String text){
        this.checked = checked;
        this.resId = resId;
        this.selectedResId = selectedResId;
        this.text = text;
        if(mImageView == null||mTextView == null){
           return;
        }
        if(checked){
            mImageView.setImageResource(selectedResId);
            mTextView.setText(text);
            mTextView.setVisibility(View.GONE);
        }else{
            mImageView.setImageResource(resId);
            mTextView.setText(text);
        }

    }

    public void setImage(int resId){
        if(mImageView != null){
            mImageView.setImageResource(resId);
        }
    }

    public void setText(String text){
        if(mTextView != null){
            mTextView.setText(text);
        }
    }

    public void checked(boolean checked){
        if(this.checked == checked){
            return;
        }
        this.checked = checked;
        if(checked){
            mImageView.setImageResource(selectedResId);
            mTextView.setTextColor(getResources().getColor(R.color.font_red));
        }else{
            mImageView.setImageResource(resId);
            mTextView.setTextColor(getResources().getColor(R.color.custom_btn_txt));
        }
    }
}
