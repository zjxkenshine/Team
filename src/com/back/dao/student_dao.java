package com.back.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.back.model.Student;
import com.back.util.DBUtil;

public class student_dao {
	
	public Map<String,Object> loginCheck(String user,String password){
		String sql="select * from student where (StudentName=? and PassWord=?) or (Tel=? and PassWord=?) or (Email=? and PassWord=?)";
		System.out.println(sql);
		List<Map<String,Object>> stulist=DBUtil.list(sql,new Object[]{user,password,user,password,user,password});
		Map<String,Object> mesg=new HashMap<String,Object>();
		if(stulist.size()>1){
			mesg.put("flag",0);
			mesg.put("msg","登录失败，您的用户名密码与他人冲突，建议您修改密码或修改登录方式！" );
		}else if(stulist.size()==1){
			String stu=(String)stulist.get(0).get("Status");
			if (stu.equals("1")){
				mesg.put("flag", 1);
				mesg.put("msg","登陆成功！");
				mesg.put("stuid",(int) stulist.get(0).get("ID"));
			}else{
				mesg.put("flag",0);
				mesg.put("msg","登录失败,该账号已被冻结！");
			}
			
		}else if(stulist.size()<1){
			mesg.put("flag",0);
			mesg.put("msg","登录失败,账号或密码错误！");
		}
		return mesg;
		
	}
	
	
	public Student queryOneStudent(String stuid){
		Student stu= new Student();
		String sql ="select * from student where ID=?";
		Map<String,Object> map=DBUtil.query(sql, stuid);
		if(map!=null){
			//把值存进Student类
			stu.setAcademy((String)map.get("Academy"));
			stu.setAge((int)map.get("Age"));
			stu.setEducationBgd((String)map.get("EducationBgd"));
			stu.setEmail((String)map.get("Email"));
			stu.setHome((String)map.get("Home"));
			stu.setID((int)map.get("ID"));
			stu.setID_Card((String)map.get("ID_Card"));
			stu.setIntention((String)map.get("Intention"));
			stu.setMajor((String)map.get("Major"));
			stu.setMotto((String)map.get("Motto"));
			stu.setPassWord((String)map.get("PassWord"));
			stu.setPicture((String)map.get("Picture"));
			stu.setProvince((String)map.get("Province"));
			stu.setResume((String)map.get("Resume"));
			stu.setResumeTime((String)map.get("ResumeTime"));
			stu.setSchool((String)map.get("School"));
			stu.setSex((String)map.get("Sex"));
			stu.setStatus((String)map.get("Status"));
			stu.setStudentName((String)map.get("StudentName"));
			stu.setTel((String)map.get("Tel"));
		}
		return stu;
	}
	
	
	
	
}
