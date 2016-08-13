package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.User;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IUserInfoView;
import com.demo.zk.manxiang.wxpay.MD5;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.util.Map;

/**
 * Created by HG on 2015/10/22.
 */
public class UserInfoPresenter extends BasePresenter {

    private IUserInfoView userInfoView;

    public UserInfoPresenter(IUserInfoView userInfoView) {
        this.userInfoView = userInfoView;
    }

    public void getInfo(long user_id,String sid){
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id",String.valueOf(user_id));
        params.addBodyParameter("sid",sid);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.GET_INFO_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<User> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<User>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.setUser(response.getData());
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void resetPassword(String mobilephone,String password,String code){
        RequestParams params = new RequestParams();
        params.addBodyParameter("mobilephone",mobilephone);
        params.addBodyParameter("password",password);
        params.addBodyParameter("code", code);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.RESET_PASSWORD_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Object> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Object>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess();
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void updateInfo(User user){
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id",String.valueOf(user.getUser_id()));
        if (user.getSid()!=null)
            params.addBodyParameter("sid",user.getSid());
        if (user.getImg()!=null)
            params.addBodyParameter("img",user.getImg());
        if (user.getNickname()!=null)
            params.addBodyParameter("nickname",user.getNickname());
        if (user.getRealname()!=null)
            params.addBodyParameter("realname",user.getRealname());
        if (user.getSex()!=null)
            params.addBodyParameter("sex",user.getSex());
        if (user.getBirthday()!=null)
            params.addBodyParameter("birthday",user.getBirthday());
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.UPDATE_INFO_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<User> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<User>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.setUser(response.getData());
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void updatePassword(long user_id,String sid,String oldpassword,String newpassword){
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id",String.valueOf(user_id));
        params.addBodyParameter("sid",sid);
        params.addBodyParameter("oldpassword",oldpassword);
        params.addBodyParameter("newpassword",newpassword);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.UPLOAD_PASSWORD_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Object> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Object>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess();
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void bindMobilephone(Long user_id,String sid,String mobilephone,String password,String code){
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id",String.valueOf(user_id));
        params.addBodyParameter("sid",sid);
        params.addBodyParameter("mobilephone",mobilephone);
        params.addBodyParameter("password",password);
        params.addBodyParameter("code",code);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.BIND_MOBILEPHONE_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Object> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Object>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess();
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void feedback(Long user_id,String sid,String content) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("content", content);

        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.FACEBACK_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Object> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Object>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess();
                    } else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });
    }

    public void getCode(int type,String mobilephone,String device,String mac){
        RequestParams params = new RequestParams();
        params.addBodyParameter("type",String.valueOf(type));
        params.addBodyParameter("mobilephone",mobilephone);
        params.addBodyParameter("sign", MD5.md5(mobilephone+"zbjt").toLowerCase());
        params.addBodyParameter("mac",mac);
        params.addBodyParameter("device", device);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SMS_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Object> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Object>>() {}.getType());
                    if (response.code ==  RespCode.SUCCESS_CODE) {
                        userInfoView.startTimer();
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

    public void uploadHeader(File file){
        RequestParams params = new RequestParams();
        params.addBodyParameter("photo",file);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.UPLOAD_IMAGE_URL, params, new RequestCallBack<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Map> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Map>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess(response.data.get("img"));
                    } else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }


    public void logout(long user_id,String sid){
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id",String.valueOf(user_id));
        params.addBodyParameter("sid",sid);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.LOGOUT_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Integer> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Integer>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        userInfoView.onSuccess(response.getData());
                    }else {
                        userInfoView.onError(response.code, response.desc);
                    }
                } else {
                    userInfoView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                userInfoView.onError();
            }
        });

    }

}
