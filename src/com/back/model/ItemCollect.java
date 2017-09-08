package com.back.model;

public class ItemCollect {
	//项目收藏
	private int ID;
	private int StuID;
	private String StuName;    //负责人姓名（与上面ID不同）
	private String StartID;   //项目ID
	private String StartName;
	private String Tel;
	private String CollectTime;
	private String Email;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getStuID() {
		return StuID;
	}
	public void setStuID(int stuID) {
		StuID = stuID;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getStartID() {
		return StartID;
	}
	public void setStartID(String startID) {
		StartID = startID;
	}
	public String getStartName() {
		return StartName;
	}
	public void setStartName(String startName) {
		StartName = startName;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getCollectTime() {
		return CollectTime;
	}
	public void setCollectTime(String collectTime) {
		CollectTime = collectTime;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
