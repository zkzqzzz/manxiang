package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.Painter;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.view.IPainterView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by HG on 2015/10/27.
 */
public class PainterPresenter extends BasePresenter {

    private IPainterView painterView;

    public PainterPresenter(IPainterView painterView) {
        this.painterView = painterView;
    }

    public void getPainter(long user_id,String sid,long painter_id){
        RequestParams params = new RequestParams();
        if(user_id>0&& StringUtils.isNotEmpty(sid)) {
            params.addBodyParameter("user_id", String.valueOf(user_id));
            params.addBodyParameter("sid", sid);
        }
        params.addBodyParameter("painter_id",String.valueOf(painter_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_DETAILS_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Painter> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Painter>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        painterView.setPainter(response.getData());
                    }else {
                        painterView.onError(response.code, response.desc);
                    }
                } else {
                    painterView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                painterView.onError();
            }
        });

    }

    public void searchPainter(String keyword){
        RequestParams params = new RequestParams();
        params.addBodyParameter("keyword",keyword);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_SEARCH_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<Painter>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<Painter>>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        painterView.setPainters(response.getData());
                    }else {
                        painterView.onError(response.code, response.desc);
                    }
                } else {
                    painterView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                painterView.onError();
            }
        });

    }


}
