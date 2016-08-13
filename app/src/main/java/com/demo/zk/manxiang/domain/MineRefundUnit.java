package com.demo.zk.manxiang.domain;

import android.graphics.Bitmap;

/**
 *
 * Created by WG on 2016/3/27.
 */
public class MineRefundUnit extends BaseDomain implements Comparable<MineRefundUnit>{

    public static final int CODE_SUCCESS = 1;
    public static final String SUCCESS = "状态：退款成功";
    public static final int CODE_REFUSE = 2;
    public static final String REFUSE = "状态：退款遭拒";
    public static final int CODE_APPLY = 3;
    public static final String APPLY = "状态：接收申请";
    public static final int CODE_REFUNDING = 4;
    public static final String REFUNDING = "状态：退款中";

    private Bitmap art_pic;
    private Bitmap art_photo;
    private String art_content;
    private String art_names;
    private String art_method;
    private String art_offer;
    private String state;
    private int stateCode;
    private double fum_money;
    private double refund_yf_money;

    public MineRefundUnit() {
        super();
    }

    public MineRefundUnit(int stateCode, String state) {
        this.stateCode = stateCode;
        this.state = state;
    }

    public Bitmap getArt_pic() {
        return art_pic;
    }

    public Bitmap getArt_photo() {
        return art_photo;
    }

    public String getArt_content() {
        return art_content;
    }

    public String getArt_names() {
        return art_names;
    }

    public String getArt_offer() {
        return art_offer;
    }

    public String getArt_method() {
        return art_method;
    }

    public double getFum_money() {
        return fum_money;
    }

    public double getRefund_yf_money() {
        return refund_yf_money;
    }

    public String getState() {
        return state;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setArt_pic(Bitmap art_pic) {
        this.art_pic = art_pic;
    }

    public void setArt_photo(Bitmap art_photo) {
        this.art_photo = art_photo;
    }

    public void setArt_content(String art_content) {
        this.art_content = art_content;
    }

    public void setArt_names(String art_names) {
        this.art_names = art_names;
    }

    public void setArt_offer(String art_offer) {
        this.art_offer = art_offer;
    }

    public void setArt_method(String art_method) {
        this.art_method = art_method;
    }

    public void setFum_money(double fum_money) {
        this.fum_money = fum_money;
    }

    public void setRefund_yf_money(double refund_yf_money) {
        this.refund_yf_money = refund_yf_money;
    }
    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public int compareTo(MineRefundUnit another) {
        int code1 = this.getStateCode();
        int code2 = another.getStateCode();
        if (code1 < code2) {
            return 1;
        }
        if (code1 > code2) {
            return -1;
        }
        return -1;
    }

}
