package com.demo.zk.manxiang.domain;


/**
 * Created by HG on 2015/10/12.
 */
public class PainterComment extends BaseDomain {

    private long comment_id;

    private long user_id;

    private String user_img;

    private String user_nickname;

    private String param_content;

    private float point;

    private String content;

    private String service_name;

    private String service_img;

    private String add_time;

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getParam_content() {
        return param_content;
    }

    public void setParam_content(String param_content) {
        this.param_content = param_content;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
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
}
