package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20.
 */
public class OrderDetail extends BaseDomain {

    private Order order;

    private Service service;

    private ServiceParam service_param;

    private Coupon coupon;

    private Painter painter;

    private List<Image> user_imgs;

    private List<Image> painter_imgs;

    private OrderAddress order_address;

    private OrderExpress order_express;

    public class Order {

        private long order_id;

        private String order_sn;

        private int status;

        private float total_money;

        private String user_message;

        private String painter_message;

        private String add_time;

        private String pay_time;

        private String deal_time;

        private String finish_time;

        private String remain_time;

        private String cancel_reason;

        public String getCancel_reason() {
            return cancel_reason;
        }

        public void setCancel_reason(String cancel_reason) {
            this.cancel_reason = cancel_reason;
        }

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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public float getTotal_money() {
            return total_money;
        }

        public void setTotal_money(float total_money) {
            this.total_money = total_money;
        }

        public String getUser_message() {
            return user_message;
        }

        public void setUser_message(String user_message) {
            this.user_message = user_message;
        }

        public String getPainter_message() {
            return painter_message;
        }

        public void setPainter_message(String painter_message) {
            this.painter_message = painter_message;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getDeal_time() {
            return deal_time;
        }

        public void setDeal_time(String deal_time) {
            this.deal_time = deal_time;
        }

        public String getFinish_time() {
            return finish_time;
        }

        public void setFinish_time(String finish_time) {
            this.finish_time = finish_time;
        }

        public String getRemain_time() {
            return remain_time;
        }

        public void setRemain_time(String remain_time) {
            this.remain_time = remain_time;
        }
    }

    public class Service {

        private long service_id;

        private String name;

        private String img;

        private String paint_time;

        public long getService_id() {
            return service_id;
        }

        public void setService_id(long service_id) {
            this.service_id = service_id;
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

        public String getPaint_time() {
            return paint_time;
        }

        public void setPaint_time(String paint_time) {
            this.paint_time = paint_time;
        }
    }

    public class ServiceParam {

        private long param_id;

        private int paint_type;

        private float postage;

        private float price;

        private int is_discount;

        private float discount_price;

        private int is_seckill;

        private float seckill_price;

        private String param_content;

        public long getParam_id() {
            return param_id;
        }

        public void setParam_id(long param_id) {
            this.param_id = param_id;
        }

        public int getPaint_type() {
            return paint_type;
        }

        public void setPaint_type(int paint_type) {
            this.paint_type = paint_type;
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

        public int getIs_discount() {
            return is_discount;
        }

        public void setIs_discount(int is_discount) {
            this.is_discount = is_discount;
        }

        public float getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(float discount_price) {
            this.discount_price = discount_price;
        }

        public int getIs_seckill() {
            return is_seckill;
        }

        public void setIs_seckill(int is_seckill) {
            this.is_seckill = is_seckill;
        }

        public float getSeckill_price() {
            return seckill_price;
        }

        public void setSeckill_price(float seckill_price) {
            this.seckill_price = seckill_price;
        }

        public String getParam_content() {
            return param_content;
        }

        public void setParam_content(String param_content) {
            this.param_content = param_content;
        }
    }

    public class Coupon {

        private int is_coupon;

        private String coupon_name;

        private float reduce_money;

        public int getIs_coupon() {
            return is_coupon;
        }

        public void setIs_coupon(int is_coupon) {
            this.is_coupon = is_coupon;
        }

        public String getCoupon_name() {
            return coupon_name;
        }

        public void setCoupon_name(String coupon_name) {
            this.coupon_name = coupon_name;
        }

        public float getReduce_money() {
            return reduce_money;
        }

        public void setReduce_money(float reduce_money) {
            this.reduce_money = reduce_money;
        }
    }

    public class Painter {

        private long painter_id;

        private String img;

        private String nickname;

        public long getPainter_id() {
            return painter_id;
        }

        public void setPainter_id(long painter_id) {
            this.painter_id = painter_id;
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
    }

    public class Image {

        private long img_id;

        private String img;

        public long getImg_id() {
            return img_id;
        }

        public void setImg_id(long img_id) {
            this.img_id = img_id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public class OrderAddress {

        private long address_id;

        private String consignee;

        private String province;

        private String city;

        private String county;

        private String street;

        private String detail;

        private String postcode;

        private String mobilephone;

        public long getAddress_id() {
            return address_id;
        }

        public void setAddress_id(long address_id) {
            this.address_id = address_id;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getMobilephone() {
            return mobilephone;
        }

        public void setMobilephone(String mobilephone) {
            this.mobilephone = mobilephone;
        }
    }

    public class OrderExpress {

        private long express_id;

        private String express_name;

        private String express_sn;

        private String express_url;

        public long getExpress_id() {
            return express_id;
        }

        public void setExpress_id(long express_id) {
            this.express_id = express_id;
        }

        public String getExpress_name() {
            return express_name;
        }

        public void setExpress_name(String express_name) {
            this.express_name = express_name;
        }

        public String getExpress_sn() {
            return express_sn;
        }

        public void setExpress_sn(String express_sn) {
            this.express_sn = express_sn;
        }

        public String getExpress_url() {
            return express_url;
        }

        public void setExpress_url(String express_url) {
            this.express_url = express_url;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceParam getService_param() {
        return service_param;
    }

    public void setService_param(ServiceParam service_param) {
        this.service_param = service_param;
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

    public List<Image> getUser_imgs() {
        return user_imgs;
    }

    public void setUser_imgs(List<Image> user_imgs) {
        this.user_imgs = user_imgs;
    }

    public List<Image> getPainter_imgs() {
        return painter_imgs;
    }

    public void setPainter_imgs(List<Image> painter_imgs) {
        this.painter_imgs = painter_imgs;
    }

    public OrderAddress getOrder_address() {
        return order_address;
    }

    public void setOrder_address(OrderAddress order_address) {
        this.order_address = order_address;
    }

    public OrderExpress getOrder_express() {
        return order_express;
    }

    public void setOrder_express(OrderExpress order_express) {
        this.order_express = order_express;
    }
}
