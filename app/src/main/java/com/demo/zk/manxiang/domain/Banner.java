package com.demo.zk.manxiang.domain;

/**
 * Created by houg on 2015/10/27.
 */
public class Banner extends BaseDomain {

    private Long banner_id ;

    private int type ;//type( 1:跳转网页URL 2:画家服务详情页 3：秒杀详情页 )

    private String name ;// banner名称

    private int cat_id; // Banner分类

    private Long value_id ;//画家服务|秒杀对应的id

    private String img_thumb ;// 缩略图

    private String img ;//原图

    private String url ;//若type=1,此处存放跳转网页地址

    private String description ;// 描述

    public Long getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Long banner_id) {
        this.banner_id = banner_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public Long getValue_id() {
        return value_id;
    }

    public void setValue_id(Long value_id) {
        this.value_id = value_id;
    }

    public String getImg_thumb() {
        return img_thumb;
    }

    public void setImg_thumb(String img_thumb) {
        this.img_thumb = img_thumb;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
