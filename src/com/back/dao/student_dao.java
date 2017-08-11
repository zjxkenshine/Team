package com.back.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.back.model.Student;
import com.back.util.DBUtil;

public class student_dao {
	
	//登录验证
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
	
	//根据ID查询学生信息
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
			stu.setRegisterTime((String)map.get("RegisterTime"));
			stu.setRealName((String)map.get("RealName"));
			stu.setRegisterStatus((String)map.get("RegisterStatus"));
		}
		return stu;
	}
	
	//学生注册验证
	public boolean checkStudentRegister(String name,String value){
		String sql="select * from student where "+name+"=?";
		System.out.println(sql);
		Map<String,Object> map =DBUtil.query(sql, value);
		if(map.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//添加注册学生
	public int addRegisterStudent(Student stu){
		String sql ="insert into student(StudentName,PassWord,Tel,Email,RegisterStatus,Status,RegisterTime) values(?,?,?,?,?,?,?)";
		int i=DBUtil.executeUpdate(sql, new Object[]{stu.getStudentName(),stu.getPassWord(),stu.getTel(),stu.getEmail(),stu.getRegisterStatus(),stu.getStatus(),stu.getRegisterTime()});
		return i;
	}
	
	//注册成功解封账号
	public int studentRegisterUpdate(String Email){
		String sql="update student set Status='1',RegisterStatus='1' where Email=? and RegisterStatus='0'";
		int i=DBUtil.executeUpdate(sql,Email);
		return i;
	}
	
	//忘记密码邮箱验证
	public boolean checkForgetPasswordEmail(String Email){
		String sql="select ID from student where Email=?";
		List<Map<String,Object>> stulist=DBUtil.list(sql,Email);
		if(stulist.size()==1){
			return true;
		}else{
			return false;
		}
	}
	
	//忘记密码身份验证
	public String checkForgetPassword(String Email,String StudentName,String Tel){
		String sql="select PassWord from student where (Email=? and Tel=?) or (Email=? and StudentName=?)";
		List<Map<String,Object>> stulist=DBUtil.list(sql,new Object[]{Email,Tel,Email,StudentName});
		if(stulist.size()==1){
			return (String) stulist.get(0).get("PassWord");
		}else{
			return null;
		}
	}
	
	
}
