package com.back.model;

public class StuApply {
	//学生申请
	private int ID;
	private int StuID;
	private int StartID;
	private String StuName;
	private String Descripe;
	private String Tel;
	private String Status;        //状态
	private String School;
	private String Intention;
	private String Major;         //专业
	private String ApplyTime;     //申请时间
	private String EducationBgd;
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
	public int getStartID() {
		return StartID;
	}
	public void setStartID(int startID) {
		StartID = startID;
	}
	public String getDescripe() {
		return Descripe;
	}
	public void setDescripe(String descripe) {
		Descripe = descripe;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getIntention() {
		return Intention;
	}
	public void setIntention(String intention) {
		Intention = intention;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getApplyTime() {
		return ApplyTime;
	}
	public void setApplyTime(String applyTime) {
		ApplyTime = applyTime;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getEducationBgd() {
		return EducationBgd;
	}
	public void setEducationBgd(String educationBgd) {
		EducationBgd = educationBgd;
	}
	@Override
	public String toString() {
		return "StuApply [ID=" + ID + ", StuID=" + StuID + ", StartID=" + StartID + ", StuName=" + StuName
				+ ", Descripe=" + Descripe + ", Tel=" + Tel + ", Status=" + Status + ", School=" + School
				+ ", Intention=" + Intention + ", Major=" + Major + ", ApplyTime=" + ApplyTime + ", EducationBgd="
				+ EducationBgd + "]";
	}
	
	
	

	

}
