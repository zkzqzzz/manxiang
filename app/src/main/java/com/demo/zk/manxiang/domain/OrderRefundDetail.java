package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/6/3.
 */
public class OrderRefundDetail extends BaseDomain {

    private long refund_id;

    private int refund_status;

    private String refund_money;

    private String reason;

    private String reply_title;

    private String reply;

    private String add_time;

    private String deal_time;

    private long painter_id;

    private String painter_nickname;

    private String painter_img;

    private long user_id;

    private String user_nickname;

    private String user_img;

    public long getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(long refund_id) {
        this.refund_id = refund_id;
    }

    public int getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(int refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(String refund_money) {
        this.refund_money = refund_money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReply_title() {
        return reply_title;
    }

    public void setReply_title(String reply_title) {
        this.reply_title = reply_title;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public String getPainter_nickname() {
        return painter_nickname;
    }

    public void setPainter_nickname(String painter_nickname) {
        this.painter_nickname = painter_nickname;
    }

    public String getPainter_img() {
        return painter_img;
    }

    public void setPainter_img(String painter_img) {
        this.painter_img = painter_img;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }
}
