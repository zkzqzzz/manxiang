package com.demo.zk.manxiang.domain;

/**
 * Created by Administrator on 2016/5/9.
 */
public class UserAddress extends BaseDomain {

    private long  address_id;//地址id

    public UserAddress() {
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public long getProvince_id() {
        return province_id;
    }

    public void setProvince_id(long province_id) {
        this.province_id = province_id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public long getCounty_id() {
        return county_id;
    }

    public void setCounty_id(long county_id) {
        this.county_id = county_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
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

    private String consignee;//收件人姓名
    private long  province_id;//省份id
    private long city_id;//城市id
    private long  county_id;//区县id
    private String street;//街道名称
    private String detail;//详细地址
    private String postcode;//邮编
    private String mobilephone;//手机号码
    private String is_default;//是否默认(1是 0否)
    private String province;//省份名称
    private String city;//城市名称
    private String county;//区县名称



}
