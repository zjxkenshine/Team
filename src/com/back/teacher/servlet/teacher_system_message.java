package com.back.teacher.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Message;
import com.back.service.teacher_service;

/**
 * Servlet implementation class student_system_message
 */
@WebServlet("/student_system_message.do")
public class teacher_system_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_system_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 教师系统消息
		try{
			//初始化
			teacher_service teas=new teacher_service();
			
			//获取教师姓名
			String TeacherName=(String) request.getSession().getAttribute("TeacherName");
			
			//查询消息
			List<Message> lm=teas.queryTeaSystemMessage(TeacherName);
			
			//传值
			request.setAttribute("msglist",lm);
			
			//跳转
			request.getRequestDispatcher("Back/T_teacher_systemmessage.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
