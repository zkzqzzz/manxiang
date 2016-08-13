package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Evaluated extends BaseDomain{


    private long comment_id;
    private long order_id;
    private long service_id;
    private String service_name;
    private String service_img;
    private String param_content;
    private float point;
    private String content;
    private String add_time;
    private int count;

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
    public long getComment_id() {
        return comment_id;
    }
    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }
    public long getOrder_id() {
        return order_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }
    public long getService_id() {
        return service_id;
    }
    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
    public String getService_name() {
        return service_name;
    }
    public void setService_img(String service_img) {
        this.service_img = service_img;
    }
    public String getService_img() {
        return service_img;
    }
    public void setPoint(float point) {
        this.point = point;
    }
    public float getPoint() {
        return point;
    }
    public void setContent(String content) {
        this.content = content;
    }


    public void setParam_content(String param_content) {
        this.param_content = param_content;
    }
    public String getContent() {
        return content;
    }
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
    public String getAdd_time() {
        return add_time;
    }

    public String getParam_content() {
        return param_content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
