package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.CollectionPainter;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.ICollectionPainterView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class CollectionPainterPresenter extends BasePresenter {

    private ICollectionPainterView collectionPainterView;

    public CollectionPainterPresenter(ICollectionPainterView collectionPainterView) {
        this.collectionPainterView = collectionPainterView;
    }

    public void getCollectionPainterList(long user_id, String sid) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_GET_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<CollectionPainter>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<CollectionPainter>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        collectionPainterView.setCollectionPainterList(response.data);
                    } else {
                        collectionPainterView.onError(response.code, response.desc);
                    }
                } else {
                    collectionPainterView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                collectionPainterView.onError();
            }
        });
    }

    public void getPainterCollectionResult(long user_id, String sid, long painter_id, int status) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("painter_id", String.valueOf(painter_id));
        params.addBodyParameter("status", String.valueOf(status));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        collectionPainterView.setPainterCollectionResult(response.data);
                    } else {
                        collectionPainterView.onError(response.code, response.desc);
                    }
                } else {
                    collectionPainterView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                collectionPainterView.onError();
            }
        });
    }

    public void getPainterCancelCollection(long user_id, String sid, String painter_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("painter_id", painter_id);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_CANCEL_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        collectionPainterView.setPainterCancelCollection(response.data);
                    } else {
                        collectionPainterView.onError(response.code, response.desc);
                    }
                } else {
                    collectionPainterView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                collectionPainterView.onError();
            }
        });
    }

    public void getPainterCollectionSearch(long user_id, String sid, String keyword) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("keyword", keyword);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_SEARCH_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<CollectionPainter>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<CollectionPainter>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        collectionPainterView.setPainterCollectionSearch(response.data);
                    } else {
                        collectionPainterView.onError(response.code, response.desc);
                    }
                } else {
                    collectionPainterView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                collectionPainterView.onError();
            }
        });
    }

}
