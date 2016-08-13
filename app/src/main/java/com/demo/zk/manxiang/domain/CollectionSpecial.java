package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/3.
 */
public class CollectionSpecial extends BaseDomain{

    private long collection_id;

    private long special_id;

    private String name;

    private String img;

    public long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(long collection_id) {
        this.collection_id = collection_id;
    }

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
