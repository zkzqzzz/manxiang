package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/6/3.
 */
public class OrderRefundList extends BaseDomain {

    public static final int CODE_UN_APPLY = 0;
    public static final int CODE_APPLY = 1;
    public static final String APPLY = "状态：申请退款";
    public static final int CODE_ACCEPT = 2;
    public static final String ACCEPT = "状态：接受申请";
    public static final int CODE_REFUSE = 3;
    public static final String REFUSE = "状态：退款遭拒";
    public static final int CODE_REFUNDING = 4;
    public static final String REFUNDING = "状态：退款中";
    public static final int CODE_SUCCESS = 5;
    public static final String SUCCESS = "状态：退款成功";
    private long order_id;

    private String order_sn;

    private long painter_id;

    private String painter_img;

    private String nickname;

    private long service_id;

    private String service_name;

    private String service_img;

    private long param_id;

    private String param_content;

    private String postage;

    private String total_money;

    private int refund_status;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public String getPainter_img() {
        return painter_img;
    }

    public void setPainter_img(String painter_img) {
        this.painter_img = painter_img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_img() {
        return service_img;
    }

    public void setService_img(String service_img) {
        this.service_img = service_img;
    }

    public long getParam_id() {
        return param_id;
    }

    public void setParam_id(long param_id) {
        this.param_id = param_id;
    }

    public String getParam_content() {
        return param_content;
    }

    public void setParam_content(String param_content) {
        this.param_content = param_content;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public int getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(int refund_status) {
        this.refund_status = refund_status;
    }
}
