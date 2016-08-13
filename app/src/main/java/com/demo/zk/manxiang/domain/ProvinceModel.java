package com.demo.zk.manxiang.domain;

import java.util.List;

public class ProvinceModel extends BaseDomain{

	private String name;

	private long regionId;
	private List<CityModel> cityList;
	
	public ProvinceModel() {
		super();
	}

	public ProvinceModel(String name, List<CityModel> cityList) {
		super();
		this.name = name;
		this.cityList = cityList;
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

	public List<CityModel> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityModel> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "ProvinceModel{" +
				"name='" + name + '\'' +
				", regionId=" + regionId +
				", cityList=" + cityList +
				'}';
	}
}
