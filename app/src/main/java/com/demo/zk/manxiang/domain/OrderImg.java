package com.demo.zk.manxiang.domain;


/**
 * Created by HG on 2015/10/12.
 */
public class OrderImg extends BaseDomain {

    private Long img_id;//图片id

    private Long order_id;//订单id

    private  String img;//图片地址

    private String img_thumb;//缩略图地址

    public Long getImg_id() {
        return img_id;
    }

    public void setImg_id(Long img_id) {
        this.img_id = img_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg_thumb() {
        return img_thumb;
    }

    public void setImg_thumb(String img_thumb) {
        this.img_thumb = img_thumb;
    }
}
