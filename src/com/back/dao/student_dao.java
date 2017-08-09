package com.back.dao;

public class student_dao {
	private int ID;
	private String StudentName;
	private String PassWord;
	private String Sex;
	private int Age;
	private String Province;  //省份
	private String School;
	private String Academy; //学院
	private String Major;   //专业
	private String Home;    //籍贯
	private String tel;
	private String Email;
	private String ID_Card;
	private String picture;  //头像
	private String Resume;   //简历图片
	private String ResumeTime;
	private String Motto;   //左右銘
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
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
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
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
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getHome() {
		return Home;
	}
	public void setHome(String home) {
		Home = home;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getID_Card() {
		return ID_Card;
	}
	public void setID_Card(String iD_Card) {
		ID_Card = iD_Card;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getResume() {
		return Resume;
	}
	public void setResume(String resume) {
		Resume = resume;
	}
	public String getResumeTime() {
		return ResumeTime;
	}
	public void setResumeTime(String resumeTime) {
		ResumeTime = resumeTime;
	}
	public String getMotto() {
		return Motto;
	}
	public void setMotto(String motto) {
		Motto = motto;
	}
	@Override
	public String toString() {
		return "student_dao [ID=" + ID + ", StudentName=" + StudentName + ", PassWord=" + PassWord + ", Sex=" + Sex
				+ ", Age=" + Age + ", Province=" + Province + ", School=" + School + ", Academy=" + Academy + ", Major="
				+ Major + ", Home=" + Home + ", tel=" + tel + ", Email=" + Email + ", ID_Card=" + ID_Card + ", picture="
				+ picture + ", Resume=" + Resume + ", ResumeTime=" + ResumeTime + ", Motto=" + Motto + "]";
	}
	
	
	
}
