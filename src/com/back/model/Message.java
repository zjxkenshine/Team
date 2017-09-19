package com.back.model;

public class Message {
	private int ID;
	private String Content;
	private String Type;
	private String Date;
	private String Receive;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getReceive() {
		return Receive;
	}
	public void setReceive(String receive) {
		Receive = receive;
	}
	@Override
	public String toString() {
		return "Message [ID=" + ID + ", Content=" + Content + ", Type=" + Type + ", Date=" + Date + ", Receive="
				+ Receive + "]";
	}
	
	
	
}
