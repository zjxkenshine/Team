package com.back.model;

public class StuCollect {
	private int CollectID;
	private int RecruitID;
	private int FirmID;
	private int StuID;
	private String CollectTime;
	public int getCollectID() {
		return CollectID;
	}
	public void setCollectID(int collectID) {
		CollectID = collectID;
	}
	public int getRecruitID() {
		return RecruitID;
	}
	public void setRecruitID(int recruitID) {
		RecruitID = recruitID;
	}
	public int getFirmID() {
		return FirmID;
	}
	public void setFirmID(int firmID) {
		FirmID = firmID;
	}
	public String getCollectTime() {
		return CollectTime;
	}
	public void setCollectTime(String collectTime) {
		CollectTime = collectTime;
	}
	public int getStuID() {
		return StuID;
	}
	public void setStuID(int stuID) {
		StuID = stuID;
	}
	@Override
	public String toString() {
		return "Collect [CollectID=" + CollectID + ", RecruitID=" + RecruitID + ", FirmID=" + FirmID + ", StuID="
				+ StuID + ", CollectTime=" + CollectTime + "]";
	}
	
	
	

}
