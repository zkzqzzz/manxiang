
package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

public class UIUtils {

    static public int getScreenWidthPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }

    static public int dipToPx(Context context, int dip) {
        return (int) (dip * getScreenDensity(context) + 0.5f);
    }

    static public float getScreenDensity(Context context) {
        try {
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                    .getMetrics(dm);
            return dm.density;
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_DEFAULT;
        }
    }

   public static void toast(Context context,String msg){
       Toast mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);

      /* //创建LinearLayout布局
       LinearLayout toastView = (LinearLayout) mToast.getView();

       //设置LinearLayout的布局取向
       toastView.setOrientation(LinearLayout.HORIZONTAL);

       //创建ImageView
       ImageView imageCodeProject = new ImageView(context);
       imageCodeProject.setImageResource(R.mipmap.toast_icon);
       //给toastView添加View布局
       toastView.addView(imageCodeProject, 0);*/
       //显示Toast
       mToast.show();
   }

}
