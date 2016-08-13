package com.demo.zk.manxiang.ui;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.zk.manxiang.R;


public class LoadingDialog extends Dialog {
	private Context context = null;
	private static LoadingDialog loadingDialog = null;

	public LoadingDialog(Context context){
		super(context);
		this.context = context;
	}

	public LoadingDialog(Context context, int theme) {
		super(context, theme);
	}

	public static LoadingDialog createDialog(Context context){
		loadingDialog = new LoadingDialog(context, R.style.loadingDialog);
		loadingDialog.setContentView(R.layout.loadingdialog);
		loadingDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

		return loadingDialog;
	}

	public void onWindowFocusChanged(boolean hasFocus){

		if (loadingDialog == null){
			return;
		}

		ImageView imageView = (ImageView) loadingDialog.findViewById(R.id.loadingImageView);
		AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
		animationDrawable.start();
	}


	public LoadingDialog setTitile(String strTitle){
		return loadingDialog;
	}

	public LoadingDialog setMessage(String strMessage){
		TextView tvMsg = (TextView)loadingDialog.findViewById(R.id.id_tv_loading_msg);

		if (tvMsg != null){
			tvMsg.setText(strMessage);
		}

		return loadingDialog;
	}
}
