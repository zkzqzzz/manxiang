package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.User;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IUserLoginView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by HG on 2015/10/22.
 */
public class UserLoginPresenter extends BasePresenter {

    private IUserLoginView userView;

    public UserLoginPresenter(IUserLoginView userView) {
        this.userView = userView;
    }

    public void login(String mobilephone,String password){
        RequestParams params = new RequestParams();
        params.addBodyParameter("mobilephone",mobilephone);
        params.addBodyParameter("password",password);
        params.addBodyParameter("reg_source","1");
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.LOGIN_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<User> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<User>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userView.loginSuccess(response.getData());
                    }else {
                        userView.onError(response.code, response.desc);
                    }
                } else {
                    userView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userView.onError();
            }
        });

    }

    public void thirdLogin(String access_token,String openid,int type){
        RequestParams params = new RequestParams();
        params.addBodyParameter("access_token",access_token);
        params.addBodyParameter("openid",openid);
        params.addBodyParameter("type",String.valueOf(type));
        params.addBodyParameter("reg_source","1");
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.THIRD_LOGIN_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<User> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<User>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userView.loginSuccess(response.getData());
                    }else {
                        userView.onError(response.code, response.desc);
                    }
                } else {
                    userView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userView.onError();
            }
        });

    }
}
