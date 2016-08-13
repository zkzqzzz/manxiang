package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by houg on 2015/10/25.
 */
public class LengthUnitUtils {

    public static int dp2px(Context context,int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
