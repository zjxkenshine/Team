package com.back.service;

import java.util.List;
import java.util.Map;

import com.back.dao.student_dao;
import com.back.model.Student;
import com.back.model.Student_Province;

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

	public int updateStudentLoginMessage(String now,int num,String id) throws Exception{
		try{
			int i= sda.updateStudentLoginMessage(now,num,id);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生登录信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生登录信息失败，原因是："+e.getMessage());
		}
	}
	
	public int updateStudentPassword(String stuid,String password) throws Exception{
		try{
			int i= sda.updateStudentPassword(stuid,password);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生密码条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生密码失败，原因是："+e.getMessage());
		}
	}
	
	public List<Student_Province> queryProvinceAll() throws Exception{
		try{
			return sda.queryProvinceAll();
		}catch(Exception e){
			throw new Exception("查询省份信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Map<String,Object>> queryUniversity(String province) throws Exception{
		try{
			return sda.queryUniversity(province);
		}catch(Exception e){
			throw new Exception("查询学校信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Map<String,Object>> queryAcademy(String school) throws Exception{
		try{
			return sda.queryAcademy(school);
		}catch(Exception e){
			throw new Exception("查询学院信息失败，原因是："+e.getMessage());
		}
	}
	
	public int updateStudentSchool(String province,String school,String academy,String major,int stuid) throws Exception{
		try{
			int i= sda.updateStudentSchool(province,school,academy,major,stuid);
			if(i>0){
				return i;
			}else{
				throw new Exception("更新学生学校信息条数为0");
			}
		}catch(Exception e){
			throw new Exception("更新学生学校信息失败，原因是："+e.getMessage());
		}
	}
}
