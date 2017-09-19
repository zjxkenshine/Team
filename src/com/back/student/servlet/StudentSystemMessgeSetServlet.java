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
 * Servlet implementation class StudentSystemMessgeSetServlet
 */
@WebServlet("/StudentSystemMessgeSet.sdo")
public class StudentSystemMessgeSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSystemMessgeSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//系统消息
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//查询
			List<Message> lmsg=stus.queryStudentSystemMessage(stu.getStudentName());
		//	System.out.println(lmsg);
			
			//传值
			request.setAttribute("msglist",lmsg);
			
			//跳转
			request.getRequestDispatcher("Back/student-systemMessage.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
