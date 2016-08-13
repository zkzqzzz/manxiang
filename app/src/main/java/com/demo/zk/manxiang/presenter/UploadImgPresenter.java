package com.demo.zk.manxiang.presenter;


import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.view.IUploadImgView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.util.Map;

/**
 * Created by houg on 2015/11/28.
 */
public class UploadImgPresenter extends BasePresenter {

    private IUploadImgView uploadImgView;

    public UploadImgPresenter(IUploadImgView uploadImgView) {
        this.uploadImgView = uploadImgView;
    }

    public void uploadImg(File file){
        RequestParams params = new RequestParams();
        params.addBodyParameter("photo",file);
        params.addBodyParameter("type","2");
        HttpUtil httpUtils = new HttpUtil();
        httpUtils.configRequestThreadPoolSize(8);
        httpUtils.configCurrentHttpCacheExpiry(10 * 1000);
        httpUtils.configTimeout(1000 * 60 * 10);
        httpUtils.configResponseTextCharset("UTF-8");
        httpUtils.send(HttpRequest.HttpMethod.POST, RestAPI.UPLOAD_IMAGE_URL, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<Map> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<Map>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        uploadImgView.onSuccess((String) response.data.get("img"));
                    } else {
                        uploadImgView.onError(response.code, response.desc);
                    }
                } else {
                    uploadImgView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {

                uploadImgView.onError();
            }
        });

    }
}
