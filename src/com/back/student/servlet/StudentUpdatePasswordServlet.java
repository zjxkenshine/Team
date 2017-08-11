package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.student_service;

/**
 * Servlet implementation class StudentUpdatePasswordServlet
 */
@WebServlet("/StudentUpdatePassword.sdo")
public class StudentUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 修改个人密码
		try{
			//初始化
			student_service stus =new student_service();
			
			//取值
			String stuid=request.getParameter("ID");
			String password=request.getParameter("password");
	//		System.out.println(stuid+","+password);
			
			//修改密码
			stus.updateStudentPassword(stuid,password);
			
			
			//跳转至成功页面
			response.sendRedirect("Back/student-updatePasswordSuccess.jsp");
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
