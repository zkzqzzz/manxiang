package com.demo.zk.manxiang.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.demo.zk.manxiang.MessageCenterActivity;
import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.app.ApplicationManager;


/**
 * Created by HG on 2015/11/18.
 */
public class PopupMenu {


    private Context context;

    private boolean hasShare;

    private boolean outMsg;

    private PopupWindow popupWindow;

    public PopupMenu(Context context) {

        this.context = context;

    }

    public PopupMenu(Context context, boolean hasShare, boolean outMsg) {
        this.context = context;
        this.hasShare = hasShare;
        this.outMsg = outMsg;
    }

    private PopupMenuCallback callback;

    public interface PopupMenuCallback{

        public void  share();

    }

    public void setCallback(PopupMenuCallback callback) {
        this.callback = callback;
    }

    public void showPopupWindow(View parent) {
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.pop_menu_layout, null);
            View msgItem = view.findViewById(R.id.msg_item);
            View guangItem = view.findViewById(R.id.guang_item);
            View userItem = view.findViewById(R.id.user_item);
            View shareItem = view.findViewById(R.id.share_item);
            View bg = view.findViewById(R.id.menu_bg);
            bg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            msgItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    Intent message = new Intent(context, MessageCenterActivity.class);
                    context.startActivity(message);
                }
            });
            guangItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    ApplicationManager.home(0);
                }
            });
            userItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                    ApplicationManager.home(2);
                }
            });
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            if (hasShare) {
                if(outMsg){
                    msgItem.setVisibility(View.GONE);
                }
                shareItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        callback.share();
                    }
                });
            } else {
                if(outMsg){
                    msgItem.setVisibility(View.GONE);

                }
                shareItem.setVisibility(View.GONE);
            }
        }

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(parent);
    }

}
