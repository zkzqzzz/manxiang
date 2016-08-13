package com.demo.zk.manxiang.domain;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;

import java.math.BigDecimal;

/**
 * Created by HG on 2015/10/12.
 */
public class Seckill extends BaseDomain {

    @Id
    @NoAutoIncrement
    private Long seckill_id;//秒杀id

    private String name;//秒杀名称

    private String subtitle;//副标题

    private String img ;

    private long service_id;

    private long param_id;//规格参数id

    private BigDecimal seckill_price;

    private BigDecimal price;

    private int stock_count;//库存

    private long start_time;

    private long end_time;

    public BigDecimal getSeckill_price() {
        return seckill_price;
    }

    public void setSeckill_price(BigDecimal seckill_price) {
        this.seckill_price = seckill_price;
    }

    public Long getSeckill_id() {
        return seckill_id;
    }

    public void setSeckill_id(Long seckill_id) {
        this.seckill_id = seckill_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public long getParam_id() {
        return param_id;
    }

    public void setParam_id(long param_id) {
        this.param_id = param_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }
}
