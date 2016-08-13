package com.demo.zk.manxiang;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.zk.manxiang.app.ApplicationManager;
import com.demo.zk.manxiang.constant.SocialConfig;
import com.demo.zk.manxiang.domain.User;
import com.demo.zk.manxiang.presenter.UserLoginPresenter;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.view.IUserLoginView;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.bean.StatusCode;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.exception.SocializeException;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.demo.zk.manxiang.utils.ThreadValues;
/**
 * Created by houg on 2015/10/9.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements IUserLoginView {

    @ViewInject(R.id.login_btn)
    private TextView loginBtn;

    @ViewInject(R.id.wg_title_txt)
    private TextView title;

    @ViewInject(R.id.regist)
    private TextView regist;

    @ViewInject(R.id.forget_pwd)
    private TextView forgetPwd;

    @ViewInject(R.id.username)
    private EditText username;

    @ViewInject(R.id.password)
    private EditText password;

    private UserLoginPresenter presenter;

    private boolean third = false;

    private UMSocialService mController = UMServiceFactory
            .getUMSocialService("com.umeng.share");

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ViewUtils.inject(this);
        title.setText("登录");
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(this, SocialConfig.QQ_APP_ID,
                SocialConfig.QQ_APP_KEY);
        qqSsoHandler.addToSocialSDK();

        UMWXHandler wxHandler = new UMWXHandler(this, SocialConfig.WX_APP_ID, SocialConfig.WX_APP_SECRET);
        wxHandler.addToSocialSDK();

        presenter = new UserLoginPresenter(this);
//        loadingDialog.setMessage("登录中...");
    }

    @OnClick({R.id.login_btn,R.id.regist,R.id.forget_pwd,R.id.weixin_login,R.id.qq_login,R.id.sina_login,R.id.wg_header_back})
    public void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.login_btn:
                String mUsername = username.getText().toString().trim();
                String mPassword = password.getText().toString().trim();
                if(!StringUtils.isNotEmpty(mUsername)){
                    toast("请输入用户名");
                    break;
                }
                if(!StringUtils.isNotEmpty(mPassword)){
                    toast("请输入密码");
                    break;
                }
                presenter.login(mUsername,mPassword);
                hud.show();
                break;
            case R.id.regist:
                //先暂时这个  回头换回来
                //intent = new Intent(LoginActivity.this, RegistActivity.class);
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.wg_header_back:
                finish();
                break;
            case R.id.forget_pwd:
                //先暂时这个  回头换回来
                //intent = new Intent(LoginActivity.this, ForgetPwdActivity.class);
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.weixin_login:
                login(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.qq_login:
                login(SHARE_MEDIA.QQ);
                break;
            case R.id.sina_login:
                login(SHARE_MEDIA.SINA);
                break;
            default:break;
        }
    }

    private SHARE_MEDIA platform = null;

    /**
     * 授权。如果授权成功，则获取用户信息</br>
     */
    private void login( SHARE_MEDIA platform) {
        this.platform = platform;
        mController.doOauthVerify(this, platform, new SocializeListeners.UMAuthListener() {

            @Override
            public void onStart(SHARE_MEDIA platform) {

            }

            @Override
            public void onError(SocializeException e, SHARE_MEDIA platform) {
            }

            @Override
            public void onComplete(Bundle value, SHARE_MEDIA platform) {

                String uid ="";
                int type = 0;
                if(platform == SHARE_MEDIA.QQ || platform == SHARE_MEDIA.WEIXIN){
                    uid = value.getString("openid");
                    if(platform == SHARE_MEDIA.QQ)
                        type = 2;
                    else
                        type = 1;
                } else{
                    uid = value.getString("uid");
                }
                String access_token = value.getString("access_token");
                if(platform == SHARE_MEDIA.SINA){
                    access_token = value.getString("access_key");
                    type = 3;
                }
                if (!TextUtils.isEmpty(uid)) {
                    presenter.thirdLogin(access_token,uid,type);
                    third = true;
                } else {
                     toast("授权失败");
                }

            }
            @Override
            public void onCancel(SHARE_MEDIA platform) {
            }
        });
    }

    private void logout() {

        mController.deleteOauth(this, platform, new SocializeListeners.SocializeClientListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(int status, SocializeEntity entity) {

                if (status != StatusCode.ST_CODE_SUCCESSED) {

                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**使用SSO授权必须添加如下代码 */
        UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode) ;
        if(ssoHandler != null){
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }


    @Override
    public void loginSuccess(User user) {
        if(third){
            logout();
            third = false;
        }
        ThreadValues.setUser(this, user);
        ThreadValues.setSid(this, user.getSid());
    /*    ApplicationManager.g_refresh = true;
        ApplicationManager.p_refresh = true;
        finish();*/
        EMClient.getInstance().login(user.getIm_username(), user.getIm_password(), new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                hud.dismiss();
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.i("main", "登录聊天服务器成功！");
                ApplicationManager.g_refresh = true;
                ApplicationManager.p_refresh = true;
                finish();
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                hud.dismiss();
                Log.i("main", "登录聊天服务器失败:"+message);

                ThreadValues.clearSession(getApplicationContext());
                Toast.makeText(getThis(),"登录聊天服务器失败",Toast.LENGTH_LONG);
            }
        });


    }
}
