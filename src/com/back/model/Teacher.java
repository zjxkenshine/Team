package com.back.model;

public class Teacher {
	
	@Override
	public String toString() {
		return "Teacher [ID=" + ID + ", TeacherCode=" + TeacherCode + ", PassWord=" + PassWord + ", TeacherName="
				+ TeacherName + ", Sex=" + Sex + ", Age=" + Age + ", Picture=" + Picture + ", Email=" + Email
				+ ", Speciality=" + Speciality + ", Des=" + Des + ", School=" + School + ", Academy=" + Academy
				+ ", QualificationCard=" + QualificationCard + ", WorkCard=" + WorkCard + ", Status=" + Status + "]";
	}
	/*
	 *教师个人信息 
	*/
	private int ID;
	private String TeacherCode;
	private String PassWord;
	private String TeacherName;
	private String Sex;
	private int Age;
	private String Picture;
	private String Email;
	private String Speciality;
	private String Des;
	private String School;
	private String Academy;
	private String QualificationCard;
	private String WorkCard;
	private String Status;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTeacherCode() {
		return TeacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		TeacherCode = teacherCode;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public String getAcademy() {
		return Academy;
	}
	public void setAcademy(String academy) {
		Academy = academy;
	}
	public String getQualificationCard() {
		return QualificationCard;
	}
	public void setQualificationCard(String qualificationCard) {
		QualificationCard = qualificationCard;
	}
	public String getWorkCard() {
		return WorkCard;
	}
	public void setWorkCard(String workCard) {
		WorkCard = workCard;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
