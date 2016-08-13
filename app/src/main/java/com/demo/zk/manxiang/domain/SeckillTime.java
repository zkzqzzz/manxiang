package com.demo.zk.manxiang.domain;


import com.demo.zk.manxiang.utils.CalendarUtils;

import java.util.Calendar;

/**
 * Created by houg on 2016/4/20.
 */
public class SeckillTime extends BaseDomain{

    public static final String STATUS_0 = "已结束";

    public static final String STATUS_1 = "秒杀进行中";

    public static final String STATUS_2 = "即将开始";

    private long time_id;

    private String begin_time;

    private int begin_year;

    private int begin_month;

    private int begin_day;

    private int begin_second;

    private int begin_minute;

    private  int begin_hour;

    private String end_time;

    private String current_time;

    private String status_name;

    public long getTime_id() {
        return time_id;
    }

    public void setTime_id(long time_id) {
        this.time_id = time_id;
    }

    public String getBegin_time() {
        return begin_time;
    }

   public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
        if(begin_time!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(CalendarUtils.parse(begin_time,"yyyy-MM-dd HH:mm:ss"));
            this.begin_year = cal.get(Calendar.YEAR);//获取年份
            this.begin_month=cal.get(Calendar.MONTH);//获取月份
            this.begin_day=cal.get(Calendar.DATE);//获取日
            this.begin_hour=cal.get(Calendar.HOUR);//小时
            this.begin_minute=cal.get(Calendar.MINUTE);//分
            this.begin_second= cal.get(Calendar.SECOND);//秒
        }
    }

    public int getBegin_year() {
        return begin_year;
    }

    public void setBegin_year(int begin_year) {
        this.begin_year = begin_year;
    }

    public int getBegin_month() {
        return begin_month;
    }

    public void setBegin_month(int begin_month) {
        this.begin_month = begin_month;
    }

    public int getBegin_hour() {
        return begin_hour;
    }

    public void setBegin_hour(int begin_hour) {
        this.begin_hour = begin_hour;
    }

    public int getBegin_minute() {
        return begin_minute;
    }

    public void setBegin_minute(int begin_minute) {
        this.begin_minute = begin_minute;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public int getBegin_day() {
        return begin_day;
    }

    public void setBegin_day(int begin_day) {
        this.begin_day = begin_day;
    }

    public int getBegin_second() {
        return begin_second;
    }

    public void setBegin_second(int begin_second) {
        this.begin_second = begin_second;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }
}
