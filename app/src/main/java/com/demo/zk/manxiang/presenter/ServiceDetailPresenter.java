package com.demo.zk.manxiang.presenter;

import com.demo.zk.manxiang.base.BasePresenter;


import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IServiceDetailView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Administrator on 2016/5/2.
 */
public class ServiceDetailPresenter extends BasePresenter {

    private IServiceDetailView serviceDetailView;

    public ServiceDetailPresenter(IServiceDetailView serviceDetailView) {
        this.serviceDetailView = serviceDetailView;
    }

    public void getDetail(long user_id, String sid, long service_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("service_id", String.valueOf(service_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_DETAIL_GET_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<ServiceDetail> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<ServiceDetail>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        serviceDetailView.setServiceDetail(response.data);
                    } else {
                        serviceDetailView.onError(response.code, response.desc);
                    }
                } else {
                    serviceDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                serviceDetailView.onError();
            }
        });
    }

    public void getDetail(long service_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("service_id", String.valueOf(service_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_DETAIL_GET_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<ServiceDetail> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<ServiceDetail>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        serviceDetailView.setServiceDetail(response.data);
                    } else {
                        serviceDetailView.onError(response.code, response.desc);
                    }
                } else {
                    serviceDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                serviceDetailView.onError();
            }
        });
    }

    public void getCollectionResult(long user_id, String sid, long service_id, int status) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("service_id", String.valueOf(service_id));
        params.addBodyParameter("status", String.valueOf(status));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_COLLECT_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        serviceDetailView.setCollectionResult(response.data);
                    } else {
                        serviceDetailView.onError(response.code, response.desc);
                    }
                } else {
                    serviceDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                serviceDetailView.onError();
            }
        });
    }

    public void getPraiseResult(long user_id, String sid, long service_id, int status) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("service_id", String.valueOf(service_id));
        params.addBodyParameter("status", String.valueOf(status));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_COLLECT_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        serviceDetailView.setPraiseResult(response.data);
                    } else {
                        serviceDetailView.onError(response.code, response.desc);
                    }
                } else {
                    serviceDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                serviceDetailView.onError();
            }
        });
    }

}
