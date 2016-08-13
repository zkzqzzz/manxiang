package com.demo.zk.manxiang.domain;


/**
 * Created by houg on 2015/10/18.
 */
public class Comment extends BaseDomain {

    private  Long comment_id;//评论id

    private Long user_id;//用户id

    private  String user_img;//用户头像

    private  String user_nickname;//用户昵称

    private String  painter_id;//画家id

    private  int is_praise;//用户评论时是否点了赞

    private float point;

    private String content;//评论内容

    private String add_time;//评论时间

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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

    public String getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(String painter_id) {
        this.painter_id = painter_id;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
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
}
