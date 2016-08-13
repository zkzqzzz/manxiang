package com.demo.zk.manxiang.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.zk.manxiang.domain.PlaceOrder;
import com.google.gson.Gson;

/**
 * Created by HG on 2015/10/22.
 */
public class CacheUtils {


    private static final String PREFERENCE_CACHE_STR = "string";

    private static final String PREFERENCE_CACHE_OBJ = "object";

    private static final String PREFERENCE_CACHE_BOOLEAN = "boolean";

    private static final String PREFERENCE_CACHE_OBJ_ORDER = "order";

    private final static Gson gson = new Gson();

    public static Object getObject(Context context,String key,Class<?> clazz){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_OBJ);
        String json = preferences.getString(key, null);
        if (json!=null){
            return gson.fromJson(json,clazz);
        }
        return null;
    }

    public static void setObject(Context context,String key,Object obj){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_OBJ);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, gson.toJson(obj));
        editor.commit();
    }

    public static PlaceOrder getOrder(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_OBJ);
        String json = preferences.getString(PREFERENCE_CACHE_OBJ_ORDER, null);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(PREFERENCE_CACHE_OBJ_ORDER);
        editor.commit();
        if (json!=null){

            return gson.fromJson(json,PlaceOrder.class);
        }
        return null;
    }

    public static void clearObject(Context context,String key){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_OBJ);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public static void setOrder(Context context,PlaceOrder order){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_OBJ);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFERENCE_CACHE_OBJ_ORDER, gson.toJson(order));
        editor.commit();
    }

    public static String getString(Context context,String key){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_STR);
        return  preferences.getString( key, null);
    }

    public static void setString(Context context,String key,String value){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_STR);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void clearString(Context context,String key){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_STR);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public static boolean getBoolean(Context context,String key){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_BOOLEAN);
        return  preferences.getBoolean(key, false);
    }

    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_BOOLEAN);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void clearBoolean(Context context,String key){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_CACHE_BOOLEAN);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }


    private static SharedPreferences getSharedPreferences(Context context,String name){
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences;
    }
}
