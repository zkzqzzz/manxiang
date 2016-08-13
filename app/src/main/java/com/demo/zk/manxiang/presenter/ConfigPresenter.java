package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IConfigView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.Map;

/**
 * Created by HG on 2015/10/31.
 */
public class ConfigPresenter extends BasePresenter {

    private IConfigView configView;

    public ConfigPresenter(IConfigView configView) {
        this.configView = configView;
    }

    public void getConfig(final String param){
        RequestParams params = new RequestParams();
        params.addBodyParameter("param", param);
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.CONFIG_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Map> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Map>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        configView.onSuccess((String)response.data.get(param));
                    }else {
                        configView.onError(response.code, response.desc);
                    }
                } else {
                    configView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                configView.onError();
            }
        });

    }
}
