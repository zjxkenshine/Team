package com.back.model;

public class JobFair {
     private int ID;
     private String Title;
     private String Address;
     private int FirmNumber;
     private int PostNumber;
     private String Date;
     private String FirmIDs;
     
     private int SelfPostNumber;
     private int FairID;
     private String RecruitIDs;
     private String Content;
     private String FirmName;
     
     
     public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getRecruitIDs() {
		return RecruitIDs;
	}
	public void setRecruitIDs(String recruitIDs) {
		RecruitIDs = recruitIDs;
	}
	public int getFairID() {
		return FairID;
	}
	public void setFairID(int fairID) {
		FairID = fairID;
	}
	public int getSelfPostNumber() {
		return SelfPostNumber;
	}
	public void setSelfPostNumber(int selfPostNumber) {
		SelfPostNumber = selfPostNumber;
	}
	
     
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getFirmNumber() {
		return FirmNumber;
	}
	public void setFirmNumber(int firmNumber) {
		FirmNumber = firmNumber;
	}
	public int getPostNumber() {
		return PostNumber;
	}
	public void setPostNumber(int postNumber) {
		PostNumber = postNumber;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getFirmIDs() {
		return FirmIDs;
	}
	public void setFirmIDs(String firmIDs) {
		FirmIDs = firmIDs;
	}
     
     
}
