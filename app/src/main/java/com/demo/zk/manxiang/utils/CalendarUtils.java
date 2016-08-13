package com.demo.zk.manxiang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by HG on 2015/10/27.
 */
public class CalendarUtils {

    public static Date parse(String dateStr,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
           return null;
        }
    }
    public static String format(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static CustomTime getSeckillTimes(String currTime,String endTime){
        Date curr = parse(currTime,"yyyy-MM-dd HH:mm:ss");
        Date end = parse(endTime,"yyyy-MM-dd HH:mm:ss");
        long ms = end.getTime() - curr.getTime();
        long hours = ms/(60*60*1000);
        long t = ms%(60*60*1000);
        long minutes = t/(60*1000);
        t = t%(60*1000);
        long seconds = t/1000;
        return new CustomTime((int)hours,(int)minutes,(int)seconds);
    }

    public static long compare(String arg0,String arg1){
        Date date0 = parse(arg0, "yyyy-MM-dd HH:mm:ss");
        Date date1 = parse(arg1, "yyyy-MM-dd HH:mm:ss");
        return date0.getTime()-date1.getTime();
    }

    public static boolean isToday(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR)
                &&cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)
                &&cal1.get(Calendar.DAY_OF_MONTH)==cal2.get(Calendar.DAY_OF_MONTH)){
            return true;
        }
        return false;
    }

    public static boolean isYesterday(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH,-1);
        if(cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR)
                &&cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)
                &&cal1.get(Calendar.DAY_OF_MONTH)==cal2.get(Calendar.DAY_OF_MONTH)){
            return true;
        }
        return false;

    }

}
