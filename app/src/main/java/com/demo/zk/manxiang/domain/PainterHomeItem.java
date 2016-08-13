package com.demo.zk.manxiang.domain;

/**
 * Created by houg on 2016/5/6.
 */
public class PainterHomeItem extends BaseDomain{

      private long item_id;

      private String img;

      private int type;

      private long value_id;

      private PainterService service;

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getValue_id() {
        return value_id;
    }

    public void setValue_id(long value_id) {
        this.value_id = value_id;
    }

    public PainterService getService() {
        return service;
    }

    public void setService(PainterService service) {
        this.service = service;
    }
}
