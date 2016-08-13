package com.demo.zk.manxiang.utils;


import com.lidroid.xutils.HttpUtils;


public class HttpUtil extends HttpUtils {

    private static HttpUtil httpUtils;

    public static HttpUtil getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtil();
            httpUtils.configRequestThreadPoolSize(8);
            httpUtils.configCurrentHttpCacheExpiry(10 * 1000);
            httpUtils.configResponseTextCharset("UTF-8");
        }
        return httpUtils;
    }

}
