package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by houg on 2016/5/6.
 */
public class PainterHomeBean extends BaseDomain{

    private long module_id;

    private int type;

    private List<PainterHomeItem> items;

    public long getModule_id() {
        return module_id;
    }

    public void setModule_id(long module_id) {
        this.module_id = module_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<PainterHomeItem> getItems() {
        return items;
    }

    public void setItems(List<PainterHomeItem> items) {
        this.items = items;
    }
}
