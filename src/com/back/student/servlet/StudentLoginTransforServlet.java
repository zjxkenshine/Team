package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Message;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentLoginTransforServlet
 */
@WebServlet("/StudentLoginTransform.sdo")
public class StudentLoginTransforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginTransforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//登录过渡
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//查询系统邮件
			List<Message> lmsg=stus.queryStudentSystemMessage(stu.getStudentName());
			
			//存值
			request.setAttribute("systmsgnum", lmsg.size());
			
			//跳转
			request.getRequestDispatcher("Back/student-index.jsp").forward(request, response);//跳转
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
