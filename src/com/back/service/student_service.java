package com.back.service;

import java.util.Map;

import com.back.dao.student_dao;
import com.back.model.Student;

public class student_service {
	student_dao sda=new student_dao();
	Student stu=new Student();

	public Map<String,Object> loginCheck(String user,String password) throws Exception{
		try{
			return sda.loginCheck(user, password);
		}catch(Exception e){
			throw new Exception("查询学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public Student queryOneStudent(String stuid) throws Exception{
		try{
			return sda.queryOneStudent(stuid);
		}catch(Exception e){
			throw new Exception("查询学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public boolean checkStudentRegister(String name,String value) throws Exception{
		try{
			return sda.checkStudentRegister(name,value);
		}catch(Exception e){
			throw new Exception("验证学生信息失败，原因是："+e.getMessage());
		}
	}
	
	public int addRegisterStudent(Student stu) throws Exception{
		try{
			int i= sda.addRegisterStudent(stu);
			if(i>0){
				return i;
			}else{
				throw new Exception("插入信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("添加学生信息失败，原因是："+e.getMessage());
		}
	}
	
	
	public int studentRegisterUpdate(String Email) throws Exception{
		try{
			int i= sda.studentRegisterUpdate(Email);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生账号信息失败，原因是："+e.getMessage());
		}
	}
	
	
	public boolean checkForgetPasswordEmail(String Email) throws Exception{
		try{
			return sda.checkForgetPasswordEmail(Email);
		}catch(Exception e){
			throw new Exception("忘记密码验证邮箱失败，原因是："+e.getMessage());
		}
	}
	
	
	public String checkForgetPassword(String Email,String StudentName,String Tel) throws Exception{
		try{
			return sda.checkForgetPassword(Email,StudentName,Tel);
		}catch(Exception e){
			throw new Exception("忘记密码身份验证失败，原因是："+e.getMessage());
		}
	}

	

}
