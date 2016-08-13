package com.demo.zk.manxiang.domain;

public class DistrictModel extends BaseDomain{
	private String name;
	private String zipcode;
	private long regionId;
	public DistrictModel() {
		super();
	}

	public DistrictModel(String name, String zipcode) {
		super();
		this.name = name;
		this.zipcode = zipcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "DistrictModel{" +
				"name='" + name + '\'' +
				", zipcode='" + zipcode + '\'' +
				", regionId=" + regionId +
				'}';
	}
}
