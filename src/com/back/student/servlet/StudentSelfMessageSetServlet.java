package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentSelfMessageSetServlet
 */
@WebServlet("/StudentSelfMessageSet.sdo")
public class StudentSelfMessageSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelfMessageSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 个人信息初始化
		try{
			//初始化
			student_service stus=new student_service();
			HttpSession session = request.getSession(); //获取session
			
			//取值
			Student stu=(Student)request.getSession().getAttribute("student");
			String ID=String.valueOf(stu.getID());
			Student stu1=stus.queryOneStudent(ID);
			
			session.setMaxInactiveInterval(30*60); //设置session时间
			session.setAttribute("student", stu1); //存值进session
			request.getRequestDispatcher("Back/student-selfMessage.jsp").forward(request, response);		
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
