package com.back.model;

public class School {
	//学校信息校正
	
	private int ID;
	private String Province;
	private String University;
	private String College;
	private int StuID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public int getStuID() {
		return StuID;
	}
	public void setStuID(int stuID) {
		StuID = stuID;
	}
	@Override
	public String toString() {
		return "School [ID=" + ID + ", Province=" + Province + ", University=" + University + ", College=" + College
				+ ", StuID=" + StuID + "]";
	}
	
	

}
