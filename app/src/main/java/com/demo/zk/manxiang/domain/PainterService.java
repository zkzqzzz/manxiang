package com.demo.zk.manxiang.domain;


import java.math.BigDecimal;

/**
 * Created by HG on 2015/10/12.
 */
public class PainterService extends BaseDomain {

    private long service_id;//服务id

    private BigDecimal price;//服务价格

    private String service_name;//服务名称

    private String service_img;//服务图片

    private String name; //服务名称

    private String img;//服务图片

    private int praise_count;//点赞数

    private long painter_id;

    private String painter_img;

    private String nickname;

    private int is_discount ;

    private BigDecimal discount_price;

    public int getIs_discount() {
        return is_discount;
    }

    public void setIs_discount(int is_discount) {
        this.is_discount = is_discount;
    }

    public BigDecimal getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(BigDecimal discount_price) {
        this.discount_price = discount_price;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
