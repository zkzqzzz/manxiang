package com.hyphenate.easeui.domain;


import java.io.Serializable;

/**
 * Created by HG on 2015/10/12.
 */
public class User implements Serializable {

    private Long user_id;

    private String nickname;

    private String mobilephone;

    private String img;

    private String sid;


    private int is_first_login;// 是否是第一次登录,0:表示否 1：表示是

    private int login_type ;// 登录方式：1普通登录 2第三方登录



    private String realname;
    private String sex;



    private String birthday;

    private String im_username;

    private String im_password;

    public User() {

    }

    public User(Long user_id, String sid, String nickname, String mobilephone, String img
            , String realname, String sex, String birthday) {


        this.user_id = user_id;
        this.nickname = nickname;
        this.mobilephone = mobilephone;
        this.img = img;
        this.sid = sid;
      this.realname=realname;
          this.sex=sex;
        this.birthday=birthday;
    }
    public User(Long user_id, String sid, String nickname, String img
            , String realname, String sex, String birthday) {


        this.user_id = user_id;
        this.nickname = nickname;
        this.img = img;
        this.sid = sid;
        this.realname=realname;
        this.sex=sex;
        this.birthday=birthday;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getIs_first_login() {
        return is_first_login;
    }

    public void setIs_first_login(int is_first_login) {
        this.is_first_login = is_first_login;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIm_username() {
        return im_username;
    }

    public void setIm_username(String im_username) {
        this.im_username = im_username;
    }

    public String getIm_password() {
        return im_password;
    }

    public void setIm_password(String im_password) {
        this.im_password = im_password;
    }
}
