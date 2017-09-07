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
 * Servlet implementation class StudentUpdateIntentionServlet
 */
@WebServlet("/StudentSetIntention.sdo")
public class StudentSetIntentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSetIntentionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 更新职业意向
				try{
					//初始化
					student_service stus=new student_service();
					
					//接值
					Student stu=(Student) request.getSession().getAttribute("student");
					String intention=request.getParameter("MajorID_22");
					//System.out.println(intention);
					
					//存值
					stus.updateIntention(intention, stu.getID());
					
					//传值
					request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
					
				}catch(Exception e){
					request.setAttribute("message",e.getMessage());	
					request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
				}
	}

}
