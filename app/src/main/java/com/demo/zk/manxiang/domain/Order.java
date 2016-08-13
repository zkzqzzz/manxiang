package com.demo.zk.manxiang.domain;


import java.util.List;

/**
 * Created by HG on 2015/10/12.
 */
public class Order extends BaseDomain {

    private Long order_id;//订单id

    private String order_sn;//订单号

    private String money;//订单金额

    private String service_name;//服务名称

    private String service_img_thumb;//服务缩略图

    private int payment_status;//支付状态(0:未付款 1:已付款)

    private int order_status;//订单状态（1:已下单 2:待评论[画家已提交] 3:已完成）

    private  String add_time;//用户提交时间

    private String deal_time;//画家处理完成时间

    private int type;//订单类型（1：普通订单 2：秒杀订单）

    private Long value_id;//值id(所选服务id|秒杀id)

    private int payment_type;//支付类型1：支付宝 2：微信

    private String user_message;//用户留言

    private String painter_message;//画家留言

    private List<OrderImg> user_imgs;

    private List<OrderImg> painter_imgs;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_img_thumb() {
        return service_img_thumb;
    }

    public void setService_img_thumb(String service_img_thumb) {
        this.service_img_thumb = service_img_thumb;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getValue_id() {
        return value_id;
    }

    public void setValue_id(Long value_id) {
        this.value_id = value_id;
    }

    public int getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(int payment_type) {
        this.payment_type = payment_type;
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

    public List<OrderImg> getUser_imgs() {
        return user_imgs;
    }

    public void setUser_imgs(List<OrderImg> user_imgs) {
        this.user_imgs = user_imgs;
    }

    public List<OrderImg> getPainter_imgs() {
        return painter_imgs;
    }

    public void setPainter_imgs(List<OrderImg> painter_imgs) {
        this.painter_imgs = painter_imgs;
    }
}
