package com.demo.zk.manxiang.app;

import android.app.Application;



import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.utils.CacheUtils;



/**
 * Created by houg on 2016/5/28.
 */
public class ManxiangApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //PGEditImageLoader.initImageLoader(this);
        //PGEditSDK.instance().initSDK(this);

        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        EaseUI.getInstance().init(this, options);
        EaseUI.getInstance().setSettingsProvider(new EaseUI.EaseSettingsProvider() {
            @Override
            public boolean isMsgNotifyAllowed(EMMessage message) {

                return CacheUtils.getBoolean(getApplicationContext(), "warm");
            }

            @Override
            public boolean isMsgSoundAllowed(EMMessage message) {

                return CacheUtils.getBoolean(getApplicationContext(), "ring");
            }

            @Override
            public boolean isMsgVibrateAllowed(EMMessage message) {

                return CacheUtils.getBoolean(getApplicationContext(), "shock");
            }

            @Override
            public boolean isSpeakerOpened() {
                return false;
            }
        });
    }

}
