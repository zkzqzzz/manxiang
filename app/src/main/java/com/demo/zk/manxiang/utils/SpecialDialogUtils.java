package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by WG on 2016/3/27.
 */
public class SpecialDialogUtils {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
