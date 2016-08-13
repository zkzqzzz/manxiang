package com.demo.zk.manxiang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.zk.manxiang.app.ApplicationManager;
import com.demo.zk.manxiang.constant.RespCode;
import com.demo.zk.manxiang.ui.LoadingDialog;
import com.demo.zk.manxiang.utils.OSUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.utils.UIUtils;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by HG on 2015/10/9.
 */
public class BaseActivity extends AppCompatActivity {

    //Android的ProgressHUD，多种加载效果。类似于ios中的MBProgressHUD, SVProgressHUD。
    protected KProgressHUD hud;

    //自定义弹窗对话框
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationManager.addActivity(this);
        hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait");
        loadingDialog = LoadingDialog.createDialog(this);
        if (!OSUtils.isMobileConnected(this)) {
            toast("没有网络，请检查网络连接");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //友盟用户分析工具
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ApplicationManager.removeActivity(this);
    }


    public void onError(int code, String message) {
        if (hud.isShowing()) {
            hud.dismiss();
        }

        if (code == RespCode.IVALID_SESSION_CODE || code == RespCode.OVERDUE_SESSION_CODE || code == RespCode.NULL_SID_CODE) {
            ThreadValues.clearSession(this);
            UIUtils.toast(this, "账号未登录");
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    public void onError() {
        if (hud.isShowing()) {
            hud.dismiss();
        }
        UIUtils.toast(this, "请求发生错误");
    }

    public void toast(String message) {
        UIUtils.toast(this, message);
    }

    //分发事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    //隐藏输入键盘
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    protected boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Context getThis() {
        return this;
    }

}
