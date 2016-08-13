package com.demo.zk.manxiang.wxpay;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrepayResponse implements Serializable {

	private static final long serialVersionUID = -6775005831764646246L;

	private String appid;

	private String partnerid;

	private String noncestr;

	private String sign;

	private String prepayid;

	@SerializedName("package")
	private String packageValue;

	private String timestamp;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPackageValue() {
		return packageValue;
	}

	public void setPackageValue(String packageValue) {
		this.packageValue = packageValue;
	}
}
