package com.demo.zk.manxiang.domain;

/**
 * Created by houg on 2016/4/24.
 */
public class Category extends BaseDomain{

    private long cat_id;

    private String name;

    private int sort_order;

    public long getCat_id() {
        return cat_id;
    }

    public void setCat_id(long cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }
}
