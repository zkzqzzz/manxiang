package com.hyphenate.easeui.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hyphenate.easeui.domain.User;

/**
 * Created by HG on 2015/10/22.
 */
public class ThreadValues {

    private static final String PREFERENCE_SESSION= "session";

    private static final String PREFERENCE_SESSION_FIRST = "first";

    private static final String PREFERENCE_SESSION_WATCHED = "watched";

    private static final String PREFERENCE_SESSION_USER = "user";

    private static final String PREFERENCE_SESSION_USER_ID = "user_id";

    private static final String PREFERENCE_SESSION_SID = "sid";

    private static final String PREFERENCE_REMIND = "remind";

    private static final String PREFERENCE_SESSION_PASSWORD = "password";

    private final static Gson gson = new Gson();

    public static User getUser(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        String json = preferences.getString(PREFERENCE_SESSION_USER, null);
        if (json!=null){
            return gson.fromJson(json,User.class);
        }
        return null;
    }

    public static void setUser(Context context,User user){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFERENCE_SESSION_USER, gson.toJson(user));
        editor.putString(PREFERENCE_SESSION_USER_ID, String.valueOf(user.getUser_id()));
        editor.commit();
    }

    public static long getUserId(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        String s = preferences.getString(PREFERENCE_SESSION_USER_ID, "0");
        return Long.parseLong(s);
    }

    public static String getUserId1(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        String s = preferences.getString(PREFERENCE_SESSION_USER_ID, "0");
        return s;
    }

    public static void setSid(Context context,String sid){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFERENCE_SESSION_SID, sid);
        editor.commit();
    }

    public static String getSid(Context context){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_SESSION);
       return preferences.getString(PREFERENCE_SESSION_SID, "");
    }

    public static void setPassword(Context context,String password){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION_PASSWORD);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREFERENCE_SESSION_PASSWORD, password);
        editor.commit();
    }

    public static String getPassword(Context context){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_SESSION_PASSWORD);
        return preferences.getString(PREFERENCE_SESSION_PASSWORD, "");
    }

    public static void clearSession(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(PREFERENCE_SESSION_USER);
        editor.remove(PREFERENCE_SESSION_SID);
        editor.remove(PREFERENCE_SESSION_USER_ID);
        editor.commit();
    }

    public static void setFirst(Context context,boolean first){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFERENCE_SESSION_FIRST, first);
        editor.commit();
    }

    public static boolean getFirst(Context context){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_SESSION);
        return preferences.getBoolean(PREFERENCE_SESSION_FIRST, true);
    }

    public static void setWatched(Context context,boolean watched){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_SESSION);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFERENCE_SESSION_WATCHED, watched);
        editor.commit();
    }

    public static boolean getWatched(Context context){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_SESSION);
        return preferences.getBoolean(PREFERENCE_SESSION_WATCHED, false);
    }

   private static SharedPreferences getSharedPreferences(Context context,String name){
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences;
    }

    public static void setRemind(Context context,long seckillId){
        SharedPreferences preferences = getSharedPreferences(context,PREFERENCE_REMIND);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(String.valueOf(seckillId), true);
        editor.commit();
    }

    public static boolean getRemind(Context context,long seckillId){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_REMIND);
        boolean reminded = preferences.getBoolean(String.valueOf(seckillId), false);
        if(!reminded){
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
        }
        return reminded;
    }

    public static void removeRemind(Context context){
        SharedPreferences preferences = getSharedPreferences(context, PREFERENCE_REMIND);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

}
