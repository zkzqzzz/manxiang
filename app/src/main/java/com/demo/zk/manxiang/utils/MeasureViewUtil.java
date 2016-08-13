package com.demo.zk.manxiang.utils;

import android.view.View;

/**
 * Created by Administrator on 2016/4/11.
 */
public class MeasureViewUtil {

    public static int[] measureParams(View view) {
        int[] value = new int[2];
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        int width = view.getMeasuredWidth();
        value[0] = width;
        value[1] = height;
        return value;
    }
}
