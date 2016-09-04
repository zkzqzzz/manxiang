package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.ImageAddress;
import com.demo.zk.manxiang.domain.PlaceOrder;
import com.demo.zk.manxiang.domain.PreparePlaceOrder;
import com.demo.zk.manxiang.domain.UserAddress;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.view.IPreparePlaceOrderView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class PreparePlaceOrderPresenter extends BasePresenter {

    private IPreparePlaceOrderView preparePlaceOrderView;

    public PreparePlaceOrderPresenter(IPreparePlaceOrderView preparePlaceOrderView) {
        this.preparePlaceOrderView = preparePlaceOrderView;
    }

    public void getPreparePlaceOrder(long user_id, String sid, long service_id, long param_id) {

        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("service_id", String.valueOf(service_id));
        params.addBodyParameter("param_id", String.valueOf(param_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PREPARE_PLACE_ORDER_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<PreparePlaceOrder> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<PreparePlaceOrder>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        preparePlaceOrderView.setPreparePlaceOrder(response.data);
                    } else {
                        preparePlaceOrderView.onError(response.code, response.desc);
                    }
                } else {
                    preparePlaceOrderView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                preparePlaceOrderView.onError();
            }
        });
    }

    public void getPlaceOrder(long user_id, String sid, long service_id, long param_id,
                              String imgs, String user_message, int source, long address_id,
                              int is_use_redeem_code, String redeem_code) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("service_id", String.valueOf(service_id));
        params.addBodyParameter("param_id", String.valueOf(param_id));
        params.addBodyParameter("imgs", imgs);
        params.addBodyParameter("user_message", user_message);
        params.addBodyParameter("source", String.valueOf(source));
        params.addBodyParameter("address_id", String.valueOf(address_id));
        params.addBodyParameter("is_use_redeem_code", String.valueOf(is_use_redeem_code));
        if(StringUtils.isNotEmpty(redeem_code))
            params.addBodyParameter("redeem_code", redeem_code);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PLACE_ORDER_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<PlaceOrder> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<PlaceOrder>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        preparePlaceOrderView.setPlaceOrder(response.data);
                    } else {
                        preparePlaceOrderView.onError(response.code, response.desc);
                    }
                } else {
                    preparePlaceOrderView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                preparePlaceOrderView.onError();
            }
        });
    }

    public static final int TYPE = 2;

    public void getUploadImage(File file) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("photo", file);
        params.addBodyParameter("type", String.valueOf(TYPE));
        HttpUtil httpUtils = new HttpUtil();
        httpUtils.configRequestThreadPoolSize(8);
        httpUtils.configCurrentHttpCacheExpiry(10 * 1000);
        httpUtils.configTimeout(1000 * 60 * 10);
        httpUtils.configResponseTextCharset("UTF-8");
        httpUtils.send(HttpRequest.HttpMethod.POST, RestAPI.UPLOAD_IMAGE_URL, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<ImageAddress> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<ImageAddress>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        preparePlaceOrderView.setUploadImage(response.data);
                    } else {
                        preparePlaceOrderView.onError(response.code, response.desc);
                    }
                } else {
                    preparePlaceOrderView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                preparePlaceOrderView.onError();
            }
        });

    }

    public void getDefaultAddress(long user_id, String sid) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.ADDRESS_GETLIST, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<UserAddress>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<UserAddress>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        preparePlaceOrderView.setDefaultAddress(response.data);
                    } else {
                        preparePlaceOrderView.onError(response.code, response.desc);
                    }
                } else {
                    preparePlaceOrderView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                preparePlaceOrderView.onError();
            }
        });
    }

    public void getAddress(long user_id, String sid, long address_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("address_id", String.valueOf(address_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.ADDRESS_GETDETAIL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<UserAddress> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<UserAddress>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        preparePlaceOrderView.setAddress(response.data);
                    } else {
                        preparePlaceOrderView.onError(response.code, response.desc);
                    }
                } else {
                    preparePlaceOrderView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                preparePlaceOrderView.onError();
            }
        });
    }

}
