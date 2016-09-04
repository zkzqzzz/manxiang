package com.demo.zk.manxiang.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;


import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.constant.SocialConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.bean.StatusCode;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.SmsShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.SmsHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

/**
 * Created by houg on 2015/11/28.
 */
public class SharePresenter extends BasePresenter {

    private Context context;

    private Activity activity;

    private String title;

    private String content;

    private String tagertUrl;

    private String img;

    private  UMSocialService mController = null;

    public SharePresenter(Context context,String img, String title, String content, String tagertUrl) {
        this.activity = (Activity)context;
        this.context = context;
        this.img = img;
        this.title = title;
        this.content = content;
        this.tagertUrl = tagertUrl;
        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
        configPlatforms();
        setShareContent();
    }

    public UMSocialService getmController() {
        return mController;
    }

    public void showDialog() {

        View view = LayoutInflater.from(context).inflate(R.layout.share_painter_dialog, null);
        final Dialog dialog = new Dialog(context, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        ImageButton weixin= (ImageButton)view.findViewById(R.id.weixin);
        ImageButton friend= (ImageButton)view.findViewById(R.id.friend);
        ImageButton qq= (ImageButton)view.findViewById(R.id.qq);
        ImageButton qzone= (ImageButton)view.findViewById(R.id.qq_kj);
        ImageButton sina= (ImageButton)view.findViewById(R.id.sina);
        ImageButton sms= (ImageButton)view.findViewById(R.id.sms);
        Button cancel= (Button)view.findViewById(R.id.cancel);
        weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.WEIXIN);
            }
        });
        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.WEIXIN_CIRCLE);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.QQ);
            }
        });
        qzone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.QZONE);
            }
        });
        sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.SINA);
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                performShare(SHARE_MEDIA.SMS);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Window window = dialog.getWindow();
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = ((Activity)context).getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    /**
     * 配置分享平台参数</br>
     */
    private void configPlatforms() {
        // 添加新浪SSO授权
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
        // 添加QQ、QZone平台
        addQQQZonePlatform();
        // 添加微信、微信朋友圈平台
        addWXPlatform();

        addSMS();
    }

    private void addSMS() {
        // 添加短信
        SmsHandler smsHandler = new SmsHandler();
        smsHandler.addToSocialSDK();
    }

    /**
     * 根据不同的平台设置不同的分享内容</br>
     */
    private void setShareContent() {

        // 配置SSO
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
        UMImage image = new UMImage(context,img);

        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(activity,
                SocialConfig.QQ_APP_ID, SocialConfig.QQ_APP_KEY);
        qZoneSsoHandler.addToSocialSDK();

        WeiXinShareContent weixinContent = new WeiXinShareContent();
        weixinContent.setShareContent(content);
        weixinContent.setTitle(title);
        weixinContent.setTargetUrl(tagertUrl);
        weixinContent.setAppWebSite(tagertUrl);
        weixinContent.setShareImage(image);
        mController.setShareMedia(weixinContent);

        // 设置朋友圈分享的内容
        CircleShareContent circleMedia = new CircleShareContent();
        circleMedia
                .setShareContent(content);
        circleMedia.setTitle(content);
        circleMedia.setTargetUrl(tagertUrl);
        circleMedia.setAppWebSite(tagertUrl);
        circleMedia.setShareImage(image);
        mController.setShareMedia(circleMedia);


        // 设置QQ空间分享内容
        QZoneShareContent qzone = new QZoneShareContent();
        qzone.setShareContent(content);
        qzone.setTitle(title);
        qzone.setTargetUrl(tagertUrl);
        qzone.setAppWebSite(tagertUrl);
        qzone.setShareImage(image);
        mController.setShareMedia(qzone);


        QQShareContent qqShareContent = new QQShareContent();
        qqShareContent.setShareContent(content);
        qqShareContent.setTitle(title);
        qqShareContent.setTargetUrl(tagertUrl);
        qqShareContent.setAppWebSite(tagertUrl);
        qqShareContent.setShareImage(image);
        mController.setShareMedia(qqShareContent);

        // 设置短信分享内容
        SmsShareContent sms = new SmsShareContent();
        sms.setShareContent(content + "\n" + tagertUrl);
        mController.setShareMedia(sms);

        SinaShareContent sinaContent = new SinaShareContent();
        sinaContent.setShareContent(content + " " + tagertUrl);
        sinaContent.setShareMedia(image);
        mController.setShareMedia(sinaContent);
    }

    private void addQQQZonePlatform() {

        // 添加QQ支持, 并且设置QQ分享内容的target url
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(activity,
                SocialConfig.QQ_APP_ID, SocialConfig.QQ_APP_KEY);
        qqSsoHandler.setTargetUrl(tagertUrl);
        qqSsoHandler.addToSocialSDK();

        // 添加QZone平台
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler((Activity)context, SocialConfig.QQ_APP_ID, SocialConfig.QQ_APP_KEY);
        qZoneSsoHandler.addToSocialSDK();
    }

    private void addWXPlatform() {

        // 添加微信平台
        UMWXHandler wxHandler = new UMWXHandler(activity, SocialConfig.WX_APP_ID, SocialConfig.WX_APP_SECRET);
        wxHandler.addToSocialSDK();

        // 支持微信朋友圈
        UMWXHandler wxCircleHandler = new UMWXHandler(activity, SocialConfig.WX_APP_ID, SocialConfig.WX_APP_SECRET);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.addToSocialSDK();
    }


    private void performShare(SHARE_MEDIA platform) {
        mController.postShare(context, platform, new SocializeListeners.SnsPostListener() {

            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int eCode, SocializeEntity entity) {
                String showText = "";
                if (eCode == StatusCode.ST_CODE_SUCCESSED) {
                    showText = "分享成功";
                } else {
                    showText = "分享失败";
                }
            }
        });
    }
}
