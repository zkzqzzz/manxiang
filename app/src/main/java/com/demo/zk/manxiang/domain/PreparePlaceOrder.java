package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class PreparePlaceOrder extends BaseDomain{

    private Coupon coupon;

    private Painter painter;

    private Service service;

    private Param service_param;

    private float total_money;

    public class Coupon {

        private String coupon_name;

        private int is_coupon;

        private float reduce_money;

        public String getCoupon_name() {
            return coupon_name;
        }

        public void setCoupon_name(String coupon_name) {
            this.coupon_name = coupon_name;
        }

        public int getIs_coupon() {
            return is_coupon;
        }

        public void setIs_coupon(int is_coupon) {
            this.is_coupon = is_coupon;
        }

        public float getReduce_money() {
            return reduce_money;
        }

        public void setReduce_money(float reduce_money) {
            this.reduce_money = reduce_money;
        }
    }

    public class Painter {

        private String img;

        private String nickname;

        private long painter_id;

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

        public long getPainter_id() {
            return painter_id;
        }

        public void setPainter_id(long painter_id) {
            this.painter_id = painter_id;
        }
    }

    public class Service {

        private String img;

        private String name;

        private String paint_time;

        private long service_id;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPaint_time() {
            return paint_time;
        }

        public void setPaint_time(String paint_time) {
            this.paint_time = paint_time;
        }

        public long getService_id() {
            return service_id;
        }

        public void setService_id(long service_id) {
            this.service_id = service_id;
        }
    }

    public class Param {

        private float discount_price;

        private int is_discount;

        private int is_seckill;

        private int paint_type;

        private long param_id;

        private String param_name;

        private float postage;

        private float price;

        private float seckill_price;

        public float getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(float discount_price) {
            this.discount_price = discount_price;
        }

        public int getIs_discount() {
            return is_discount;
        }

        public void setIs_discount(int is_discount) {
            this.is_discount = is_discount;
        }

        public int getIs_seckill() {
            return is_seckill;
        }

        public void setIs_seckill(int is_seckill) {
            this.is_seckill = is_seckill;
        }

        public int getPaint_type() {
            return paint_type;
        }

        public void setPaint_type(int paint_type) {
            this.paint_type = paint_type;
        }

        public long getParam_id() {
            return param_id;
        }

        public void setParam_id(long param_id) {
            this.param_id = param_id;
        }

        public String getParam_name() {
            return param_name;
        }

        public void setParam_name(String param_name) {
            this.param_name = param_name;
        }

        public float getPostage() {
            return postage;
        }

        public void setPostage(float postage) {
            this.postage = postage;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public float getSeckill_price() {
            return seckill_price;
        }

        public void setSeckill_price(float seckill_price) {
            this.seckill_price = seckill_price;
        }
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Param getService_param() {
        return service_param;
    }

    public void setService_param(Param service_param) {
        this.service_param = service_param;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }
}