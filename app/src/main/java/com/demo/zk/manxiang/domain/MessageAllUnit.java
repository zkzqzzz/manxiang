package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/4/14.
 */
public class MessageAllUnit extends BaseDomain{

    public static final String ACTIVITY = "秒杀即将开始，快去抢";
    public static final String HELPER = "查看订单详情";
    public static final String WARM = "秒杀即将开始，快去抢";

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
