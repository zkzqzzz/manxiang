package com.demo.zk.manxiang.presenter;

import com.demo.zk.manxiang.base.BasePresenter;
import com.demo.zk.manxiang.base.JSONResponse;
import com.demo.zk.manxiang.base.RestAPI;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.domain.PainterService;
import com.demo.zk.manxiang.domain.ParamValue;
import com.demo.zk.manxiang.domain.SearchVo;
import com.demo.zk.manxiang.utils.HttpUtil;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.view.IPainterServiceView;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Created by houg on 2016/4/25.
 */
public class PainterServicePresenter extends BasePresenter {

    private IPainterServiceView painterServiceView;

    public PainterServicePresenter(IPainterServiceView painterServiceView) {
        this.painterServiceView = painterServiceView;
    }

    public void getServices(long painter_id,int sort_type,int sort_direction,int page,int pageSize){
        RequestParams params = new RequestParams();
        params.addBodyParameter("painter_id",String.valueOf(painter_id));
        params.addBodyParameter("sort_type",String.valueOf(sort_type));
        params.addBodyParameter("sort_direction",String.valueOf(sort_direction));
        params.addBodyParameter("page",String.valueOf(page));
        params.addBodyParameter("count",String.valueOf(pageSize));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.PAINTER_SERVICES_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<PainterService>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<PainterService>>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        painterServiceView.setServices(response.data);
                    }else {
                        painterServiceView.onError(response.code, response.desc);
                    }
                } else {
                    painterServiceView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                painterServiceView.onError();
            }
        });

    }

    public void getHotServices(long service_id){
        RequestParams params = new RequestParams();
        params.addBodyParameter("service_id",String.valueOf(service_id));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.HOT_SERVICES_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<PainterService>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<PainterService>>>() {}.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        painterServiceView.setServices(response.data);
                    }else {
                        painterServiceView.onError(response.code, response.desc);
                    }
                } else {
                    painterServiceView.onError();
                }
            }
            @Override
            public void onFailure(HttpException e, String s) {
                painterServiceView.onError();
            }
        });

    }

    public void search(SearchVo vo){
        RequestParams params = new RequestParams();
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            params.addBodyParameter("keyword",String.valueOf(vo.getKeyword()));
        }
        params.addBodyParameter("sort_type",String.valueOf(vo.getSort_type()));
        if(vo.getBegin_price()!=null){
            params.addBodyParameter("begin_price",String.valueOf(vo.getBegin_price()));
        }
        if(vo.getEnd_price()!=null){
            params.addBodyParameter("end_price",String.valueOf(vo.getEnd_price()));
        }
        if(vo.getParamValues()!=null){
            for(ParamValue param:vo.getParamValues()){
                params.addBodyParameter(param.getParam_name(),param.getChecked());
            }
        }
        params.addBodyParameter("cat_id",String.valueOf(vo.getCat_id()));
        params.addBodyParameter("page",String.valueOf(vo.getPage()));
        params.addBodyParameter("count",String.valueOf(vo.getCount()));
        HttpUtil.getInstance().send(HttpRequest.HttpMethod.POST, RestAPI.SERVICE_SEARCH_URL, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.statusCode == STATUS_OK) {
                    JSONResponse<List<PainterService>> response = gson.fromJson(responseInfo.result, new TypeToken<JSONResponse<List<PainterService>>>() {
                    }.getType());
                    if (response.code == RespCode.SUCCESS_CODE) {
                        painterServiceView.setServices(response.data);
                    } else {
                        painterServiceView.onError(response.code, response.desc);
                    }
                } else {
                    painterServiceView.onError();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                painterServiceView.onError();
            }
        });

    }
}
