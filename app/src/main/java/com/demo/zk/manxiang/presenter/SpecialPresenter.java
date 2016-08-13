package com.demo.zk.manxiang.presenter;

import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.CollectionSpecial;
import com.demo.zk.manxiang.domain.Special;
import com.demo.zk.manxiang.domain.Status;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.ISpecialView;
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
public class SpecialPresenter extends BasePresenter {

    private ISpecialView specialView;

    public SpecialPresenter(ISpecialView specialView) {
        this.specialView = specialView;
    }

    public void getList(int page, int pageSize) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("page", String.valueOf(page));
        params.addBodyParameter("count", String.valueOf(pageSize));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_LIST_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<Special>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<Special>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialView.setSpecials(response.data);
                    } else {
                        specialView.onError(response.code, response.desc);
                    }
                } else {
                    specialView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialView.onError();
            }
        });
    }

    public void getSpecialCollectionSearch(long user_id, String sid, String keyword) {

        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("keyword", keyword);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_SEARCH_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<CollectionSpecial>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<CollectionSpecial>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialView.setSpecialViewCollectionSearch(response.data);
                    } else {
                        specialView.onError(response.code, response.desc);
                    }
                } else {
                    specialView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialView.onError();
            }
        });
    }

    public void getSpecialCollectionList(long user_id, String sid, int count, int page) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("count", String.valueOf(count));
        params.addBodyParameter("page", String.valueOf(page));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_COLLECTION_LIST_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<CollectionSpecial>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<CollectionSpecial>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialView.setSpecialCollectionList(response.data);
                    } else {
                        specialView.onError(response.code, response.desc);
                    }
                } else {
                    specialView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialView.onError();
            }
        });
    }

    public void getSpecialCollectionResult(long user_id, String sid, long special_id, int status) {
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
                        specialView.setSpecialCollectionResult(response.data);
                    } else {
                        specialView.onError(response.code, response.desc);
                    }
                } else {
                    specialView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialView.onError();
            }
        });
    }

    public void getSpecialCancelCollection(long user_id, String sid, String special_id) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", String.valueOf(user_id));
        params.addBodyParameter("sid", sid);
        params.addBodyParameter("special_id", special_id);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SPECIAL_CANCEL_COLLECTION_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Status> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Status>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        specialView.setSpecialCancelCollection(response.data);
                    } else {
                        specialView.onError(response.code, response.desc);
                    }
                } else {
                    specialView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                specialView.onError();
            }
        });
    }

}
