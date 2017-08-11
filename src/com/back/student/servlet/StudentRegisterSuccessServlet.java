package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.student_service;

/**
 * Servlet implementation class StudentRegisterSuccessServlet
 */
@WebServlet("/StudentRegisterSuccess.do")
public class StudentRegisterSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//邮箱验证成功后账号解封
		try{
			//初始化
			student_service stus= new student_service();
			
			//取值
			String Email = request.getParameter("Email");
			stus.studentRegisterUpdate(Email);
			
			//跳转
			response.sendRedirect("Back/student-registerSuccess.jsp");
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
