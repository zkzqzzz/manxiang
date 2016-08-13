package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/2.
 */
public class CollectionService extends BaseDomain{

    private long collection_id;

    private String nickname;

    private long painter_id;

    private String painter_img;

    private float price;

    private long service_id;

    private String service_img;

    private String service_name;

    private boolean checked;

    public long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(long collection_id) {
        this.collection_id = collection_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public String getPainter_img() {
        return painter_img;
    }

    public void setPainter_img(String painter_img) {
        this.painter_img = painter_img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public String getService_img() {
        return service_img;
    }

    public void setService_img(String service_img) {
        this.service_img = service_img;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
