package com.demo.zk.manxiang.domain;

import java.util.List;

/**
 * Created by houg on 2016/5/2.
 */
public class SearchVo extends BaseDomain{

    private String keyword;

    private int sort_type = 1;

    private String begin_price;

    private  String  end_price;

    private List<ParamValue> paramValues;

    private long cat_id = 1;

    private int count = 10;

    private  int page;

    public int page_add(){
        page ++;
        return  page;
    }

    public int page_des(){
        page --;
        return  page;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getSort_type() {
        return sort_type;
    }

    public void setSort_type(int sort_type) {
        this.sort_type = sort_type;
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

    public List<ParamValue> getParamValues() {
        return paramValues;
    }

    public void setParamValues(List<ParamValue> paramValues) {
        this.paramValues = paramValues;
    }

    public long getCat_id() {
        return cat_id;
    }

    public void setCat_id(long cat_id) {
        this.cat_id = cat_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
