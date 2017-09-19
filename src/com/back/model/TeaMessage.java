package com.back.model;

public class TeaMessage {
	//教师页面评论表
	private int ID;
	private int StuID;
	private String StuName;
	private String StuPicture;
	private String StuSchool;
	private int TecherID;
	private String TeacherName;
	private String Message; //消息内容
	private String Date;
	private String Type;    //类型：1:学生回复老师 2:老师回复学生
	private String Status;  //显示字段 0,1,2
	private int ReplyID;
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
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getStuPicture() {
		return StuPicture;
	}
	public void setStuPicture(String stuPicture) {
		StuPicture = stuPicture;
	}
	public String getStuSchool() {
		return StuSchool;
	}
	public void setStuSchool(String stuSchool) {
		StuSchool = stuSchool;
	}
	public int getTecherID() {
		return TecherID;
	}
	public void setTecherID(int techerID) {
		TecherID = techerID;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getReplyID() {
		return ReplyID;
	}
	public void setReplyID(int replyID) {
		ReplyID = replyID;
	}
	@Override
	public String toString() {
		return "TeaMessage [ID=" + ID + ", StuID=" + StuID + ", StuName=" + StuName + ", StuPicture=" + StuPicture
				+ ", StuSchool=" + StuSchool + ", TecherID=" + TecherID + ", TeacherName=" + TeacherName + ", Message="
				+ Message + ", Date=" + Date + ", Type=" + Type + ", Status=" + Status + ", ReplyID=" + ReplyID + "]";
	} 
	
	

}
