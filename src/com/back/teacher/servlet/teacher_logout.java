package com.back.teacher.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_logout
 */
@WebServlet("/teacher_logout.do")
public class teacher_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String TeacherName=(String) request.getSession().getAttribute("TeacherName");
		request.getSession().setAttribute("TeacherName", null);
		System.out.println("----------------"+TeacherName);
		request.getRequestDispatcher("Back/T_teacher_login.jsp").forward(request, response);

	    
	}

}
