package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

import com.demo.zk.manxiang.R;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by houg on 2016/7/16.
 */
public class MsgIconUtils {

    public static EMMessageListener addListener(Context context,Handler handler, ImageView icon){
        if(StringUtils.isNotEmpty(ThreadValues.getSid(context))){
            EMMessageListener emMessageListener = new IconEMMessageListener(context,handler,icon);
            EMClient.getInstance().chatManager().addMessageListener(emMessageListener);
            return  emMessageListener;
        }else {
            return null;
        }


    }

    public static void initIcon(Context context, ImageView icon){
        if(StringUtils.isNotEmpty(ThreadValues.getSid(context))){
            Map<String, EMConversation> map = EMClient.getInstance().chatManager().getAllConversations();
            for (Map.Entry<String, EMConversation> entry : map.entrySet()){
                EMConversation conversation = entry.getValue();
                int unreadCount = conversation.getUnreadMsgCount();
                if(unreadCount>0){
                    setIcon(context,true,icon);
                    return;
                }
            }
        }
        setIcon(context,false,icon);
    }

   public static class IconEMMessageListener implements EMMessageListener{

        private Context context;

        private Handler handler;

        private ImageView icon;

       public IconEMMessageListener(Context context, Handler handler, ImageView icon) {
           this.context = context;
           this.handler = handler;
           this.icon = icon;
       }

       @Override
       public void onMessageReceived(List<EMMessage> list) {
           handler.post(new IconThread(context,true,icon));
       }

       @Override
       public void onCmdMessageReceived(List<EMMessage> list) {

       }

       @Override
       public void onMessageReadAckReceived(List<EMMessage> list) {

       }

       @Override
       public void onMessageDeliveryAckReceived(List<EMMessage> list) {

       }

       @Override
       public void onMessageChanged(EMMessage emMessage, Object o) {

       }
    }

    public static class IconThread implements  Runnable{

        private Context context;

        private boolean hasMsg;

        private ImageView icon;

        public IconThread(Context context, boolean hasMsg, ImageView icon) {
            this.context = context;
            this.hasMsg = hasMsg;
            this.icon = icon;
        }

        @Override
        public void run() {
            setIcon(context,hasMsg,icon);
        }
    }

    public static void setIcon(Context context, boolean hasMsg, ImageView icon){
        if(hasMsg){
            icon.setImageResource(R.mipmap.msg_icon_has);
        }else {
            icon.setImageResource(R.mipmap.msg_icon);
        }
    }
}
