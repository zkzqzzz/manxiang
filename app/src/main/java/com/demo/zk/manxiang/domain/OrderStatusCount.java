package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/12.
 */
public class OrderStatusCount extends BaseDomain{

    private int status;

    private int count;

    private int user_status;

    private long comment_id;

    private long remind_id;

    private long order_id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getRemind_id() {
        return remind_id;
    }

    public void setRemind_id(long remind_id) {
        this.remind_id = remind_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }
}
