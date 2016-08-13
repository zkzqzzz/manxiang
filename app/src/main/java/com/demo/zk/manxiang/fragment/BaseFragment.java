package com.demo.zk.manxiang.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.demo.zk.manxiang.LoginActivity;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.ui.LoadingDialog;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.utils.UIUtils;
import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * Created by HG on 2015/10/9.
 */
public class BaseFragment extends Fragment {

    protected KProgressHUD hud;

    protected LoadingDialog loadingDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hud = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        loadingDialog = new LoadingDialog(getContext());
    }

    public void onError(int code, String message){
        if(hud.isShowing()){
            hud.dismiss();
        }

        if(code== RespCode.IVALID_SESSION_CODE||code== RespCode.OVERDUE_SESSION_CODE||code== RespCode.NULL_SID_CODE){
            ThreadValues.clearSession(getContext());
            UIUtils.toast(getActivity(), "账号未登录");
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void onError(){
        if(hud.isShowing()){
            hud.dismiss();
        }
        UIUtils.toast(getActivity(), "请求发生错误");
    }

    public void toast(String message){
        UIUtils.toast(getActivity(), message);
    }

    public Context getThis(){
        return getContext();
    }

}
