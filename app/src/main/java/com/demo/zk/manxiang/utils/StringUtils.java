package com.demo.zk.manxiang.utils;

import com.demo.zk.manxiang.base.RestAPI;

/**
 * Created by houg on 2015/10/23.
 */
public class StringUtils {

    public static boolean isNotEmpty(String str){
        return str!=null&&!str.trim().equals("");
    }

    public static boolean containHttp(String str){
        if(str==null){
            return false;
        }
        return str.indexOf("http")>-1;
    }

    public static String absoluteUrl(String url){
        if(containHttp(url)){
            return url;
        }
        return RestAPI.IMG_ROOT + url;
        //return "http://dev.manxianger.com/Api" + url;
    }

    public static boolean isLetterDigitOrChinese(String str) {
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
        return str.matches(regex);
    }
}
