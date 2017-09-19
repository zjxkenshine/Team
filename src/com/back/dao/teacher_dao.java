package com.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.back.model.Message;
import com.back.model.TeaMessage;
import com.back.model.Teacher;
import com.back.model.Teacher_Stu_Messages;
import com.back.util.DBUtil;


public class teacher_dao {
	
	/**
	 * 教师后台登录
	 * @param TeacherCode
	 * @param PassWord
	 * @return
	 */
	public Teacher login(String TeacherName,String PassWord){
		String sql="select * from teacher where TeacherName=? and PassWord=?";
		Map<String,Object> map = DBUtil.query(sql, new Object[]{TeacherName,PassWord});
		if(map!=null&&map.size()!=0){
			Teacher teacher = new Teacher();
			teacher.setTeacherName((String) map.get(TeacherName));
			teacher.setPassWord((String) map.get(PassWord));
			return teacher;
		}else{
			return null;
		}				
	}
	
	/**
     * 根据登录名
     * 得用户基本信息
     * @param TeacherName
     * @return
     */
    public Teacher teacher_information(String TeacherName){
    	String sql="select * from teacher where TeacherName=?";
    	Map<String, Object> map=DBUtil.query(sql, TeacherName);
    	if(map!=null&&map.size()!=0){
    		Teacher teacher=new Teacher();
    		
    		teacher.setTeacherName((String) map.get("TeacherName"));
    		teacher.setSex((String) map.get("Sex"));
    		teacher.setAge((int) map.get("Age"));
    		teacher.setPicture((String) map.get("Picture"));
    		teacher.setEmail((String) map.get("Email"));
    		teacher.setSpeciality((String) map.get("Speciality"));
    		teacher.setDes((String) map.get("Des"));
    		teacher.setSchool((String) map.get("School"));
    		teacher.setAcademy((String) map.get("Academy"));
    		teacher.setQualificationCard((String) map.get("QualificationCard"));
    		teacher.setWorkCard((String) map.get("WorkCard"));
    		teacher.setStatus((String) map.get("Status"));
    		return teacher;
    	}else{
    		return null;
    	}
    }
    
    /**
     * 修改教师的基本信息
     * @param teacher_information
     */
    public void teacher_information_update(Teacher teacher){
    	String sql="update teacher set Sex=?,Picture=?,Age=?,Email=?,Speciality=?,Des=?,School=?,Academy=? where TeacherName=?";
    	DBUtil.executeUpdate(sql,new Object[]{teacher.getSex(),teacher.getPicture(),teacher.getAge(),teacher.getEmail(),teacher.getSpeciality(),teacher.getDes(),teacher.getSchool(),teacher.getAcademy(),teacher.getTeacherName()});   	
    }
    
    /**
	 * 教师注册
	 * @param New_teahcer
	 */
    public void teacher_register(Teacher teacher){
    	String sql="insert into teacher(TeacherName,Email,PassWord)values(?,?,?)";
    	DBUtil.executeUpdate(sql, new Object[]{teacher.getTeacherName(),teacher.getEmail(),teacher.getPassWord()});
    }
    
    /**
     * 判断教师注册邮箱是否重复
     * @param Email
     * @return
     */
    public int teacherEmail_check(String Email){
    	String sql="select count(*) as num from teacher where Email=?";
    	Map<String, Object> map=DBUtil.query(sql, Email);
    	int num=Integer.parseInt(map.get("num").toString());
    	return num;   	
    }
    
    /**
     * 上传教师认证资料
     * @param teacher_approve
     */
    public void teacher_approve(Teacher teacher){
    	String sql="update teacher set QualificationCard=?, WorkCard=?,Status='1' where TeacherName=?";
    	DBUtil.executeUpdate(sql,new Object[]{teacher.getQualificationCard(),teacher.getWorkCard(),teacher.getTeacherName()});   	
    }
    
    /**
     * 根据登录名
     * 得学生留言信息
     * @param TeacherName
     * @return stu_message
     */
    public List<Teacher_Stu_Messages> student_message(String TeacherName){
    	String sql="select * from teamessages where teacher_name=?";
    	List<Map<String, Object>> list=DBUtil.list(sql, TeacherName);
    	if(list!=null&&list.size()!=0){
    		List<Teacher_Stu_Messages> list_ts_message =new ArrayList<Teacher_Stu_Messages>();
    		for(Map<String,Object> map:list){
    			Teacher_Stu_Messages ts_message = new Teacher_Stu_Messages();
    			ts_message.setID((int) map.get("ID"));
	    		ts_message.setTeacher_name((String) map.get("teacher_name"));
	    		ts_message.setStu_name((String) map.get("stu_name"));
	    		ts_message.setStu_school((String) map.get("stu_school"));
	    		ts_message.setMessage((String) map.get("message"));
	    		ts_message.setDatetime((String) map.get("datetime"));
	    		ts_message.setReply((String) map.get("reply"));
	    		list_ts_message.add(ts_message);
    		}
    		return list_ts_message;
    	}else{
    		return null;
    	}
    }
    
    //查询学生消息
    public List<TeaMessage> queryStudentMessage(String name){
    	String sql="select * from teamessages where Type='1' and TeacherName=?";
    	List<Map<String, Object>> lmap=DBUtil.list(sql,name);
    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
    	if(lmap!=null){
    		for(Map<String, Object> map:lmap){
    			TeaMessage team=new TeaMessage();
    			team.setDate((String)map.get("Date"));
    			team.setID((int)map.get("ID"));
    			team.setMessage((String)map.get("Message"));
    			team.setReplyID((int)map.get("ReplyID"));
    			team.setStatus((String)map.get("Status"));
    			team.setStuID((int)map.get("StuID"));
    			team.setStuName((String)map.get("StuName"));
    			team.setStuPicture((String)map.get("StuPicture"));
    			team.setStuSchool((String)map.get("StuSchool"));
    			team.setTeacherName((String)map.get("TeacherName"));
    			team.setTecherID((int)map.get("TecherID"));
    			team.setType((String)map.get("Type"));
    			ltm.add(team);
    		}
    		return ltm;
    	}else{
    		return null;
    	}
    }
    
    //查询回复消息
    public List<TeaMessage> queryReplyMessage(String name){
    	String sql="select * from teamessages where Type='2' and TeacherName=?";
    	List<Map<String, Object>> lmap=DBUtil.list(sql,name);
    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
    	if(lmap!=null){
    		for(Map<String, Object> map:lmap){
    			TeaMessage team=new TeaMessage();
    			team.setDate((String)map.get("Date"));
    			team.setID((int)map.get("ID"));
    			team.setMessage((String)map.get("Message"));
    			team.setReplyID((int)map.get("ReplyID"));
    			team.setStatus((String)map.get("Status"));
    			team.setStuID((int)map.get("StuID"));
    			team.setStuName((String)map.get("StuName"));
    			team.setStuPicture((String)map.get("StuPicture"));
    			team.setStuSchool((String)map.get("StuSchool"));
    			team.setTeacherName((String)map.get("TeacherName"));
    			team.setTecherID((int)map.get("TecherID"));
    			team.setType((String)map.get("Type"));
    			ltm.add(team);
    		}
    		return ltm;
    	}else{
    		return null;
    	}
    }
    
 
    
    public TeaMessage queryReply(int replyID){
    	String sql="select * from teamessages where ID=?";
    	Map<String, Object> map=DBUtil.query(sql,replyID);
    	TeaMessage team=new TeaMessage();
		team.setDate((String)map.get("Date"));
		team.setID((int)map.get("ID"));
		team.setMessage((String)map.get("Message"));
		team.setReplyID((int)map.get("ReplyID"));
		team.setStatus((String)map.get("Status"));
		team.setStuID((int)map.get("StuID"));
		team.setStuName((String)map.get("StuName"));
		team.setStuPicture((String)map.get("StuPicture"));
		team.setStuSchool((String)map.get("StuSchool"));
		team.setTeacherName((String)map.get("TeacherName"));
		team.setTecherID((int)map.get("TecherID"));
		team.setType((String)map.get("Type"));
		return team;
    }
    
    /**
     * @param 导航页显示前三位老师信息
     * @return list_teacher
     */
    public List<Teacher> teacher_three(){
    	String sql="select * from teacher where Status='2' limit 0,1 ";
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Teacher> list_teacher =new ArrayList<Teacher>();
    		for(Map<String,Object> map:list){
    			Teacher teacher=new Teacher();
    			teacher.setID((int) map.get("ID"));
        		teacher.setTeacherName((String) map.get("TeacherName"));
        		teacher.setSex((String) map.get("Sex"));
        		teacher.setAge((int) map.get("Age"));
        		teacher.setPicture((String) map.get("Picture"));
        		teacher.setEmail((String) map.get("Email"));
        		teacher.setSpeciality((String) map.get("Speciality"));
        		teacher.setDes((String) map.get("Des"));
        		teacher.setSchool((String) map.get("School"));
        		teacher.setAcademy((String) map.get("Academy"));
        		teacher.setQualificationCard((String) map.get("QualificationCard"));
        		teacher.setWorkCard((String) map.get("WorkCard"));
        		teacher.setStatus((String) map.get("Status"));
        		list_teacher.add(teacher);
    		}
    		return list_teacher;
    	}else{
    		return null;
    	}
    }
    
    
    public List<Teacher> teacher_nextthree(){
    	String sql="select * from teacher where Status='2' limit 1,2 ";
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Teacher> list_teacher =new ArrayList<Teacher>();
    		for(Map<String,Object> map:list){
    			Teacher teacher=new Teacher();
    			teacher.setID((int) map.get("ID"));
        		teacher.setTeacherName((String) map.get("TeacherName"));
        		teacher.setSex((String) map.get("Sex"));
        		teacher.setAge((int) map.get("Age"));
        		teacher.setPicture((String) map.get("Picture"));
        		teacher.setEmail((String) map.get("Email"));
        		teacher.setSpeciality((String) map.get("Speciality"));
        		teacher.setDes((String) map.get("Des"));
        		teacher.setSchool((String) map.get("School"));
        		teacher.setAcademy((String) map.get("Academy"));
        		teacher.setQualificationCard((String) map.get("QualificationCard"));
        		teacher.setWorkCard((String) map.get("WorkCard"));
        		teacher.setStatus((String) map.get("Status"));
        		list_teacher.add(teacher);
    		}
    		return list_teacher;
    	}else{
    		return null;
    	}
    }
	
	
	
    /**
     * @param 所有老师信息
     * @return list_teacher
     */
    public List<Teacher> teacher_info(){
    	String sql="select * from teacher where Status='2' ";
    	List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Teacher> list_teacher =new ArrayList<Teacher>();
    		for(Map<String,Object> map:list){
    			Teacher teacher=new Teacher();
    			teacher.setID((int) map.get("ID"));
        		teacher.setTeacherName((String) map.get("TeacherName"));
        		teacher.setSex((String) map.get("Sex"));
        		teacher.setAge((int) map.get("Age"));
        		teacher.setPicture((String) map.get("Picture"));
        		teacher.setEmail((String) map.get("Email"));
        		teacher.setSpeciality((String) map.get("Speciality"));
        		teacher.setDes((String) map.get("Des"));
        		teacher.setSchool((String) map.get("School"));
        		teacher.setAcademy((String) map.get("Academy"));
        		teacher.setQualificationCard((String) map.get("QualificationCard"));
        		teacher.setWorkCard((String) map.get("WorkCard"));
        		teacher.setStatus((String) map.get("Status"));
        		list_teacher.add(teacher);
    		}
    		return list_teacher;
    	}else{
    		return null;
    	}
    }
    
    /**
     * 查询一位老师所有信息
     * @param ID,TeacherName
     * @return teacher
     */
    public Teacher teacher_singleinfo(int ID,String TeacherName){
    	String sql="select * from teacher where ID=? and TeacherName=? and Status='2'";
    	Map<String, Object> map=DBUtil.query(sql, new Object[]{ID,TeacherName});
    	if(map!=null&&map.size()!=0){
    		Teacher teacher=new Teacher();
    		teacher.setID((int) map.get("ID"));
    		teacher.setTeacherName((String) map.get("TeacherName"));
    		teacher.setSex((String) map.get("Sex"));
    		teacher.setAge((int) map.get("Age"));
    		teacher.setPicture((String) map.get("Picture"));
    		teacher.setEmail((String) map.get("Email"));
    		teacher.setSpeciality((String) map.get("Speciality"));
    		teacher.setDes((String) map.get("Des"));
    		teacher.setSchool((String) map.get("School"));
    		teacher.setAcademy((String) map.get("Academy"));
    		teacher.setQualificationCard((String) map.get("QualificationCard"));
    		teacher.setWorkCard((String) map.get("WorkCard"));
    		teacher.setStatus((String) map.get("Status"));
    		return teacher;
    	}else{
    		return null;
    	}
    }
    
    //查询一个老师
   public Teacher queryoneteacher(int ID){
	   String sql="select * from teacher where ID=? and Status='2'";
   	Map<String, Object> map=DBUtil.query(sql, new Object[]{ID});
   	if(map!=null&&map.size()!=0){
   		Teacher teacher=new Teacher();
   		teacher.setID((int) map.get("ID"));
   		teacher.setTeacherName((String) map.get("TeacherName"));
   		teacher.setSex((String) map.get("Sex"));
   		teacher.setAge((int) map.get("Age"));
   		teacher.setPicture((String) map.get("Picture"));
   		teacher.setEmail((String) map.get("Email"));
   		teacher.setSpeciality((String) map.get("Speciality"));
   		teacher.setDes((String) map.get("Des"));
   		teacher.setSchool((String) map.get("School"));
   		teacher.setAcademy((String) map.get("Academy"));
   		teacher.setQualificationCard((String) map.get("QualificationCard"));
   		teacher.setWorkCard((String) map.get("WorkCard"));
   		teacher.setStatus((String) map.get("Status"));
   		return teacher;
   	}else{
   		return null;
   	}
   }
   
   //查询一个老师
   public Teacher queryoneteacher(String TeacherName){
	   String sql="select * from teacher where TeacherName=? ";
   	Map<String, Object> map=DBUtil.query(sql, new Object[]{TeacherName});
   	if(map!=null&&map.size()!=0){
   		Teacher teacher=new Teacher();
   		teacher.setID((int) map.get("ID"));
   		teacher.setTeacherName((String) map.get("TeacherName"));
   		teacher.setSex((String) map.get("Sex"));
   		teacher.setAge((int) map.get("Age"));
   		teacher.setPicture((String) map.get("Picture"));
   		teacher.setEmail((String) map.get("Email"));
   		teacher.setSpeciality((String) map.get("Speciality"));
   		teacher.setDes((String) map.get("Des"));
   		teacher.setSchool((String) map.get("School"));
   		teacher.setAcademy((String) map.get("Academy"));
   		teacher.setQualificationCard((String) map.get("QualificationCard"));
   		teacher.setWorkCard((String) map.get("WorkCard"));
   		teacher.setStatus((String) map.get("Status"));
   		return teacher;
   	}else{
   		return null;
   	}
   }


	public List<Teacher> querytuijianteacher() {
		//查询推荐老师
		String sql="select * from teacher where Status='2' limit 0,8";
		List<Map<String, Object>> list=DBUtil.list(sql);
    	if(list!=null&&list.size()!=0){
    		List<Teacher> list_teacher =new ArrayList<Teacher>();
    		for(Map<String,Object> map:list){
    			Teacher teacher=new Teacher();
    			teacher.setID((int) map.get("ID"));
        		teacher.setTeacherName((String) map.get("TeacherName"));
        		teacher.setSex((String) map.get("Sex"));
        		teacher.setAge((int) map.get("Age"));
        		teacher.setPicture((String) map.get("Picture"));
        		teacher.setEmail((String) map.get("Email"));
        		teacher.setSpeciality((String) map.get("Speciality"));
        		teacher.setDes((String) map.get("Des"));
        		teacher.setSchool((String) map.get("School"));
        		teacher.setAcademy((String) map.get("Academy"));
        		teacher.setQualificationCard((String) map.get("QualificationCard"));
        		teacher.setWorkCard((String) map.get("WorkCard"));
        		teacher.setStatus((String) map.get("Status"));
        		list_teacher.add(teacher);
    		}
    		return list_teacher;
    	}else{
    		return null;
    	}
		
	}
	
	//更新留言
	public int addLeaveMessage(TeaMessage team){
		String sql="insert into teamessages(StuID,StuName,StuPicture,StuSchool,TecherID,TeacherName,Message,Date,Type,Status,ReplyID) values(?,?,?,?,?,?,?,?,?,?,?)";
		int i=DBUtil.executeUpdate(sql,new Object[]{team.getStuID(),team.getStuName(),team.getStuPicture(),team.getStuSchool(),team.getTecherID(),team.getTeacherName(),team.getMessage(),team.getDate(),team.getType(),team.getStatus(),team.getReplyID()});
		return i;
	}
	
	//查询老师消息
	public List<TeaMessage> queryTeacherMessage(int id) {
		String sql="select * from teamessages where Type='2' and StuID=?";
    	List<Map<String, Object>> lmap=DBUtil.list(sql,id);
    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
    	if(lmap!=null){
    		for(Map<String, Object> map:lmap){
    			TeaMessage team=new TeaMessage();
    			team.setDate((String)map.get("Date"));
    			team.setID((int)map.get("ID"));
    			team.setMessage((String)map.get("Message"));
    			team.setReplyID((int)map.get("ReplyID"));
    			team.setStatus((String)map.get("Status"));
    			team.setStuID((int)map.get("StuID"));
    			team.setStuName((String)map.get("StuName"));
    			team.setStuPicture((String)map.get("StuPicture"));
    			team.setStuSchool((String)map.get("StuSchool"));
    			team.setTeacherName((String)map.get("TeacherName"));
    			team.setTecherID((int)map.get("TecherID"));
    			team.setType((String)map.get("Type"));
    			ltm.add(team);
    		}
    		return ltm;
    	}else{
    		return null;
    	}
	}
	
	
	//查询学生回复
		public List<TeaMessage> queryStudentReplyTeacher(int id) {
			String sql="select * from teamessages where Type='1' and StuID=?";
	    	List<Map<String, Object>> lmap=DBUtil.list(sql,id);
	    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
	    	if(lmap!=null){
	    		for(Map<String, Object> map:lmap){
	    			TeaMessage team=new TeaMessage();
	    			team.setDate((String)map.get("Date"));
	    			team.setID((int)map.get("ID"));
	    			team.setMessage((String)map.get("Message"));
	    			team.setReplyID((int)map.get("ReplyID"));
	    			team.setStatus((String)map.get("Status"));
	    			team.setStuID((int)map.get("StuID"));
	    			team.setStuName((String)map.get("StuName"));
	    			team.setStuPicture((String)map.get("StuPicture"));
	    			team.setStuSchool((String)map.get("StuSchool"));
	    			team.setTeacherName((String)map.get("TeacherName"));
	    			team.setTecherID((int)map.get("TecherID"));
	    			team.setType((String)map.get("Type"));
	    			ltm.add(team);
	    		}
	    		return ltm;
	    	}else{
	    		return null;
	    	}
		}

		//查询所有留言
		public int getTeaMessageCount(int id) {
			String sql="select * from teamessages where TecherID=? and Status='0'";
			List<Map<String, Object>> lmap=DBUtil.list(sql,id);
			return lmap.size();
		}
		
		//查询所有留言
		public List<TeaMessage> queryallleavecomment(int id) {
			String sql="select * from teamessages where Status='0' and TecherID=?";
	    	List<Map<String, Object>> lmap=DBUtil.list(sql,id);
	    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
	    	if(lmap!=null){
	    		for(Map<String, Object> map:lmap){
	    			TeaMessage team=new TeaMessage();
	    			team.setDate((String)map.get("Date"));
	    			team.setID((int)map.get("ID"));
	    			team.setMessage((String)map.get("Message"));
	    			team.setReplyID((int)map.get("ReplyID"));
	    			team.setStatus((String)map.get("Status"));
	    			team.setStuID((int)map.get("StuID"));
	    			team.setStuName((String)map.get("StuName"));
	    			team.setStuPicture((String)map.get("StuPicture"));
	    			team.setStuSchool((String)map.get("StuSchool"));
	    			team.setTeacherName((String)map.get("TeacherName"));
	    			team.setTecherID((int)map.get("TecherID"));
	    			team.setType((String)map.get("Type"));
	    			ltm.add(team);
	    		}
	    		return ltm;
	    	}else{
	    		return null;
	    	}
		}
		
		//查询所有留言的第一条回复
				public List<TeaMessage> queryreplyleavecomment(int id) {
					String sql="select * from teamessages where Status='1' and TecherID=?";
			    	List<Map<String, Object>> lmap=DBUtil.list(sql,id);
			    	List<TeaMessage> ltm=new ArrayList<TeaMessage>();
			    	if(lmap!=null){
			    		for(Map<String, Object> map:lmap){
			    			TeaMessage team=new TeaMessage();
			    			team.setDate((String)map.get("Date"));
			    			team.setID((int)map.get("ID"));
			    			team.setMessage((String)map.get("Message"));
			    			team.setReplyID((int)map.get("ReplyID"));
			    			team.setStatus((String)map.get("Status"));
			    			team.setStuID((int)map.get("StuID"));
			    			team.setStuName((String)map.get("StuName"));
			    			team.setStuPicture((String)map.get("StuPicture"));
			    			team.setStuSchool((String)map.get("StuSchool"));
			    			team.setTeacherName((String)map.get("TeacherName"));
			    			team.setTecherID((int)map.get("TecherID"));
			    			team.setType((String)map.get("Type"));
			    			ltm.add(team);
			    		}
			    		return ltm;
			    	}else{
			    		return null;
			    	}
				}
				
				//查询系统消息
				public List<Message> queryTeaSystemMessage(String name) {
					String sql="select * from message where Receive=? and Type='教师'";
					List<Map<String,Object>> lmap=DBUtil.list(sql,name);
					List<Message> lmsg=new ArrayList<Message>();
					if(lmap!=null){
						for(Map<String,Object> map:lmap){
							Message msg=new Message();
							msg.setContent((String)map.get("Content"));
							msg.setDate((String)map.get("Date"));
							msg.setID((int)map.get("ID"));
							msg.setType((String)map.get("Type"));
							msg.setReceive((String)map.get("Receive"));
							lmsg.add(msg);
						}
						return lmsg;
					}else{
						return null;
					}
				}
    

}
