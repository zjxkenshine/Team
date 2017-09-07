package com.back.model;

public class Resume {
	private int ID;
	private int Stu_ID;
	private String FirmName;
	private String Resume;
	private String Major;
	private String RealName;
	private String EducationBgd;
	private String Intention;
	private String ResumeTime;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getStu_ID() {
		return Stu_ID;
	}
	public void setStu_ID(int stu_ID) {
		Stu_ID = stu_ID;
	}
	public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getResume() {
		return Resume;
	}
	public void setResume(String resume) {
		Resume = resume;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public String getEducationBgd() {
		return EducationBgd;
	}
	public void setEducationBgd(String educationBgd) {
		EducationBgd = educationBgd;
	}
	public String getIntention() {
		return Intention;
	}
	public void setIntention(String intention) {
		Intention = intention;
	}
	public String getResumeTime() {
		return ResumeTime;
	}
	public void setResumeTime(String resumeTime) {
		ResumeTime = resumeTime;
	}
	@Override
	public String toString() {
		return "Resume [ID=" + ID + ", Stu_ID=" + Stu_ID + ", FirmName=" + FirmName + ", Resume=" + Resume + ", Major="
				+ Major + ", RealName=" + RealName + ", EducationBgd=" + EducationBgd + ", Intention=" + Intention
				+ ", ResumeTime=" + ResumeTime + "]";
	}
	
	
	
	
}
