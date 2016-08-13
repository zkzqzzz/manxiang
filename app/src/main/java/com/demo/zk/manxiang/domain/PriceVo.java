package com.demo.zk.manxiang.domain;

/**
 * Created by houg on 2016/5/2.
 */
public class PriceVo extends BaseDomain{

    private String name;

    private String begin_price;

    private  String  end_price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBegin_price() {
        return begin_price;
    }

    public void setBegin_price(String begin_price) {
        this.begin_price = begin_price;
    }

    public String getEnd_price() {
        return end_price;
    }

    public void setEnd_price(String end_price) {
        this.end_price = end_price;
    }
}
