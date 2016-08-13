package com.demo.zk.manxiang;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.zk.manxiang.adapter.MainViewPageAdapter;
import com.demo.zk.manxiang.app.ApplicationManager;
import com.demo.zk.manxiang.domain.User;
import com.demo.zk.manxiang.presenter.UploadImgPresenter;
import com.demo.zk.manxiang.presenter.UserInfoPresenter;
import com.demo.zk.manxiang.ui.BottomControlPanel;
import com.demo.zk.manxiang.ui.CustomDialog;
import com.demo.zk.manxiang.ui.CustomViewPager;
import com.demo.zk.manxiang.ui.MXDialog;
import com.demo.zk.manxiang.utils.CacheUtils;
import com.demo.zk.manxiang.utils.OSUtils;
import com.demo.zk.manxiang.utils.StringUtils;
import com.demo.zk.manxiang.utils.ThreadValues;
import com.demo.zk.manxiang.view.IUploadImgView;
import com.demo.zk.manxiang.view.IUserInfoView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.umeng.update.UmengUpdateAgent;

import java.io.File;


/*什么是MVP

 .View是指显示数据并且和用户交互的层。可以是一个Activity，一个Fragment，一个android.view.View或者是一个Dialog。

 .Model 是数据源层。比如数据库接口或者远程服务器的api。

 .Presenter是从Model中获取数据并提供给View的层，Presenter还负责处理后台任务。

 MVP是一个将后台任务和activities/views/fragment分离的方法，让它们独立于绝大多数跟生命周期相关的事件。

 这样应用就会变得更简单，整个应用的稳定性提高10倍以上，代码也变得更短，可维护性增强，程序员也不会过劳死了~~*/

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements BottomControlPanel.BottomPanelCallback,IUserInfoView,IUploadImgView {

    /*    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }*/

    //一个view+一个BottomControlPanel+一个CustomViewPager
    @ViewInject(R.id.bottomPanel)
    private BottomControlPanel bottomPanel;

    @ViewInject(R.id.view_pager)
    private CustomViewPager viewPager;

    private MainViewPageAdapter adapter;

    //获取用户信息
    private UserInfoPresenter presenter;


    //权限
    private String[] CAMERA = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    private String[] RECORD_AUDIO = new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);

        presenter = new UserInfoPresenter(this);
        bottomPanel.setCallback(this);
        adapter = new MainViewPageAdapter(getSupportFragmentManager(), this);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        bottomPanel.defaultBtnChecked();
        UmengUpdateAgent.setDefault();
        UmengUpdateAgent.update(this);
        uploadImgPresenter = new UploadImgPresenter(this);

        context = MainActivity.this;
    }
    @Override
    public void setPage(int page){
        if(page==2){
            presenter.getInfo(ThreadValues.getUserId(this), ThreadValues.getSid(this));
        }else {
            bottomPanel.setBtnChecked(page);
            viewPager.setCurrentItem(page);
        }
//        bottomPanel.setBtnChecked(page);
//        viewPager.setCurrentItem(page);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            confirmOver();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }

    //提示对话框
    private void confirmOver() {
        MXDialog mxDialog = new  MXDialog.Builder(this).setMessage("您确定要离开漫像吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ApplicationManager.finishAllActivity();
                    }
                }).create();
        mxDialog.show();
    }

    @Override
    public void setUser(User user) {
        ThreadValues.setUser(this, user);
        bottomPanel.setBtnChecked(2);
        viewPager.setCurrentItem(2);
    }

    @Override
    public void onSuccess(Object... arg) {

    }

    @Override
    public void startTimer() {

    }


    //上传图片
    private UploadImgPresenter uploadImgPresenter;

    private static final int REQUEST_ADDRESS_CODE = 4;
    private static final int PHOTO_REQUEST_CAMERA = 5;
    private static final int PHOTO_REQUEST_GALLERY = 6;

    private static final int REQUEST_NEW_ADDRESS_CODE = 8;

    private File tempFile;

    private final String PHOTO_FILE_NAME = "mx1000.jpg";

    private String outFilePath;

    private Dialog dialog;

    //修改头像使用
    public void showDailog() {

        View view = LayoutInflater.from(this).inflate(R.layout.wg_layout_change_icon_dialog, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("上传图片");
        LinearLayout camera = (LinearLayout) view.findViewById(R.id.camera);
        LinearLayout picture = (LinearLayout) view.findViewById(R.id.picture);
        final CustomDialog dialog = new CustomDialog.Builder(this).create();
        dialog.setContentView(view);
        dialog.show();
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                camera(v);

            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                gallery(v);
            }
        });
    }


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("HG", "resultCode:" + resultCode);
        if (requestCode == PHOTO_REQUEST_GALLERY && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                mPicturePath = getPicturePath(uri);
                String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
                outFilePath = folderPath + System.currentTimeMillis() + ".jpg";
                PGEditSDK.instance().startEdit(this, PGEditActivity.class,mPicturePath, outFilePath);
            }
        } else if (requestCode == PHOTO_REQUEST_CAMERA && resultCode == Activity.RESULT_OK) {
            tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
            String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
            outFilePath = folderPath + System.currentTimeMillis() + ".jpg";
            mPicturePath =  tempFile.getAbsolutePath();
            PGEditSDK.instance().startEdit(this, PGEditActivity.class, mPicturePath, outFilePath);
        } else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            PGEditResult editResult = PGEditSDK.instance().handleEditResult(data);
            String resultPhotoPath = editResult.getReturnPhotoPath();
            uploadImgPresenter.uploadImg(new File(resultPhotoPath));
            hud.show();
        } else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == PGEditSDK.PG_EDIT_SDK_RESULT_CODE_CANCEL) {
            //用户取消编辑
        }else if (requestCode == PGEditSDK.PG_EDIT_SDK_REQUEST_CODE
                && resultCode == PGEditSDK.PG_EDIT_SDK_RESULT_CODE_NOT_CHANGED) {
            // 照片没有修改
            if(StringUtils.isNotEmpty(mPicturePath)) {
                uploadImgPresenter.uploadImg(new File(mPicturePath));
                hud.show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
*/
    private  String mPicturePath = null;

    private String getPicturePath(Uri uri) {
        String mPicturePath = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, proj, null, null, null);
        if(cursor==null){
            mPicturePath = uri.getPath();
        }else {
            int actual_image_column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            mPicturePath = cursor.getString(actual_image_column_index);
        }
        return mPicturePath;
    }

    private void gallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    private void camera(View view) {
        if (OSUtils.hasSdcard()) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME)));
            startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
        }
    }

    @Override
    public void onSuccess(String img) {
        hud.dismiss();
        CacheUtils.setString(this, "photo", img);
        //Intent intent = new Intent(this,WatchServiceActivity.class);
        Intent intent = new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
}
