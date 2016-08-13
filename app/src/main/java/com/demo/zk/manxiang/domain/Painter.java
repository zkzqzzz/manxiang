package com.demo.zk.manxiang.domain;


import java.util.List;

/**
 * Created by HG on 2015/10/12.
 */
public class Painter extends BaseDomain {

    private Long painter_id;//画家id

    private String expert;

    private float point;

    private int transaction_count;//交易数

    private int praise_count;//被点赞数

    private String signature;//个性签名

    private String img;//画家头像

    private String background_img;

    private String nickname;//画家昵称

    private String personal_introduction;//画家个人介绍

    private int is_collection;

    private String sortLetters;//显示数据拼音的首字母

    private String reg_time;

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    public Long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(Long painter_id) {
        this.painter_id = painter_id;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public int getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(int transaction_count) {
        this.transaction_count = transaction_count;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }
}
