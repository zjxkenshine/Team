package com.back.service;

import java.util.List;

import com.back.dao.teacher_dao;
import com.back.model.Message;
import com.back.model.TeaMessage;
import com.back.model.Teacher;
import com.back.model.Teacher_Stu_Messages;

public class teacher_service {
	teacher_dao td = new teacher_dao();
	
	/**
	 * 
	 * @param TeacherName
	 * @param PassWord
	 * @return teacher
	 * @throws Exception
	 */
	public Teacher login(String TeacherName,String PassWord) throws Exception{
		Teacher teacher = td.login(TeacherName, PassWord);
		if(teacher!=null){
			return teacher;
		}else{
			throw new Exception("教师登录账号或密码错误！");
		}
	}
	
	/**
	 * 根据登录名
     * 得到教师相关信息
	 * @param TeacherName
	 * @return teacher
	 * @throws Exception
	 */
	public Teacher teacher_information(String TeacherName) throws Exception{
		try {
			return td.teacher_information(TeacherName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	/**
	 * 修改教师基本信息
	 * @param teacher
	 * @throws Exception
	 */
	public void teacher_information_update(Teacher teacher) throws Exception{
		try {
			td.teacher_information_update(teacher);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("修改基本信息失败，原因是："+e.getMessage());
		}
	}
	
	/**
	 * 教师注册
	 * @param teacher
	 * @throws Exception
	 */
	public void teacher_register(Teacher teacher) throws Exception{
		try {
			td.teacher_register(teacher);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("教师注册失败，原因是 ："+e.getMessage());
		}
	}
	
	/**
	 * 统计教师名称相同的数目
	 * @param TeacherName
	 * @return
	 * @throws Exception
	 */
	public int teacherEmail_check(String Email) throws Exception{
		try {
			return td.teacherEmail_check(Email);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取教师邮箱失败，原因是："+e.getMessage());
		}
	}
	
	/**
	 * 上传验证信息
	 * @param teacher
	 * @throws Exception
	 */
	public void teacher_approve(Teacher teacher) throws Exception{
		try {
			td.teacher_approve(teacher);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("上传资料失败，原因是："+e.getMessage());
		}
	}
	
	/**
	 * 根据登录名
     * 得到学生留言信息
	 * @param TeacherName
	 * @return stu_message
	 * @throws Exception
	 */
	public List<Teacher_Stu_Messages> student_message(String TeacherName) throws Exception{
		try {
			return td.student_message(TeacherName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	//查询学生消息
	public List<TeaMessage> queryStudentMessage(String name) throws Exception{
		try {
			return td.queryStudentMessage(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取回复信息失败，原因是："+e.getMessage());
		}
	}
	
	//查询学生消息
	public List<TeaMessage> queryReplyMessage(String name) throws Exception{
		try {
			return td.queryReplyMessage(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取回复信息失败，原因是："+e.getMessage());
		}
	}
	
	//查询一条信息
	public TeaMessage queryReply(int replyID) throws Exception{
		try {
			return td.queryReply(replyID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("获取回复消息失败，原因是："+e.getMessage());
		}
	}
	
	/**
     * 导航页显示前三位教师信息
	 * @param TeacherName
	 * @return list_teacher
	 * @throws Exception
	 */
	public List<Teacher> teacher_three() throws Exception{
		try {
			return td.teacher_three();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	public List<Teacher> teacher_nextthree() throws Exception{
		try {
			return td.teacher_nextthree();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	/**
     * 得到所有教师信息
	 * @param TeacherName
	 * @return list_teacher
	 * @throws Exception
	 */
	public List<Teacher> teacher_info() throws Exception{
		try {
			return td.teacher_info();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	/**
     * 得到一位教师信息
	 * @param TeacherName
	 * @return teacher
	 * @throws Exception
	 */
	public Teacher teacher_singleinfo(int ID,String TeacherName) throws Exception{
		try {
			return td.teacher_singleinfo(ID,TeacherName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}

	//查询推荐导师
	public List<Teacher> querytuijianteacher() throws Exception {
		try {
			return td.querytuijianteacher();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("获取教师信息失败，原因是："+e.getMessage());
		}
	}
	
	
	//查询一个老师
	 public Teacher queryoneteacher(int ID) throws Exception{
		 try {
				return td.queryoneteacher(ID);
			} catch (Exception e) {
				throw new Exception("获取教师信息失败，原因是："+e.getMessage());
			}
	 }
	 
	 //添加留言
	 public int addLeaveMessage(TeaMessage team) throws Exception{
		 try {
				return td.addLeaveMessage(team);
			} catch (Exception e) {
				throw new Exception("插入留言失败，原因是："+e.getMessage());
			}
	 }
	 
	 public Teacher queryoneteacher(String TeacherName) throws Exception{
		 try {
				return td.queryoneteacher(TeacherName);
			} catch (Exception e) {
				throw new Exception("查询老师失败，原因是："+e.getMessage());
			}
	 }

	public List<TeaMessage> queryTeacherMessage(int id) throws Exception {
		 try {
				return td.queryTeacherMessage(id);
			} catch (Exception e) {
				throw new Exception("查询老师消息失败，原因是："+e.getMessage());
			}
	}
	
	public List<TeaMessage> queryStudentReplyTeacher(int id) throws Exception {
		 try {
				return td.queryStudentReplyTeacher(id);
			} catch (Exception e) {
				throw new Exception("查询学生回复失败，原因是："+e.getMessage());
			}
		
	}

	public int getTeaMessageCount(int id) throws Exception {
		 try {
				return td.getTeaMessageCount(id);
			} catch (Exception e) {
				throw new Exception("查询学生回复失败，原因是："+e.getMessage());
			}
	}
	
	public List<TeaMessage> queryreplyleavecomment(int id) throws Exception {
		try {
			return td.queryreplyleavecomment(id);
		} catch (Exception e) {
			throw new Exception("查询学生回复失败，原因是："+e.getMessage());
		}
	}
	
	public List<TeaMessage> queryallleavecomment(int id) throws Exception {
		try {
			return td.queryallleavecomment(id);
		} catch (Exception e) {
			throw new Exception("查询学生回复失败，原因是："+e.getMessage());
		}
	}
	
	public List<Message> queryTeaSystemMessage(String name) throws Exception{
		try {
			return td.queryTeaSystemMessage(name);
		} catch (Exception e) {
			throw new Exception("查询系统消息失败，原因是："+e.getMessage());
		}
	}
}
