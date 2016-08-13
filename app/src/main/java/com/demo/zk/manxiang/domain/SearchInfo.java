package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by houg on 2016/5/2.
 */
public class SearchInfo extends BaseDomain{

    private List<PriceVo> prices;

    private List<ParamValue> discount_and_service;

    private List<Category> cats;

    public List<Category> getCats() {
        return cats;
    }

    public void setCats(List<Category> cats) {
        this.cats = cats;
    }

    public List<PriceVo> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceVo> prices) {
        this.prices = prices;
    }

    public List<ParamValue> getDiscount_and_service() {
        return discount_and_service;
    }

    public void setDiscount_and_service(List<ParamValue> discount_and_service) {
        this.discount_and_service = discount_and_service;
    }
}
