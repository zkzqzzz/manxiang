package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.domain.SpecialDetail;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.ISpecialDetailView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by houg on 2016/4/18.
 */
public class SpecialDetailPresenter extends BasePresenter {

    private ISpecialDetailView specialDetailView;

    public SpecialDetailPresenter(ISpecialDetailView specialDetailView) {
        this.specialDetailView = specialDetailView;
    }

    public void getDetail(long user_id, String sid, long special_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("special_id", String.valueOf(special_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_DETAIL_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<SpecialDetail> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<SpecialDetail>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialDetailView.setSpecialDetail(response.data);
                    } else {
                        specialDetailView.onError(response.code, response.desc);
                    }
                } else {
                    specialDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialDetailView.onError();
            }
        });

    }

    public void getDetail(long special_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("special_id", String.valueOf(special_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_DETAIL_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<SpecialDetail> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<SpecialDetail>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialDetailView.setSpecialDetail(response.data);
                    } else {
                        specialDetailView.onError(response.code, response.desc);
                    }
                } else {
                    specialDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialDetailView.onError();
            }
        });

    }

    public void getServices(long special_id, int page, int pageSize) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("special_id", String.valueOf(special_id));
        params.addBodyParameter("page", String.valueOf(page));
        params.addBodyParameter("count", String.valueOf(pageSize));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_SERVICES_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<PainterService>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<PainterService>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialDetailView.setSpecialServices(response.data);
                    } else {
                        specialDetailView.onError(response.code, response.desc);
                    }
                } else {
                    specialDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialDetailView.onError();
            }
        });
    }

    public void getCollectionResult(long user_id, String sid, long special_id, int status) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("special_id", String.valueOf(special_id));
        params.addBodyParameter("status", String.valueOf(status));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialDetailView.setCollectionResult(response.data);
                    } else {
                        specialDetailView.onError(response.code, response.desc);
                    }
                } else {
                    specialDetailView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialDetailView.onError();
            }
        });
    }

}
