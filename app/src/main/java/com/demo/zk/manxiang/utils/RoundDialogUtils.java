package com.demo.zk.manxiang.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.demo.zk.manxiang.R;


/**
 * Created by WG on 2016/3/27.
 */
public class RoundDialogUtils extends Dialog {

    public RoundDialogUtils(Context context, int themeResId) {
        super(context, themeResId);
    }

    public RoundDialogUtils(Context context) {
        super(context);
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static class Builder {

        private Context context; // 上下文对象
        private View contentView; // 对话框中间加载的其他布局界面

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }


        public RoundDialogUtils create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final RoundDialogUtils dialog = new RoundDialogUtils(context, R.style.dialog_style);
            View layout = inflater.inflate(R.layout.wg_round_custom_dialog, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            if (contentView != null) {
                LinearLayout message = (LinearLayout) layout.findViewById(R.id.ll_layout);
                message.removeAllViews();
                message.addView(contentView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            }
            dialog.setContentView(layout);
			/*WindowManager.LayoutParams params = dialog.getWindow()
					.getAttributes();
			params.width = LengthUnitUtils.dp2px(context,250);
			dialog.getWindow().setAttributes(params);*/
            return dialog;
        }

    }
}
