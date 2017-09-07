package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Resume;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentResumeManagerSetServlet
 */
@WebServlet("/StudentResumeManagerSet.sdo")
public class StudentResumeManagerSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentResumeManagerSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 简历投递管理初始化
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//执行
			List<Resume> lre=stus.queryallresumesend(stu.getID());
		//	System.out.println(lre);
			
			//传值跳转
			
			request.setAttribute("resumelist",lre);
			request.getRequestDispatcher("Back/student-resumeSendManage.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
