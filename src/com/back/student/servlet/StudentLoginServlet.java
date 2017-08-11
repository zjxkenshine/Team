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
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLogin.do")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//学生登录设置
		student_service stuse=new student_service();
		
		try{
			String stuid=request.getParameter("ID"); //获取ID
			//System.out.println(stuid);
			Student stu=stuse.queryOneStudent(stuid);
			HttpSession session = request.getSession(); //获取session
			session.setMaxInactiveInterval(30*60); //设置session时间
			session.setAttribute("student", stu); //存值进session
			response.sendRedirect("Back/student-index.jsp");  //跳转
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
