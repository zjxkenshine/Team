package com.back.model;

public class Firm {
	private int ID;
	private String FirmName;
	private String PassWord;	
	private String Type;
	private String Area;
	private String Adress;
	private String LinkMan;
	private String Tel;
	private String Email;
	private String PeopleNumber;
	private String Des;
	private String FirmID;
	private String Picture;
	private String Logo;
	private String CardStart;
	private String Status;
	private String RecruitSum="3";
	
	
	
	@Override
	public String toString() {
		return "Firm [ID=" + ID + ", FirmName=" + FirmName + ", PassWord=" + PassWord + ", Type=" + Type + ", Area="
				+ Area + ", Adress=" + Adress + ", LinkMan=" + LinkMan + ", Tel=" + Tel + ", Email=" + Email
				+ ", PeopleNumber=" + PeopleNumber + ", Des=" + Des + ", FirmID=" + FirmID + ", Picture=" + Picture
				+ ", Logo=" + Logo + ", CardStart=" + CardStart + ", Status=" + Status + ", RecruitSum=" + RecruitSum
				+ "]";
	}
	public String getRecruitSum() {
		return RecruitSum;
	}
	public void setRecruitSum(String recruitSum) {
		RecruitSum = recruitSum;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCardStart() {
		return CardStart;
	}
	public void setCardStart(String cardStart) {
		CardStart = cardStart;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getFirmName() {
		return FirmName;
	}
	public void setFirmName(String firmName) {
		FirmName = firmName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getLinkMan() {
		return LinkMan;
	}
	public void setLinkMan(String linkMan) {
		LinkMan = linkMan;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPeopleNumber() {
		return PeopleNumber;
	}
	public void setPeopleNumber(String peopleNumber) {
		PeopleNumber = peopleNumber;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getFirmID() {
		return FirmID;
	}
	public void setFirmID(String firmID) {
		FirmID = firmID;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
    
	
}

