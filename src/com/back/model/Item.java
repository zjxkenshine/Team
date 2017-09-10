package com.back.model;

public class Item {
	
	private int ID;
	private int StuID;
	private int FirmID;
	private String StuName;
	private String FirmName;
	private String ItemName;
	private String Addresss;
	private String School;
	private String Intention;
	private int Number;
	private String Tel;
	private String QQ;
	private String Email;
	private int PatentNum;  //专利数
	private String NeedDiscripe; //所需人才的描述
	private String BusinessPlan;    //商业计划书
	private String Descripe;    //审核时的描述
	private String CheckStatus;   //审核状态
	private String Status;
	private int NeedNumber;  //需要人数
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
	public int getFirmID() {
		return FirmID;
	}
	public void setFirmID(int firmID) {
		FirmID = firmID;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getAddresss() {
		return Addresss;
	}
	public void setAddresss(String addresss) {
		Addresss = addresss;
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
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPatentNum() {
		return PatentNum;
	}
	public void setPatentNum(int patentNum) {
		PatentNum = patentNum;
	}
	public String getNeedDiscripe() {
		return NeedDiscripe;
	}
	public void setNeedDiscripe(String needDiscripe) {
		NeedDiscripe = needDiscripe;
	}
	public String getBusinessPlan() {
		return BusinessPlan;
	}
	public void setBusinessPlan(String businessPlan) {
		BusinessPlan = businessPlan;
	}
	public String getDescripe() {
		return Descripe;
	}
	public void setDescripe(String descripe) {
		Descripe = descripe;
	}
	public String getCheckStatus() {
		return CheckStatus;
	}
	public void setCheckStatus(String checkStatus) {
		CheckStatus = checkStatus;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getNeedNumber() {
		return NeedNumber;
	}
	public void setNeedNumber(int needNumber) {
		NeedNumber = needNumber;
	}
	@Override
	public String toString() {
		return "Item [ID=" + ID + ", StuID=" + StuID + ", FirmID=" + FirmID + ", StuName=" + StuName + ", FirmName="
				+ FirmName + ", ItemName=" + ItemName + ", Addresss=" + Addresss + ", School=" + School + ", Intention="
				+ Intention + ", Number=" + Number + ", Tel=" + Tel + ", QQ=" + QQ + ", Email=" + Email + ", PatentNum="
				+ PatentNum + ", NeedDiscripe=" + NeedDiscripe + ", BusinessPlan=" + BusinessPlan + ", Descripe="
				+ Descripe + ", CheckStatus=" + CheckStatus + ", Status=" + Status + ", NeedNumber=" + NeedNumber + "]";
	}
	
	
	
	
}
