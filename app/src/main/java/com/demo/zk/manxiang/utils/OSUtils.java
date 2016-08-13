package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.util.DisplayMetrics;

/**
 * Created by HG on 2015/10/23.
 */
public class OSUtils {

    public static String getDeviceId(Context context){
        /*TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        return deviceId==null?"":deviceId;*/
        return "";
    }

    public static String getLocalMacAddress(Context context) {
        WifiManager wifi = (WifiManager)  context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager con =(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            boolean wifi=con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
            boolean internet=con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
            if (wifi||internet) {
                return true;
            }
        }
        return false;
    }

    public static  boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getScreenWidth() {
        DisplayMetrics displayMetric = Resources.getSystem().getDisplayMetrics();
        return displayMetric.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics displayMetric = Resources.getSystem().getDisplayMetrics();
        return displayMetric.heightPixels;
    }
}
