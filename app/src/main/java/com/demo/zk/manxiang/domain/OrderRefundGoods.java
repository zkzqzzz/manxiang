package com.demo.zk.manxiang.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class OrderRefundGoods extends BaseDomain{

    private Address address;

    private List<Express> express;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Express> getExpress() {
        return express;
    }

    public void setExpress(List<Express> express) {
        this.express = express;
    }

    public class Address {

        private String consignee;

        private String mobilephone;

        private String province;

        private String city;

        private String county;

        private String detail;

        private String postcode;

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getMobilephone() {
            return mobilephone;
        }

        public void setMobilephone(String mobilephone) {
            this.mobilephone = mobilephone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }
    }

    public class Express implements Serializable{

        private long express_id;

        private String name;

        private String code;

        private int sort_order;

        public long getExpress_id() {
            return express_id;
        }

        public void setExpress_id(long express_id) {
            this.express_id = express_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getSort_order() {
            return sort_order;
        }

        public void setSort_order(int sort_order) {
            this.sort_order = sort_order;
        }
    }

}
