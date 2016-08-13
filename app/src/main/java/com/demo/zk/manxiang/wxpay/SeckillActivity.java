package com.demo.zk.manxiang.wxpay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.demo.zk.manxiang.BaseActivity;
import com.demo.zk.manxiang.R;
import com.demo.zk.manxiang.presenter.ConfigPresenter;
import com.demo.zk.manxiang.ui.PopupMenu;
import com.demo.zk.manxiang.view.IConfigView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by houg on 2015/10/9.
 */
@ContentView(R.layout.activity_about)
public class SeckillActivity extends BaseActivity implements IConfigView {

    @ViewInject(R.id.wg_title_txt)
    private TextView headerText;

    @ViewInject(R.id.versionNumber)
    private TextView versionNumber;

    private ConfigPresenter presenter;

    private String url;

    private PopupMenu popupMenu = null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ViewUtils.inject(this);
        //setContentView();
        headerText.setText("关于");
        versionNumber.setText("V"+getResources().getText(R.string.versionCode));
        presenter = new ConfigPresenter(this);
        presenter.getConfig("last_url_android");
        popupMenu = new PopupMenu(this);
    }

    @OnClick({R.id.header_back,R.id.praise,R.id.right_btn})
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.header_back:
                finish();
                break;
            case R.id.right_btn:
                popupMenu.showPopupWindow(v);
                break;
            case R.id.praise:
                if(url==null)
                    break;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            default:break;
        }
    }

    @Override
    public void onSuccess(String result) {
        url = result;
    }
}
