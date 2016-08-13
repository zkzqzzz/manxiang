package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/12.
 */
public class OrderList extends BaseDomain {

    public static final int CODE_ALL = 0;
    public static final int CODE_PAY = 10;
    public static final String STATUS_PAY = "状态：未付款";
    public static final int CODE_PIC = 11;
    public static final String STATUS_CREATE = "状态：已付款待作画";
    public static final int CODE_REC = 21;
    public static final String STATUS_RECEIVE = "状态：已发画代收画";
    public static final int CODE_EVA = 31;
    public static final String STATUS_EVALUATE = "状态：交易成功 未评价";
    public static final int CODE_FIN = 41;
    public static final int CODE_CAN = 51;
    public static final String STATUS_CANCEL = "状态：交易关闭";

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

    private float total_money;

    private int status;

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

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
