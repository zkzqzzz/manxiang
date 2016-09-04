package com.demo.zk.manxiang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.User;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.utils.OSUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.Serializable;

/**
 * Created by houg on 2015/10/9.
 */
public class SplashActivity extends Activity{

    private boolean first;

    private boolean isConnected;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        ////设置窗体全屏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
        versionNumber.setText("V " + getResources().getString(R.string.versionCode));
        //获取是否是第一次进入
        first = ThreadValues.getFirst(this);
        //获取网络是否连通
        isConnected = OSUtils.isMobileConnected(this);
        if(!isConnected){
            Toast.makeText(this,"请检查网络连接,稍后重试",Toast.LENGTH_LONG) .show();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(isConnected){
                    if(first){
                        Intent intent = new Intent(SplashActivity.this, GuidePagerActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        getInfo(ThreadValues.getUserId(getApplicationContext()),ThreadValues.getSid(getApplicationContext()));
                    }
                }else{
                   finish();
                }
            }
        }, first?1000:1500);
    }

    public Context getContext(){
        return this;
    }

    public void getInfo(long user_id,String sid){

        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        //设置请求参数
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.GET_INFO_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == BasePresenter.STATUS_OK) {
                    Gson gson = new Gson();
                    JSONResponse<User> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<User>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        setUser(response.getData());
                    } else {
                       ThreadValues.clearSession(getApplicationContext());
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    ThreadValues.clearSession(getApplicationContext());
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                ThreadValues.clearSession(getApplicationContext());
            }
        });

    }

    private void setUser(User user){
        ThreadValues.setUser(this, user);
      EMClient.getInstance().login(user.getIm_username(), user.getIm_password(), new EMCallBack() {//回调
          @Override
          public void onSuccess() {
              EMClient.getInstance().groupManager().loadAllGroups();
              EMClient.getInstance().chatManager().loadAllConversations();
              Log.i("main", "登录聊天服务器成功！");
              Intent intent = new Intent(SplashActivity.this, MainActivity.class);
              startActivity(intent);
              finish();
          }

          @Override
          public void onProgress(int progress, String status) {

          }

          @Override
          public void onError(int code, String message) {
              Log.i("main", "登录聊天服务器失败:"+message);
              ThreadValues.clearSession(getApplicationContext());
              Intent intent = new Intent(SplashActivity.this, MainActivity.class);
              startActivity(intent);
              finish();
          }
      });


    }
}
