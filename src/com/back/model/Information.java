package com.back.model;

public class Information {

	private int ID;
	private String Title;
	private String Date;
	private int Skimtime;
	private String Sourse;
	private String Author;
	private String Content;
	private String Picture;
	private String Type;
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getSkimtime() {
		return Skimtime;
	}
	public void setSkimtime(int skimtime) {
		Skimtime = skimtime;
	}
	public String getSourse() {
		return Sourse;
	}
	public void setSourse(String sourse) {
		Sourse = sourse;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Information [ID=" + ID + ", Title=" + Title + ", Date=" + Date + ", Skimtime=" + Skimtime + ", Sourse="
				+ Sourse + ", Author=" + Author + ", Content=" + Content + ", Picture=" + Picture + ", Type=" + Type
				+ "]";
	}
	
}
