package com.demo.zk.manxiang.utils;

import android.content.Context;

import com.lidroid.xutils.DbUtils;

/**
 * Created by lenovo- on 2016/6/19.
 */
public class DBUtils {

    public static DbUtils  getInstance(Context context){
        DbUtils.DaoConfig config = new DbUtils.DaoConfig(context);
        config.setDbName("maxiang"); //db名
        config.setDbVersion(1);  //db版本
        DbUtils db = DbUtils.create(config);
        return  db;
    }
}
