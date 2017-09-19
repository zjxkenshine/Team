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
 * Servlet implementation class teacher_register
 */
@WebServlet("/teacher_register.do")
public class teacher_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String TeacherName=request.getParameter("TeacherName");
		String Email=request.getParameter("Email");
		String PassWord=request.getParameter("PassWord");
		
		Teacher teacher=new Teacher();
		teacher.setTeacherName(TeacherName);
		teacher.setEmail(Email);
		teacher.setPassWord(PassWord);
		
		teacher_service ts=new teacher_service();
		try {
			ts.teacher_register(teacher);
			
			response.sendRedirect("Back/Public_register_reload.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Back/T_teacher_register.jsp").forward(request, response);
		}
	}

}
