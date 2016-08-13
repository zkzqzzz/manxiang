package com.demo.zk.manxiang.domain;

import android.graphics.Bitmap;

/**
 * Created by WG on 2016/3/29.
 */
public class Special extends BaseDomain{

    private long special_id;

    private String name;

    private String img;

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

    public void setImg(String img) {
        this.img = img;
    }
}
