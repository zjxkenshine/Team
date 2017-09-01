package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentResumeSetServlet
 */
@WebServlet("/StudentResumeSet.sdo")
public class StudentResumeSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentResumeSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//学生简历列表初始化
		try{
			//初始化
			student_service stus=new student_service();
			
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			Student stu1=stus.queryOneStudent(String.valueOf(stu.getID()));
			
			//传值
			System.out.println(stu1.getResume());
			request.setAttribute("sturesume", stu1.getResume());
			request.getRequestDispatcher("Back/student-resume.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
