package com.demo.zk.manxiang.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.demo.zk.manxiang.R;


public class MXDialog extends Dialog {

	private static int default_width = 160; //默认宽度
	private static int default_height = 120;//默认高度


	public MXDialog(Context context) {
		super(context);
	}

	public MXDialog(Context context, int theme) {
		super(context, theme);
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		params.gravity = Gravity.CENTER;
		window.setAttributes(params);
	}

	public static class Builder {
		private Context context; // 上下文对象
		private String message; // 对话框内容
		private String confirm_btnText="确定"; // 按钮名称“确定”
		private String cancel_btnText="取消"; // 按钮名称“取消”

		/* 按钮坚挺事件 */
		private OnClickListener confirm_btnClickListener;
		private OnClickListener cancel_btnClickListener;

		public Builder(Context context) {
			this.context = context;
		}

		/* 设置对话框信息 */
		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}

		/**
		 * Set the Dialog message from resource
		 *
		 * @return
		 */
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param confirm_btnText
		 * @return
		 */
		public Builder setPositiveButton(int confirm_btnText,
				OnClickListener listener) {
			this.confirm_btnText = (String) context.getText(confirm_btnText);
			this.confirm_btnClickListener = listener;
			return this;
		}

		/**
		 * Set the positive button and it's listener
		 * 
		 * @param confirm_btnText
		 * @return
		 */
		public Builder setPositiveButton(String confirm_btnText,
				OnClickListener listener) {
			this.confirm_btnText = confirm_btnText;
			this.confirm_btnClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button resource and it's listener
		 *
		 * @return
		 */
		public Builder setNegativeButton(int cancel_btnText,
				OnClickListener listener) {
			this.cancel_btnText = (String) context.getText(cancel_btnText);
			this.cancel_btnClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button and it's listener
		 *
		 * @return
		 */
		public Builder setNegativeButton(String cancel_btnText,
				OnClickListener listener) {
			this.cancel_btnText = cancel_btnText;
			this.cancel_btnClickListener = listener;
			return this;
		}

		public MXDialog create() {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			final MXDialog dialog = new MXDialog(context,
					R.style.dialog_style);
			View layout = inflater.inflate(R.layout.layout_address_dialog, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

			((Button) layout.findViewById(R.id.ok))
					.setText(confirm_btnText);
			if (confirm_btnClickListener != null) {
				((Button) layout.findViewById(R.id.ok))
						.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								confirm_btnClickListener.onClick(dialog,
										DialogInterface.BUTTON_POSITIVE);
								dialog.dismiss();
							}
						});
			} else {
				((Button) layout.findViewById(R.id.ok))
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								dialog.dismiss();
							}
						});
			}

			((Button) layout.findViewById(R.id.cancel))
					.setText(cancel_btnText);
			if (cancel_btnClickListener != null) {
				((Button) layout.findViewById(R.id.cancel))
						.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								cancel_btnClickListener.onClick(dialog,
										DialogInterface.BUTTON_NEGATIVE);
								dialog.dismiss();
							}
						});
			} else {
				((Button) layout.findViewById(R.id.cancel))
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								dialog.dismiss();
							}
						});
			}
			((TextView) layout.findViewById(R.id.message)).setText(message);

			return dialog;
		}

	}
}
