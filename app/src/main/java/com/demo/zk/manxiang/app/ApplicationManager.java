package com.demo.zk.manxiang.app;

import android.app.ActivityManager;
import android.content.Context;

import com.demo.zk.manxiang.BaseActivity;
import com.demo.zk.manxiang.MainActivity;

import java.util.Iterator;
import java.util.Stack;


/**
* @Description: 应用程序Activity管理类：用于Activity管理和应用程序退出 
* @author hougang 
* @date 2015-8-4 上午10:41:25 
*  
*/
public class ApplicationManager {

    public static boolean g_refresh;

    public static boolean p_refresh;

    private static Stack<BaseActivity> activityStack = new Stack<BaseActivity>();

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(BaseActivity activity) {
        activityStack.push(activity);
    }
    
    /**
     * 添加Activity到堆栈
     */
    public static void removeActivity(BaseActivity activity) {
    	activityStack.remove(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static BaseActivity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
    	BaseActivity activity = activityStack.pop();
        activity.finish();
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(BaseActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static boolean contains(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
               return true;
            }
        }
        return false;
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (BaseActivity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    public static void finishOtherActivity(Class<?> cls) {
        for(Iterator<BaseActivity> it = activityStack.iterator(); it.hasNext();){
            BaseActivity activity = it.next();
            if (activity != null&&activity.getClass()!=cls) {
               activity.finish();
               it.remove();
            }
        }
    }

    /**
     * 退出应用程序
     */
    public static void exit(Context context) {
        try {
            finishAllActivity();
            ActivityManager manager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            manager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void home(int page){
        MainActivity home = null;
        for(Iterator<BaseActivity> it=activityStack.iterator();it.hasNext();){
            BaseActivity activity = it.next();
            if (activity != null&&activity.getClass()!= MainActivity.class) {
                activity.finish();
                it.remove();
            }else {
                home =(MainActivity) activity;
            }
        }
        if(home!=null){
            home.setPage(page);
        }
    }
}