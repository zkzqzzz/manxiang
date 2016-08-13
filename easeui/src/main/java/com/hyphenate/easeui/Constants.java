package com.hyphenate.easeui;

/**
 * Created by houg on 2016/7/6.
 */
public class Constants {

    public final  static String WAITER_ID = "SKeFu";

    public final  static String ACTIVITY_ID = "SArticle";

    public final  static String HELPER_ID = "SOrder";

    public final  static String WARMER_ID = "SSeckill";

    public static String Nick(String username){
        if(WAITER_ID.equalsIgnoreCase(username)){
            return "漫像客服";
        }
        if(ACTIVITY_ID.equalsIgnoreCase(username)){
            return "漫像活动";
        }
        if(HELPER_ID.equalsIgnoreCase(username)){
            return "漫像助手";
        }
        if(WARMER_ID.equalsIgnoreCase(username)){
            return "漫像提醒";
        }
        return username;
    }


}
