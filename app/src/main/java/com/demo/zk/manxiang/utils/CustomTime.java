package com.demo.zk.manxiang.utils;

/**
 * Created by HG on 2015/10/28.
 */
public class CustomTime {

    private int hours;

    private int minutes;

    private int seconds;



    public CustomTime() {
    }

    public CustomTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public long getTime(){
        return hours*60*60*1000+minutes*60*1000+seconds*1000;
    }

    public boolean minus(){
        if(seconds>0){
            seconds = seconds - 1;
        }else {
            if(minutes==0&&hours>0){
               hours = hours - 1;
                minutes = 59;
            }else if(minutes>0){
                minutes = minutes - 1;
                seconds = 59;
            }
        }
        return hours>0||minutes>0||seconds>0;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
