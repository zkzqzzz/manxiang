package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/29.
 */
public class OrderRefund extends BaseDomain{

    private long refund_id;

    private String refund_money;

    private String description;

    public long getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(long refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(String refund_money) {
        this.refund_money = refund_money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
