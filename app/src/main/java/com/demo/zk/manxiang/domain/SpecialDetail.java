package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by WG on 2016/3/29.
 */
public class SpecialDetail extends BaseDomain{

    private long special_id;

    private int style_type;

    private String name;

    private String img;

    private String description;

    private List<PainterService> services;

    private int is_collection;//是否收藏

    public long getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(long special_id) {
        this.special_id = special_id;
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

    public int getStyle_type() {
        return style_type;
    }

    public void setStyle_type(int style_type) {
        this.style_type = style_type;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PainterService> getServices() {
        return services;
    }

    public void setServices(List<PainterService> services) {

    }

    public int getIs_collection() {
        return is_collection;
    }

    public void setIs_collection(int is_collection) {
        this.is_collection = is_collection;
    }
}
