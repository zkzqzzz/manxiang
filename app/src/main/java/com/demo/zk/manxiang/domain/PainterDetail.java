package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/16.
 */
public class PainterDetail {

    private long painter_id;

    private String nickname;

    private String img;

    private String background_img;

    private String expert;

    private String signature;

    private float point;

    private String transaction_count;

    private String reg_time;

    private String personal_introduction;

    private int is_collection;

    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(String transaction_count) {
        this.transaction_count = transaction_count;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public String getPersonal_introduction() {
        return personal_introduction;
    }

    public void setPersonal_introduction(String personal_introduction) {
        this.personal_introduction = personal_introduction;
    }

    public int getIs_collection() {
        return is_collection;
    }

    public void setIs_collection(int is_collection) {
        this.is_collection = is_collection;
    }
}
