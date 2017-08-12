package com.back.model;

public class Student_Province {
	private int province_id;
	private String province;
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Student_Province [province_id=" + province_id + ", province=" + province + "]";
	}
	
	

}
