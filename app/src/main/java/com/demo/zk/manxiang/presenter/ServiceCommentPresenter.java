package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.ServiceDetail;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IServiceCommentView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class ServiceCommentPresenter extends BasePresenter {

    private IServiceCommentView serviceCommentView;

    public ServiceCommentPresenter(IServiceCommentView serviceCommentView) {
        this.serviceCommentView = serviceCommentView;
    }

    public void getServiceComment(long service_id, int count, int page) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("service_id", String.valueOf(service_id));
        params.addBodyParameter("count", String.valueOf(count));
        params.addBodyParameter("page", String.valueOf(page));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_COMMENT_GET_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<ServiceDetail.Comment>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<ServiceDetail.Comment>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        serviceCommentView.setServiceComment(response.data);
                    } else {
                        serviceCommentView.onError(response.code, response.desc);
                    }
                } else {
                    serviceCommentView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                serviceCommentView.onError();
            }
        });
    }

}
